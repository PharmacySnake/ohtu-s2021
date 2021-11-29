package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // testikoodi tänne
        Ostoskori o = new Ostoskori();
        Tuote t0 = new Tuote("suklaa", 69);
        Tuote t1 = new Tuote("paprika", 666);
        Tuote t2 = new Tuote("linssit", 1);
        Tuote t3 = new Tuote("jauheliha", 2);

        System.out.println(o.tavaroitaKorissa());
    }
}