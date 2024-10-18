package connect.jatek.kezeles;

import connect.jatek.Jatek;
import connect.jatekos.JatekosNeve;

import java.util.Scanner;

public class Kezdes extends JatekosNeve {
    /**
     * Elkezdődött e a játék. Kezdetben hamis.
     */
    private boolean gameStarted = false;
    /**
     * Változó a játékos nevére.
     */
    private JatekosNeve player;

    /**
     * Elindítja a játékot.
     */
    public void start() {
        //Beolvasás
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        // Addig vár, amíg a felhasználó be nem írja, hogy "Start"
        while (!userInput.equalsIgnoreCase("ok")) {
            System.out.println("ird be hogy 'ok' a jatek kezdetehez ");
            userInput = scanner.nextLine();
        }

        // A játék elindul, miután a felhasználó beírta, hogy "Start"
        System.out.println("A játék elindul...");
        Jatek jatek = new Jatek();
        jatek.play();
    }
}
