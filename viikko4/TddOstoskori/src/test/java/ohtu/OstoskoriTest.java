package ohtu;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;
    Tuote maito = new Tuote("maito", 3);
    Tuote mehu = new Tuote("maito", 2);

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
        kori.lisaaTuote(maito);

        assertEquals(1, kori.tavaroitaKorissa());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenHintaOnSamaKuinTuotteenHinta() {
        kori.lisaaTuote(maito);

        assertEquals(maito.getHinta(), kori.hinta());
    }

    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaKaksiTuotetta() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    public void kahdenTuotteenLisaamisenJalkeenHintaOnSamaKuinKahdenTuotteenHintaYhteensa() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);

        assertEquals((maito.getHinta()+mehu.getHinta()), kori.hinta());
    }

    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaKaksiTuotetta() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    /*public void kahdenSamanTuotteenLisaamisenJalkeenHintaOnSamaKuinKaksiKertaaTuotteenHinta() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals((maito.getHinta()*2), kori.hinta());
    }*/
}
