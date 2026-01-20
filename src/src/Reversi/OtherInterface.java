package Reversi;

import java.util.Scanner;

public class OtherInterface extends Board {

    @Override
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя первого игрока: ");
        setPlayer1(new Player(1, scanner.next(), new HumanMakerTurn()));
        System.out.print("Введите имя второго игрока: ");
        setPlayer2(new Player(2, scanner.next(), new HumanMakerTurn()));
    }

    public Position makeTurn(GameInfo gameInfo) {
        return null;
    }

    @Override
    public void showGameOver (int counter1, int counter2, Player player1, Player player2) {
        System.out.println("Всё!");
    }
}
