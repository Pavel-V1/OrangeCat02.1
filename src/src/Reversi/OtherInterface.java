package Reversi;

import java.util.Scanner;

public class OtherInterface extends Board {

    @Override
    public void startGame(Board board, Player player1, Player player2) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        player1 = new Player(1, scanner.next());
        System.out.print("Введите имя второго игрока: ");
        player2 = new Player(2, scanner.next());
        board.setPlayer1(player1);
        board.setPlayer2(player2);
    }

    @Override
    public boolean makeTurn(Board board, int turn, int counter1, int counter2) {
        return true;
    }

    @Override
    public void showGameOver(Board board, int counter1, int counter2) {
        System.out.println("Конец.");
    }
}
