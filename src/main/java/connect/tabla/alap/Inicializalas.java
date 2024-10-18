package connect.tabla.alap;

import connect.tabla.TablaConf;

public class Inicializalas {

    /**
     * inic.
     * @param board
     */
    public void initialize(final char[][] board) {
        for (int row = 0; row < TablaConf.ROWS.getIntValue(); row++) {
            for (int col = 0; col < TablaConf.COLUMNS.getIntValue(); col++) {
                board[row][col] = TablaConf.EMPTY_SLOT.getCharValue();
            }
        }
    }
}
