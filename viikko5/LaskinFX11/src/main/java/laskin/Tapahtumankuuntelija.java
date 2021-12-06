package laskin;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class Tapahtumankuuntelija implements EventHandler {
    private TextField tuloskentta; 
    private TextField syotekentta; 
    private Button plus;
    private Button miinus;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    private Komentotehdas komennot;
    private LinkedList<Integer> muisti;

    public Tapahtumankuuntelija(TextField tuloskentta, TextField syotekentta, Button plus, Button miinus, Button nollaa, Button undo) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        this.komennot = new Komentotehdas(plus, miinus, nollaa);
        this.muisti = new LinkedList<>();
    }
    
    @Override
    public void handle(Event event) {
        int arvo = 0;
        int laskunTulos = Integer.parseInt(tuloskentta.getText());
        
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        if (event.getTarget() != undo) {
            muisti.push(laskunTulos);
            laskunTulos = komennot.suorita(event, laskunTulos, arvo);
        } else if (event.getTarget() == undo && !muisti.isEmpty()) {
            laskunTulos = muisti.pop();
        }

        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);
        
        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

}
