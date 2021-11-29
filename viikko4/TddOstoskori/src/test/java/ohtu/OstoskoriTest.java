package ohtu;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void kahdenTuotteenLisaamisenJalkeenHintaOnSamaKuinKahdenTuotteenHintaYhteensa() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);

        assertEquals((maito.getHinta() + mehu.getHinta()), kori.hinta());
    }

    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaKaksiTuotetta() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenHintaOnSamaKuinKaksiKertaaTuotteenHinta() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals((maito.getHinta() * 2), kori.hinta());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        kori.lisaaTuote(mehu);

        List<Ostos> ostokset = kori.ostokset();

        assertEquals(1, ostokset.size());
    }

    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlioJollaOikeaTuotteenNimijaMaara() {
        kori.lisaaTuote(maito);

        Ostos ostos = kori.ostokset().get(0);

        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(1, ostos.lukumaara());
    }

    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenOstoskorissaKaksiOstosta() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(mehu);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        int ostoksia = kori.ostokset().size();

        assertEquals(1, ostoksia);
    }

    @Test
    public void kahdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        Ostos ostos = kori.ostokset().get(0);

        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(2, ostos.lukumaara());
    }
}
