package ChineseCheckers;

class Cell {
    private final int number;
    private boolean isFree;

    public Cell(int number, boolean isFree) {
        this.number = number;
        this.isFree = isFree;
    }

    public Cell getCell() {
        return new Cell(number, isFree);
    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return isFree;
    }

    protected void setFree(boolean free) {
        isFree = free;
    }
}
