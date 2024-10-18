package connect.jatek.feltetel;

import connect.tabla.TablaConf;

public class GyozelemFeltetel {

    /**
     * A győzelemhez szükséges darabszám.
     */
    private static final int WIN_COUNT = 4;
    /**
     * 3 mas inicializása.
     */

    private static final int WINT_COUNT = 3;

    /**
     * Győzelmi feltételek ellenőrzése.
     *
     * @param board  a játéktábla tömbje
     * @param player az aktuális játékos karaktere
     * @return visszaadja, hogy van-e győzelem
     */
    public boolean checkWin(final char[][] board, final char player) {
        int rows = TablaConf.ROWS.getIntValue();
        int cols = TablaConf.COLUMNS.getIntValue();

        // Vízszintes ellenőrzés
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <= cols - WIN_COUNT; col++) {
                if (board[row][col] == player
                        && board[row][col + 1] == player
                        && board[row][col + 2] == player
                        && board[row][col +  WINT_COUNT] == player) {
                    return true; // Győzelem vízszintesen
                }
            }
        }

        // Függőleges ellenőrzés
        for (int row = 0; row <= rows - WIN_COUNT; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == player
                        && board[row + 1][col] == player
                        && board[row + 2][col] == player
                        && board[row + WINT_COUNT][col] == player) {
                    return true; // Győzelem függőlegesen
                }
            }
        }

        // Átlós ellenőrzés balról jobbra
        for (int row = 0; row <= rows - WIN_COUNT; row++) {
            for (int col = 0; col <= cols - WIN_COUNT; col++) {
                if (board[row][col] == player
                        && board[row + 1][col + 1] == player
                        && board[row + 2][col + 2] == player
                        && board[row + WINT_COUNT][col
                        + WINT_COUNT] == player) {
                    return true; // Győzelem átlósan balról jobbra
                }
            }
        }

        // Átlós ellenőrzés jobbról balra
        for (int row = 0; row <= rows - WIN_COUNT; row++) {
            for (int col = WIN_COUNT - 1; col < cols; col++) {
                if (board[row][col] == player
                        && board[row + 1][col - 1] == player
                        && board[row + 2][col - 2] == player
                        && board[row + WINT_COUNT][col
                        - WINT_COUNT] == player) {
                    return true; // Győzelem átlósan jobbról balra
                }
            }
        }

        return false; // Nincs győzelem
    }
}
