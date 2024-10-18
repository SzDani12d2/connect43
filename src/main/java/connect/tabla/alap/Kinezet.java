package connect.tabla.alap;

import connect.tabla.TablaConf;

public class Kinezet {
    /**
     * display.
     * @param board
     */
    public void display(final char[][] board) {
        for (int row = 0; row < TablaConf.ROWS.getIntValue(); row++) {
            for (int col = 0; col < TablaConf.COLUMNS.getIntValue(); col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
