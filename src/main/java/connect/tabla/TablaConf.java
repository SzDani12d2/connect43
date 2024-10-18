package connect.tabla;

public enum TablaConf {
    /**
     * A sorok száma a táblán.
     */
    ROWS(6),
    /**
     * Az oszlopok száma a táblán.
     */
    COLUMNS(7),
    /**
     * Az üres mezők jelölése a táblán.
     */
    EMPTY_SLOT('_');

    /**
     * Int érték.
     */
    private final int intValue;
    /**
     * Karakterérték.
     */
    private final char charValue;

    // Konstruktor az egész szám típusú értékekhez (ROWS és COLUMNS)
    TablaConf(final int value) {
        this.intValue = value;
        this.charValue = '\0'; // Alapértelmezett érték, ha nem karakter
    }

    // Konstruktor a karakter típusú értékhez (EMPTY_SLOT)
    TablaConf(final char value) {
        this.intValue = -1; // Alapértelmezett érték, ha nem egész szám
        this.charValue = value;
    }
    /**
     * Metódus az egész szám típusú értékek lekéréséhez.
     * @return visszaadja az intek értékét
     */
    public int getIntValue() {
        return intValue;
    }

    /**
     * Metódus a karakter típusú érték lekéréséhez.
     * @return charValue Visszaadja a karakterek értékét
     */
    public char getCharValue() {
        return charValue;
    }
}
