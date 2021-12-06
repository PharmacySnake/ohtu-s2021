package ohtu;

import java.util.ArrayList;
import java.util.List;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private List<String> pisteet;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.pisteet = new ArrayList<>();
        initPisteet();
    }

    private void initPisteet() {
        this.pisteet.add("Love");
        this.pisteet.add("Fifteen");
        this.pisteet.add("Thirty");
        this.pisteet.add("Forty");
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1Score++;
        else
            player2Score++;
    }

    public String getScore() {
        String score;

        if (player1Score >= 4 || player2Score >= 4) {
            score = pisteetDeuceTaiYli();

        } else if (player1Score == player2Score) {
            score = tasaPisteet();

        } else {
            score = pisteet.get(player1Score) +"-"+ pisteet.get(player2Score);
        }

        return score;
    }

    private String pisteetDeuceTaiYli() {
        String score;
        int result = player1Score - player2Score;
        if (result == 1) score ="Advantage player1";
        else if (result == -1) score ="Advantage player2";
        else if (result >= 2) score = "Win for player1";
        else if (result == 0) score = "Deuce";
        else score ="Win for player2";
        return score;
    }

    private String tasaPisteet() {
        return pisteet.get(player1Score) + "-All";
    }
}