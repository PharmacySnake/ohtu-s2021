package statistics.matcher;

import statistics.Player;

import java.lang.reflect.Method;

public class All implements Matcher {
    private Matcher[] matchers;
    private String fieldName;

    public All() {//Matcher... matchers) {
    //public All(String category) {
        //this.matchers = matchers;
        //fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player p) {
        return true;
    }
    /*@Override
    public boolean matches(Player p) {
        try {
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return playersValue>=0;

        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }
    }*/
}
