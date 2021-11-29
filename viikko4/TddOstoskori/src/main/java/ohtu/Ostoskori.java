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
        if (ostoskori.contains(uusiOstos)) {
            int i = ostoskori.indexOf(uusiOstos);
            ostoskori.get(i).muutaLukumaaraa(1);
        } else {
            ostoskori.add(uusiOstos);
        }
    }

    public void poista(Tuote poistettava) {
        // poistaa tuotteen
        Ostos poistettavaOstos = new Ostos(poistettava);
        if (ostoskori.contains(poistettavaOstos)) {
            int i = ostoskori.indexOf(poistettavaOstos);
            if (ostoskori.get(i).lukumaara() > 1) {
                ostoskori.get(i).muutaLukumaaraa(-1);
            } else {
                ostoskori.remove(i);
            }
        }
    }

    public List<Ostos> ostokset() {
        // palauttaa listan jossa on korissa olevat ostokset
        return ostoskori;
    }
 
    public void tyhjenna() {
        // tyhjentää korin
        ostoskori.clear();
    }
}
