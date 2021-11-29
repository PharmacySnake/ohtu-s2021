package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Ostoskori {

    private ArrayList<Ostos> ostoskori = new ArrayList<>();

    public int tavaroitaKorissa() {
        // kertoo korissa olevien tavaroiden lukumäärän
        // eli jos koriin lisätty 2 kpl tuotetta "maito", 
        //   tulee metodin palauttaa 2 
        // jos korissa on 1 kpl tuotetta "maito" ja 1 kpl tuotetta "juusto", 
        //   tulee metodin palauttaa 2
        int lkm = 0;
        for (Ostos o : ostoskori) {
            lkm += o.lukumaara();
        }

        return lkm;
    }

    public int hinta() {
        // kertoo korissa olevien tuotteiden yhteenlasketun hinnan
        int hinta = 0;
        for (Ostos o : ostoskori) {
            hinta += o.hinta();
        }

        return hinta;
    }

    public void lisaaTuote(Tuote lisattava) {
        // lisää tuotteen
        Ostos uusiOstos = new Ostos(lisattava);
        int index = etsiTuote(uusiOstos);
        if (index >= 0) {
            ostoskori.get(index).muutaLukumaaraa(1);
        } else {
            ostoskori.add(uusiOstos);
        }
    }

    private int etsiTuote(Ostos uusiOstos) {
        for (int i = 0; i < ostoskori.size(); i++) {
            if (ostoskori.get(i).hashCode() == uusiOstos.hashCode()) {
                return i;
            }
        }
        return -1;
    }

    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }

    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
        return ostoskori;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
    }
}
