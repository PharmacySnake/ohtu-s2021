
package ohtu;

import java.util.Comparator;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }
    public void setTeam(String team) { this.team = team; }
    public void setNationality(String nationality) { this.nationality = nationality; }
    public void setGoals(int goals) { this.goals = goals; }
    public void setAssists(int assists) { this.assists = assists; }

    public String getName() {
        return name;
    }
    public String getTeam() { return this.team; }
    public String getNationality() { return this.nationality; }
    public int getGoals() { return this.goals; }
    public int getAssists() { return this.assists; }

    @Override
    public String toString() {
        return name + " " + team + "" + goals + " + " + assists + " = " + (goals+assists);
    }

    @Override
    public int compareTo(Player other) {
        return (other.goals+other.assists) - (this.goals+this.assists);
    }

}
