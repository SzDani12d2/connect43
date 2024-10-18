package connect.tabla.valtozas;
import connect.tabla.TablaConf;

public class Erme {
    /**
     * Érme bedobása.
     * @param board
     * @param col
     * @param player
     */
    public void dropPiece(final char[][] board,
                          final int col, final char player) {
        for (int row = TablaConf.ROWS.getIntValue() - 1; row >= 0; row--) {
            if (board[row][col] == TablaConf.EMPTY_SLOT.getCharValue()) {
                board[row][col] = player;
                break;
            }
        }
    }
}
