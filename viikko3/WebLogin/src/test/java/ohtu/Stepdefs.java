package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    }    
    
    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        invalidLogin();
    }
    
    @When("username {string} and password {string} are given")
    public void usernameAndPasswordAreGiven(String username, String password) throws Throwable {
        logInWith(username, password);
    }   
    
    @Then("system will respond {string}")
    public void systemWillRespond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("invalid username {string} and some password {string} are given")
    public void invalidUsernameIsGiven(String username, String password) {
        logInWith(username, password);
    }

    @Then("user is not found so an error message is given")
    public void usernameNotFoundErrorGiven() {
        invalidLogin();
    }

    /**
     * new account
     */
    @Given("command new user is selected")
    public void commandNewUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void newAccountValid(String username, String password) {
        newAccount(username, password, password);
    }

    @Then("a new user is created")
    public void newUserCreated() {
        assertTrue(driver.getPageSource().contains("Welcome to Ohtu Application!"));
    }

    @When("an invalid username {string} and valid password {string} and matching password confirmation are entered")
    public void newAccountTooShortUsername(String username, String password) {
        newAccount(username, password, password);
    }

    @Then("user is not created and error {string} is reported")
    public void userNotCreatedTooShortUsername(String error) {
        assertTrue(driver.getPageSource().contains(error));
    }

    @When("username {string} is valid but password {string} is too short")
    public void newAccountTooShortPassword(String username, String password) {
        newAccount(username, password, password);
    }

    @Then("user cannot be created and error {string} is reported")
    public void userNotCreatedTooShortPassword(String error) {
        assertTrue(driver.getPageSource().contains(error));
    }

    @When("a valid username {string} is given but password {string} and password confirmation {string} do not match")
    public void newAccountNoMatchPasswordAndPasswordConfirmation(String username, String password, String pConfirmation) {
        newAccount(username, password, pConfirmation);
    }

    @Then("user will not be created and error message {string} is given")
    public void userNotCreatedNoMatchPasswords(String error) {
        assertTrue(driver.getPageSource().contains(error));
    }

    /* LEA */
    @Given("user with username {string} with password {string} is successfully created")
    public void newAccountLeaCreated(String username, String password) {
        commandNewUserIsSelected();
        newAccount(username, password, password);
    }

    @When("valid username {string} is entered and working password {string} are entered")
    public void validUsernameAndPasswordForLea(String username, String password) {
        logInWith(username, password);
    }

    @Then("lea is logged in")
    public void userLeaIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }

    @Given("user with username {string} and password {string} is tried to be created")
    public void newAccountBadUsernameAndPasswordTriedToCreate(String username, String password) {
        commandNewUserIsSelected();
        newAccount(username, password, password);
    }

    @When("wannabe user {string} tries to login with password {string}")
    public void invalidUserTriesToLogin(String username, String password) {
        logInWith(username, password);
    }

    @Then("login is denied")
    public void loginIsDenied() {
        invalidLogin();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
        
    /* helper methods */
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    }

    private void invalidLogin() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    private void newAccount(String username, String password, String passwordConfirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(passwordConfirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }



}
