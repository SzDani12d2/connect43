package connect.tabla;

import connect.tabla.valtozas.Erme;
import connect.tabla.alap.Kinezet;
import connect.tabla.alap.Inicializalas;
import connect.tabla.alap.TablaEll;
import connect.tabla.alap.OszlopEll;

public class Tabla {
    /**
     * board.
     */
    private char[][] board;
    /**
     * inicializalas.
     */
    private Inicializalas inicializalas;
    /**
     * inicializalas.
     */
    private Kinezet kinezet;
    /**
     * inicializalas.
     */
    private OszlopEll oszlopell;
    /**
     * inicializalas.
     */
    private Erme erme;
    /**
     * inicializalas.
     */
    private TablaEll tablaell;

    /**
     * Tabla metodus.
     */
    public Tabla() {
        board = new char[TablaConf.ROWS.getIntValue()]
                [TablaConf.COLUMNS.getIntValue()];
        inicializalas = new Inicializalas();
        kinezet = new Kinezet();
        oszlopell = new OszlopEll();
        erme = new Erme();
        tablaell = new TablaEll();
        inicializalas.initialize(board);
    }

    /**
     * Tabla megjelenites.
     */
    public void displayBoard() {
        kinezet.display(board);
    }

    /**
     * Tele van e a tabla.
     * @param col
     * @return return.
     */
    public boolean isColumnFull(final int col) {
        return oszlopell.isColumnFull(board, col);
    }

    /**
     * Erme bedobas.
     * @param col
     * @param player
     */
    public void coindobas(final int col, final char player) {
        erme.dropPiece(board, col, player);
    }

    /**
     * Tele van-e.
     * @return return.
     */
    public boolean isFull() {
        return tablaell.isFull(board);
    }

    /**
     * tabla bekeres.
     * @return return.
     */
    public char[][] getBoard() {
        return board;
    }
}
