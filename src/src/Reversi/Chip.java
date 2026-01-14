package Reversi;

class Chip {
    private int color;  // подразумеваются собственные цвета, отличия по номеру, без лишних импортов
    private final int row;
    private final int col;

    public Chip(int color, int row, int col) {
        this.color = color;
        this.row = row;
        this.col = col;
    }

    protected void changeColor() {
        this.color = color == 1 ? 2 : 1;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
