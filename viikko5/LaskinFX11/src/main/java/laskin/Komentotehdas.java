package laskin;

import javafx.event.Event;
import javafx.scene.control.Button;

import java.util.HashMap;

public class Komentotehdas {
    private HashMap<Button, Komento> komennot;

    public Komentotehdas(Button summa, Button erotus, Button nollaus) {
        this.komennot = new HashMap<>();
        this.komennot.put(summa, new Summa());
        this.komennot.put(erotus, new Erotus());
        this.komennot.put(nollaus, new Nollaus());
    }

    public int suorita(Event event, int luku1, int luku2) {
        return komennot.get(event.getTarget()).laske(luku1, luku2);
    }
}
