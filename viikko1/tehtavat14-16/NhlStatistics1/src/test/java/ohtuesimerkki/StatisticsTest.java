package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM",4,12));
            players.add(new Player("Lemieux", "PIT",45,54));
            players.add(new Player("Kurri", "EDM",37,53));
            players.add(new Player("Yzerman", "DET",42,56));
            players.add(new Player("Gretzky", "EDM",35,89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void validSearch() {
        Player p = stats.search("Semenko");
        assertEquals("Semenko", p.getName());
    }

    @Test
    public void invalidSearch() {
        Player p = stats.search("asd");
        assertEquals(null, p);
    }

    @Test
    public void correctTeam() {
        List<Player> team = stats.team("PIT");
        List<Player> testTeam = new ArrayList<>();
        testTeam.add(new Player("Lemieux", "PIT", 45,54));
        assertEquals(testTeam, team);
    }

    @Test
    public void correctTopScorers() {
        List<Player> best = stats.topScorers(1);
        assertEquals("Gretzky", best.get(0).getName());
    }

    @Test
    public void asd() {

    }
}

