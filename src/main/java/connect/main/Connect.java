package connect.main;


import connect.jatek.Jatek;
import connect.jatek.kezeles.Kezdes;


public class Connect extends Jatek {

    /**
     * A játék main-je.
     * @param args A parancssori argumentumok tömbje.
     */
    public static void main(final String[] args) {
        System.out.println(" üdvözöllek a Connect 4");

        Kezdes kezdes = new Kezdes();
        kezdes.start();  // Elindítja a parancsok figyelését

}
}
