package connect.tabla.alap;

import connect.tabla.TablaConf;

public class TablaEll {

    /**
     * tele van-e.
     * @param board
     * @return return.
     */
    public boolean isFull(final char[][] board) {
        for (int col = 0; col < TablaConf.COLUMNS.getIntValue(); col++) {
            if (board[0][col] == TablaConf.EMPTY_SLOT.getCharValue()) {
                return false;
            }
        }
        return true;
    }
}
