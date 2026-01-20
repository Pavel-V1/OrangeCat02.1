package Reversi;

class Chip {
    private int player;
    private final int row;
    private final int col;

    public Chip(int player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }

    protected void changePlayer() {
        this.player = player == 1 ? 2 : 1;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getPlayer() {
        return player;
    }
}
