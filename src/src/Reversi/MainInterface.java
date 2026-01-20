package Reversi;

import java.util.Scanner;

public class MainInterface extends Board {

    @Override
    public boolean makeTurn(Board board, int turn, int counter1, int counter2) {
        Scanner scanner = new Scanner(System.in);
        Integer[][] currentGrid = board.getGrid();

        if (turn == 2) {
            currentGrid = getReversedGrid(currentGrid);
        }

        System.out.println("Ход игрока: " + turn);
        System.out.println("Счет: " + counter1 + ":" + counter2);
        System.out.println();
        print(currentGrid);
        System.out.println();

        System.out.print("Введите строку: ");
        int row = scanner.nextInt();
        System.out.print("Введите столбец: ");
        int col = scanner.nextInt();

        boolean success;
        if (turn == 2) {
            success = board.setChip(turn, 8 - row, 8 - col);
        } else {
            success = board.setChip(turn, row - 1, col - 1);
        }

        if (success) {
            System.out.println("-----------------------------------");
            return true;
        } else {
            System.out.println("Неверные данные, попробуйте еще раз.");
            return false;
        }
    }

    @Override
    public void showGameOver(Board board, int counter1, int counter2) {
        System.out.println("Игра закончилась.");
        System.out.println("Счет: " + counter1 + ":" + counter2);
        if (counter1 == counter2) {
            System.out.println("Ничья.");
        } else {
            int winner = counter1 > counter2 ? 1 : 2;
            System.out.println("Победитель: " + winner); // Можно сделать вывод имени
        }
    }

    private static Integer[][] getReversedGrid(Integer[][] grid) {
        Integer[][] newGrid = new Integer[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                newGrid[grid.length - 1 - i][grid.length - 1 - j] = grid[i][j];
            }
        }
        return newGrid;
    }

    private static void print(Integer[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
