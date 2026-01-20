package Reversi;

import java.util.ArrayList;

public abstract class Board {

    private final int GRID_WIDTH = 8;
    private final int GRID_HEIGHT = 8;
    private Integer[][] grid = new Integer[GRID_WIDTH][GRID_WIDTH];
    private final ArrayList<ArrayList<Chip>> allChips = new ArrayList<>(GRID_WIDTH);
    private int counter1;
    private int counter2;
    private boolean gameOver = false;
    private Player player1;
    private Player player2;

    public Board() {
        for (int i = 0; i < GRID_WIDTH; i++) {
            allChips.add(new ArrayList<>(GRID_WIDTH));
            for (int j = 0; j < GRID_WIDTH; j++) {
                grid[i][j] = 0;
            }
        }

        grid[GRID_WIDTH / 2 - 1][GRID_WIDTH / 2] = 1;
        allChips.get(GRID_WIDTH / 2 - 1).add(new Chip(1, GRID_WIDTH / 2 - 1, GRID_WIDTH / 2)); // d5
        grid[GRID_WIDTH / 2][GRID_WIDTH / 2 - 1] = 1;
        allChips.get(GRID_WIDTH / 2).add(new Chip(1, GRID_WIDTH / 2, GRID_WIDTH / 2 - 1)); // e4
        grid[GRID_WIDTH / 2 - 1][GRID_WIDTH / 2 - 1] = 2;
        allChips.get(GRID_WIDTH / 2 - 1).add(new Chip(2, GRID_WIDTH / 2 - 1, GRID_WIDTH / 2 - 1)); // d4
        grid[GRID_WIDTH / 2][GRID_WIDTH / 2] = 2;
        allChips.get(GRID_WIDTH / 2).add(new Chip(2, GRID_WIDTH / 2, GRID_WIDTH / 2)); // e5

        counter1 = 2; // На поле уже есть по 2 фишки у каждого игрока.
        counter2 = 2;
    }

    abstract void showGameOver(int counter1, int counter2, Player player1, Player player2);
    abstract void startGame();

    public Integer[][] getGrid() {
        return grid.clone();
    }

    public final void setPlayer1(Player player1) {
        if (this.player1 == null) {
            this.player1 = player1;
        }
    }

    public final void setPlayer2(Player player2) {
        if (this.player2 == null) {
            this.player2 = player2;
        }
    }

    public boolean setChip(int player, int row, int col) {
        if (player >= 1 && player <= 2 && row >= 0 && row < GRID_WIDTH && col >= 0 && col < GRID_WIDTH) {
            if (gameOver || grid[row][col] != 0) {
                return false;
            }
            boolean canSet = checkForChanges(player, row, col);
            if (!canSet) {
                return false;
            }
            grid[row][col] = player;
            allChips.get(row).add(new Chip(player, row, col));
            recount();

            if (gridIsFull(grid)) {
                gameOver = true;
            }

            return true;
        }
        return false;
    }

    public void launch() {
        startGame();
        int turn = 1;
        while (!gameOver) {
            GameInfo gi;
            if (turn == 1) {
                gi = new GameInfo() {
                    @Override
                    public int getWidth() {
                        return GRID_WIDTH;
                    }

                    @Override
                    public int getHeight() {
                        return GRID_HEIGHT;
                    }

                    @Override
                    public int getCell(int row, int col) {
                        return grid[row][col];
                    }

                    @Override
                    public Integer[][] getGrid() {
                        return grid.clone();
                    }
                }; //обычная
            } else {
                gi = new GameInfo() {
                    @Override
                    public int getWidth() {
                        return GRID_WIDTH;
                    }

                    @Override
                    public int getHeight() {
                        return GRID_HEIGHT;
                    }

                    @Override
                    public int getCell(int row, int col) {
                        return grid[row][col];
                    }

                    @Override
                    public Integer[][] getGrid() {
                        return getReversedGrid(grid);
                    }
                }; //перевернутая
            }

            Position position = getPlayer(turn).getMakerTurn().makeTurn(gi);
            int row;
            int col;
            if (turn == 2) {
                row = GRID_HEIGHT - 1 - position.getRow();
                col = GRID_WIDTH - 1 - position.getCol();
            } else {
                row = position.getRow();
                col = position.getCol();
            }
            boolean successful = setChip(turn, row, col);
            if (successful) {
                turn = turn == 1 ? 2 : 1;
            }
        }
        showGameOver(counter1, counter2, player1, player2);
    }

