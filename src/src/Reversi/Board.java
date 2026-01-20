package Reversi;

import java.util.ArrayList;

public abstract class Board {
    private final int GRID_LENGTH = 8;
    private final Integer[][] grid = new Integer[GRID_LENGTH][GRID_LENGTH];
    private final ArrayList<ArrayList<Chip>> allChips = new ArrayList<>(GRID_LENGTH);
    private int counter1;
    private int counter2;
    private boolean gameOver = false;

    public Board() {
        for (int i = 0; i < GRID_LENGTH; i++) {
            allChips.add(new ArrayList<>(GRID_LENGTH));
            for (int j = 0; j < GRID_LENGTH; j++) {
                grid[i][j] = 0;
            }
        }
        grid[GRID_LENGTH / 2 - 1][GRID_LENGTH / 2] = 1;
        grid[GRID_LENGTH / 2][GRID_LENGTH / 2 - 1] = 1;
        grid[GRID_LENGTH / 2 - 1][GRID_LENGTH / 2 - 1] = 2;
        grid[GRID_LENGTH / 2][GRID_LENGTH / 2] = 2;
        counter1 = 2; // На поле уже есть по 2 фишки у каждого игрока.
        counter2 = 2;
    }

    abstract boolean makeTurn(Board board, int turn, int counter1, int counter2);
    abstract void showGameOver(Board board, int counter1, int counter2);

    public Integer[][] getGrid() {
        return grid.clone();
    }

    public boolean setChip(int player, int row, int col) {
        if (player >= 1 && player <= 2 && row >= 0 && row < GRID_LENGTH && col >= 0 && col < GRID_LENGTH) {
            if (gameOver || grid[row][col] != 0) {
                return false;
            }
            grid[row][col] = player;
            allChips.get(row).add(new Chip(player, row, col));
            checkForChanges(player, row, col);
            recount();

            if (gridIsFull(grid)) {
                gameOver = true;
            }

            return true;
        }
        return false;
    }

    public void launch() {
        int turn = 1;
        while (!gameOver) {
            boolean successful = makeTurn(this, turn, counter1, counter2);
            if (successful) {
                turn = turn == 1 ? 2 : 1;
            }
        }
        showGameOver(this, counter1, counter2);
    }

    private static boolean gridIsFull(Integer[][] grid) {
        for (Integer[] integers : grid) {
            for (Integer integer : integers) {
                if (integer == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void recount() {
        int c1 = 0;
        int c2 = 0;

        for (ArrayList<Chip> chips : allChips) {
            for (Chip chip : chips) {
                if (chip.getPlayer() == 1) {
                    c1++;
                } else {
                    c2++;
                }
            }
        }

        counter1 = c1;
        counter2 = c2;
    }

    private Chip getChip(int row, int col) {
        if (allChips.get(row).isEmpty()) {
            return null;
        }
        for (Chip chip : allChips.get(row)) {
            if (chip.getCol() == col) {
                return chip;
            }
        }
        return null;
    }

    private boolean checkWay(int player, int row, int col, ArrayList<Chip> chips) {
        if (grid[row][col] == player) {
            if (!chips.isEmpty()) {
                for (Chip chip : chips) {
                    chip.changePlayer();
                    grid[chip.getRow()][chip.getCol()] = chip.getPlayer();
                }
            }
            return true;
        } else if (grid[row][col] != 0) {
            chips.add(getChip(row, col));
        }
        return false;
    }

    private void checkForChanges(int player, int row, int col) {
        ArrayList<Chip> chips = new ArrayList<>();

        for (int i = row - 1; i >= 0; i--) {
            boolean findChip = checkWay(player, i, col, chips); // Влево
            if (findChip) {
                break;
            }
        }
        chips.clear(); // Если так и не встретится другая фишка игрока - забываем накопленные фишки

        for (int i = row + 1; i < GRID_LENGTH; i++) {
            boolean findChip = checkWay(player, i, col, chips); // Вправо
            if (findChip) {
                break;
            }
        }
        chips.clear();
        for (int i = col - 1; i >= 0; i--) {
            boolean findChip = checkWay(player, row, i, chips); // Вверх
            if (findChip) {
                break;
            }
        }
        chips.clear();
        for (int i = col + 1; i < GRID_LENGTH; i++) {
            boolean findChip = checkWay(player, row, i, chips); // Вниз
            if (findChip) {
                break;
            }
        }
        chips.clear();
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            boolean findChip = checkWay(player, row - i, col - i, chips); // Влево-вверх
            if (findChip) {
                break;
            }
        }
        chips.clear();
        for (int i = 1; row + i < GRID_LENGTH && col - i >= 0; i++) {
            boolean findChip = checkWay(player, row + i, col - i, chips); // Вправо-вверх
            if (findChip) {
                break;
            }
        }
        chips.clear();
        for (int i = 1; row - i >= 0 && col + i < GRID_LENGTH; i++) {
            boolean findChip = checkWay(player, row - i, col + i, chips); // Влево-вниз
            if (findChip) {
                break;
            }
        }
        chips.clear();
        for (int i = 1; row + i < GRID_LENGTH && col + i < GRID_LENGTH; i++) {
            boolean findChip = checkWay(player, row + i, col + i, chips); // Вправо-вниз
            if (findChip) {
                break;
            }
        }
    }
}
