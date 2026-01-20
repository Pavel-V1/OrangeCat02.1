package Reversi;

import java.util.Scanner;

public class HumanMakerTurn implements MakerTurn {

    @Override
    public Position makeTurn(GameInfo gameInfo) {
        Scanner scanner = new Scanner(System.in);
        Integer[][] currentGrid = gameInfo.getGrid();

        print(currentGrid);
        System.out.println();

        System.out.print("Введите строку: ");
        int row = scanner.nextInt();
        System.out.print("Введите столбец: ");
        int col = scanner.nextInt();

        return new Position(row, col);
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
