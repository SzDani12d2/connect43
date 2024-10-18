package connect.jatek;

import connect.jatek.feltetel.GyozelemFeltetel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * A Jatek osztály tesztelésére szolgáló osztály.
 */
public class JatekTest {
    private Jatek jatek;

    @BeforeEach
    public void setUp() {
        // Játék példány inicializálása minden teszt előtt
        jatek = new Jatek();
    }

    /**
     * Teszteli, hogy a játékos váltása helyesen működik.
     */
    @Test
    public void testJatekosValtas() {
        char kezdoJatekos = 'X'; // Az első játékos X
        assertEquals(kezdoJatekos, jatek.getCurrentPlayer(),
                "A kezdeti játékosnak 'X'-nek kell lennie.");

        jatek.switchPlayer(); // Váltás
        assertEquals('O', jatek.getCurrentPlayer(),
                "A játékosnak 'O'-ra kell váltania.");

        jatek.switchPlayer(); // Váltás vissza
        assertEquals(kezdoJatekos, jatek.getCurrentPlayer(),
                "A játékosnak 'X'-re kell váltania.");
    }

    /**
     * Teszteli a play() metódust, hogy a játék helyesen
     * kezelje a játékos lépéseit és a győzelmet.
     */
    @Test
    public void testPlay() {
        // Szimuláljuk a bemenetet (2, 3, 2, 4, 2, 5, 2)
        String simulatedInput = "2\n3\n2\n4\n2\n5\n2\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);


        jatek.play();

        // Ellenőrizzük, hogy a játék végén 'X' nyert-e (vagyis a győzelmi feltétel teljesült)
        assertTrue(jatek.getCurrentPlayer() == 'X',
                "A jelenlegi játékosnak 'X'-nek kell lennie a játék végén.");
    }

    /**
     * Teszteli, hogy a győzelmi feltétel helyesen működik.
     */
    @Test
    public void testGyozelem() {
        GyozelemFeltetel gyozelemfeltetel = new GyozelemFeltetel();

        // Tegyük fel, hogy egy sorban négy 'X' van
        jatek.getTabla().coindobas(0, 'X');
        jatek.getTabla().coindobas(1, 'X');
        jatek.getTabla().coindobas(2, 'X');
        jatek.getTabla().coindobas(3, 'X');

        // Ellenőrizzük, hogy a győzelemfeltétel igazat ad-e
        assertTrue(gyozelemfeltetel.checkWin(jatek.getTabla().getBoard(), 'X'),
                "Az 'X' játékosnak nyernie kell.");
    }
}