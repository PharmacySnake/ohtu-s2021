package ohtu;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;

    @Before
    public void setUp() {
        kori = new Ostoskori();
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.tavaroitaKorissa());
        // ...
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTuote() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);

        assertEquals(1, kori.tavaroitaKorissa());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenHintaOnSamaKuinTuotteenHinta() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);

        assertEquals(maito.getHinta(), kori.hinta());
    }

    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaKaksiTuotetta() {
        Tuote maito = new Tuote("maito", 3);
        Tuote mehu = new Tuote("maito", 2);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    public void kahdenTuotteenLisaamisenJalkeenHintaOnSamaKuinKahdenTuotteenHintaYhteensa() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals((maito.getHinta()*2), kori.hinta());
    }
}