    private Player getPlayer(int number) {
        if (number == 1) {
            return player1;
        } else {
            return player2;
        }
    }

    private static Integer[][] getReversedGrid(Integer[][] grid) {
        Integer[][] newGrid = new Integer[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    newGrid[grid.length - 1 - i][grid.length - 1 - j] = grid[i][j];
                } else {
                    newGrid[grid.length - 1 - i][grid.length - 1 - j] = grid[i][j] == 1 ? 2 : 1;
                }
            }
        }
        return newGrid;
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

    private int checkWay(int player, int row, int col, ArrayList<Chip> chips) {
        if (grid[row][col] == player) {
            if (!chips.isEmpty()) {
                for (Chip chip : chips) {
                    chip.changePlayer();
                    grid[chip.getRow()][chip.getCol()] = chip.getPlayer();
                }
                return 2;
            }
            return 0;
        } else if (grid[row][col] != 0) {
            chips.add(getChip(row, col));
            return 1;
        }
        return 0;
    }

    private boolean checkForChanges(int player, int row, int col) {
        int canSetInt = 1;
        boolean canSet = false;
        ArrayList<Chip> chips = new ArrayList<>();

        for (int i = row - 1; i >= 0; i--) {
            canSetInt = checkWay(player, i, col, chips); // Влево
            if (canSetInt != 1) {
                break;
            }
        }
        if (canSetInt == 2) {
            canSet = true;
        }
        chips.clear(); // Если так и не встретится другая фишка игрока - забываем накопленные фишки

        for (int i = row + 1; i < GRID_WIDTH; i++) {
            canSetInt = checkWay(player, i, col, chips); // Вправо
            if (canSetInt != 1) {
                break;
            }
        }
        if (canSetInt == 2) {
            canSet = true;
        }
        chips.clear();
        for (int i = col - 1; i >= 0; i--) {
            canSetInt = checkWay(player, row, i, chips); // Вверх
            if (canSetInt != 1) {
                break;
            }
        }
        if (canSetInt == 2) {
            canSet = true;
        }
        chips.clear();
        for (int i = col + 1; i < GRID_WIDTH; i++) {
            canSetInt = checkWay(player, row, i, chips); // Вниз
            if (canSetInt != 1) {
                break;
            }
        }
        if (canSetInt == 2) {
            canSet = true;
        }
        chips.clear();
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            canSetInt = checkWay(player, row - i, col - i, chips); // Влево-вверх
            if (canSetInt != 1) {
                break;
            }
        }
        if (canSetInt == 2) {
            canSet = true;
        }
        chips.clear();
        for (int i = 1; row + i < GRID_WIDTH && col - i >= 0; i++) {
            canSetInt = checkWay(player, row + i, col - i, chips); // Вправо-вверх
            if (canSetInt != 1) {
                break;
            }
        }
        if (canSetInt == 2) {
            canSet = true;
        }
        chips.clear();
        for (int i = 1; row - i >= 0 && col + i < GRID_WIDTH; i++) {
            canSetInt = checkWay(player, row - i, col + i, chips); // Влево-вниз
            if (canSetInt != 1) {
                break;
            }
        }
        if (canSetInt == 2) {
            canSet = true;
        }
        chips.clear();
        for (int i = 1; row + i < GRID_WIDTH && col + i < GRID_WIDTH; i++) {
            canSetInt = checkWay(player, row + i, col + i, chips); // Вправо-вниз
            if (canSetInt != 1) {
                break;
            }
        }
        if (canSetInt == 2) {
            canSet = true;
        }
        return canSet;
    }
}
