package connect.jatekos;

import java.util.Scanner;

public class JatekosNeve {
    /**
     * Változó a névre.
     */
    private String name;

    /**
     * Konstruktor, ami bekéri a játékos nevét.
     */
    public JatekosNeve() {
        this.name = nev();
    }

    // Játékos nevének bekérése
    private String nev() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a neved");
        return scanner.nextLine().trim(); // Nevet bekérjük és visszaadjuk
    }

    /**
     * Játékos nevének lekérdezése.
     * @return visszaadja a nevet
     */
    public String getName() {
        return name;
    }

    /**
     * Játékos nevének kiírása.
     */
    public void printName() {
        System.out.println("jatekos neve " + name);
    }
}
