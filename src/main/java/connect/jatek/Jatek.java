package connect.jatek;

import connect.tabla.Tabla;
import connect.jatek.feltetel.GyozelemFeltetel;

import java.util.Random;
import java.util.Scanner;

public class Jatek {
    /**
     * Magic number elkerülésére egy konstans.
     */
    public static final int SEVEN = 7;
    /**
     * statik.
     */
    public static final int SIX = 6; // A tábla magassága
    /**
     * Tábla változó.
     */
    private Tabla tabla;
    /**
     * Jelenlegi játékos.
     */
    private char currentPlayer; // Jelenlegi játékos tárolása
    /**
     * Random szám.
     */
    private Random random;
    /**
     * WinChecker objektum a győzelem ellenőrzéséhez.
     */
    private GyozelemFeltetel gyozelemfeltetel;

    /**
     * Játék létrehozása.
     */
    public Jatek() {
        // Létrehozza a játéktáblát,
        // az első játékost és a véletlenszám-generátort
        tabla = new Tabla();
        currentPlayer = 'X'; // Az első játékos 'X'
        random = new Random(); // Véletlenszám-generátor a gépi játékoshoz
        gyozelemfeltetel = new GyozelemFeltetel();
    }

    /**
     * A játék menete.
     */
    public void play() {
        // beolvasás
        Scanner scanner = new Scanner(System.in);
        boolean gyozelem = false;

        System.out.println("Üdvözlünk a Connect Four játékban!");
        tabla.displayBoard();

        // Amíg valaki nem nyer, vagy a tábla meg nem telik
        while (!gyozelem && !tabla.isFull()) {
            int hely;

            // Ha az emberi játékos (X) jön
            if (currentPlayer == 'X') {
                System.out.println("Játékos " + currentPlayer + " lépése.");

                // Játékos bemenete (oszlop kiválasztása)
                do {
                    System.out.print("Válassz egy oszlopot (0-6): ");
                    hely = scanner.nextInt();
                } while (hely < 0 || hely >= SEVEN || tabla.isColumnFull(hely));
            } else {
                // Ha a gépi játékos jön
                System.out.println("Játékos " + currentPlayer
                        + " lépése (gépi játékos).");
                // Véletlen oszlop választása
                do {
                    hely = random.nextInt(SEVEN);
                } while (tabla.isColumnFull(hely));

                System.out.println("Gépi játékos az " + hely
                        + " oszlopba dobja a korongot.");
            }

            // Dobd be a korongot
            tabla.coindobas(hely, currentPlayer);
            tabla.displayBoard();

            // Ellenőrzi, hogy a jelenlegi játékos nyert-e
            if (gyozelemfeltetel.checkWin(tabla.getBoard(), currentPlayer)) {
                System.out.println("Játékos " + currentPlayer + " nyert!");
                gyozelem = true;
            } else {
                // Váltás a másik játékosra
                switchPlayer();
            }
        }

        // Döntetlen esetén
        if (!gyozelem) {
            System.out.println("A játék döntetlen!");
        }

        scanner.close();
    }

    /**
     * Visszaadja a jelenlegi játékost.
     *
     * @return A jelenlegi játékos karaktere
     */
    public char getCurrentPlayer() {
        return currentPlayer; // Visszaadja a helyes currentPlayer értéket
    }

    /**
     * Beállítja a jelenlegi játékost.
     *
     * @param kezdoJatekos A beállítandó játékos karaktere
     */
    public void setCurrentPlayer(final char kezdoJatekos) {
        currentPlayer = kezdoJatekos; // Beállítja a megadott karaktert
    }

    /**
     * Váltja a jelenlegi játékost.
     */
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Játékos váltás
    }

    /**
     * Visszaadja a játék tábláját.
     *
     * @return A játéktábla
     */
    public Tabla getTabla() {
        return tabla; // Visszaadja a táblát
    }
}
