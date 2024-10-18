package connect.jatekos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JatekosNeveTest {

    private final String testName = "Teszt Jatekos";

    @BeforeEach
    public void setUp() {
        // Szimuláljuk a felhasználó által megadott nevet
        InputStream in = new ByteArrayInputStream(testName.getBytes());
        System.setIn(in);
    }

    @Test
    public void testNevBeolvasasa() {
        // Létrehozzuk a JatekosNeve objektumot, ami automatikusan beolvassa a nevet
        JatekosNeve jatekosNeve = new JatekosNeve();

        // Ellenőrizzük, hogy a név megfelelően be lett olvasva
        assertEquals(testName, jatekosNeve.getName(), "A név nem megfelelően lett beolvasva.");
    }

    @Test
    public void testPrintName() {
        // Létrehozzuk a JatekosNeve objektumot
        JatekosNeve jatekosNeve = new JatekosNeve();

        // Ellenőrizzük a kiírást (bár a valós kiírást nem tudjuk könnyen tesztelni)
        jatekosNeve.printName();
    }
}
