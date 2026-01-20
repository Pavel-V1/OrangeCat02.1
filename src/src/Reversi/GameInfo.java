package Reversi;

public interface GameInfo {
    public int getWidth();
    public int getHeight();
    public int getCell(int row, int col);
    public Integer[][] getGrid();
}
