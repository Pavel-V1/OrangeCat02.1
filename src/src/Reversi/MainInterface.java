package Reversi;

import java.util.Scanner;

public class MainInterface extends Board {

    @Override
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        setPlayer1(new Player(1, scanner.next(), new HumanMakerTurn()));
        System.out.print("Введите имя второго игрока: ");
        setPlayer2(new Player(2, scanner.next(), new BotMakerTurn()));
    }

    /*public Position makeTurn(GameInfo gameInfo) {
        Scanner scanner = new Scanner(System.in);
        Integer[][] currentGrid = gameInfo.getGrid();

        System.out.println("Ход игрока: " + gameInfo.getPlayer());
        System.out.println("Счет: " + gameInfo.getCounter1() + ":" + gameInfo.getCounter2());
        System.out.println();
        print(currentGrid);
        System.out.println();

        System.out.print("Введите строку: ");
        int row = scanner.nextInt();
        System.out.print("Введите столбец: ");
        int col = scanner.nextInt();

        boolean success = setChip(gameInfo.getPlayer().getNumber(), row - 1, col - 1);

        if (success) {
            System.out.println("-----------------------------------");
            return true;
        } else {
            System.out.println("Неверные данные, попробуйте еще раз.");
            return false;
        }
    }*/

    @Override
    public void showGameOver(int counter1, int counter2, Player player1, Player player2) {
        System.out.println("Игра закончилась.");
        System.out.println("Счет: " + counter1 + ":" + counter2);
        if (counter1 == counter2) {
            System.out.println("Ничья.");
        } else {
            int winner = counter1 > counter2 ? 1 : 2;
            System.out.println("Победитель: " + getWinner(winner, player1, player2));
        }
    }

    private String getWinner(int winner, Player player1, Player player2) {
        if (winner == 1) {
            return player1.getName();
        } else {
            return player2.getName();
        }
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
