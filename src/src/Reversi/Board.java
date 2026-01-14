package Reversi;

import java.util.Arrays;

public class Board {
    private int[][] grid = new int[8][8];
    private int counter1;
    private int counter2;

    public Board() {
        Arrays.stream(grid).forEach(row -> Arrays.fill(row, 1));
        grid[4][5] = 0;
        grid[5][4] = 0;
        grid[4][4] = 0;
        grid[5][5] = 0;
        counter1 = 2;  // по 2 у каждого
        counter2 = 2;
    }

    public void setChip(int row, int col, int color) {
        new Chip(color, row, col);
        checkForChanges();
    }

    private void checkForChanges() {
        //
    }
}
