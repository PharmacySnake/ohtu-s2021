package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = invalid(username, password, passwordConfirmation);

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }

    private CreationStatus invalid(String username, String password, String passwordConfirmation) {
        // validity check of username and password
        CreationStatus status = new CreationStatus();

        if (userDao.findByName(username) != null) status.addError("username already taken");
        if (username.length() < 3) status.addError("username should have at least 3 characters");
        if (invalidUsername(username)) status.addError("username should only contain letters of the alphabet");

        if (!password.equals(passwordConfirmation)) status.addError("password and password confirmation do not match");
        if (password.length() < 8) status.addError("password should have at least 8 characters");
        if (invalidPassword(password)) status.addError("password cannot contain only letters of the alphabet");

        return status;
    }

    private boolean invalidUsername(String username) {
        for (int i = 0; i < username.length(); i++) {
            if (!Character.isLetter(username.charAt(i))) return true;
        }

        return false;
    }

    private boolean invalidPassword(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) return false;
        }

        return true;
    }

}
