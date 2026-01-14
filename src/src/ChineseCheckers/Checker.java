package ChineseCheckers;

class Checker {
    private Cell cell;
    private final int player;
    private final int number;


    public Checker(Cell cell, int player, int number) {
        this.cell = cell;
        this.player = player;
        this.number = number;
    }

    protected void jump(Cell toCell) {
        this.cell = toCell;
    }

    public int getPlayer() {
        return player;
    }

    public Cell getCell() {
        return new Cell(cell.getNumber(), cell.isFree());
    }

    public int getNumber() {
        return number;
    }
}
