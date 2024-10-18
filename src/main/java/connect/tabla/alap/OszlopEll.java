package connect.tabla.alap;


import connect.tabla.TablaConf;

public class OszlopEll {
    /**
     * oszlop tele van e.
     * @param board
     * @param col
     * @return return.
     */
    public boolean isColumnFull(final char[][] board, final int col) {
        return board[0][col] != TablaConf.EMPTY_SLOT.getCharValue();
    }
}
