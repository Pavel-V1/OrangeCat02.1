package ChineseCheckers;

import javax.swing.*;

public class Playground extends JPanel {
    private final int CELLS = 61 + 60; // общее поле + базы игроков
    private final int CELL_SIZE = 30;
    static int countOfPlayers; // нумерация игроков по часовой стрелке с верхнего луча

    public static void startGame() {
        boolean gameOver = false;
        Board board = new Board();

        // if (cell.isFree) {
        //     checker.jump(cell);
        // }

//        while (!gameOver) {
//            //
//            ChineseCheckers.Player player1 = new ChineseCheckers.Player(ChineseCheckers.Board.checkers1, base1, 1);
//            ChineseCheckers.Player player2 = new ChineseCheckers.Player(checkers2, base2, 2);
//            if (countOfPlayers == 2) {
//                ChineseCheckers.Player player3 = new ChineseCheckers.Player(checkers3, base3, 3);
//
//            } else if (countOfPlayers == 3) {
//                ChineseCheckers.Player player4 = new ChineseCheckers.Player(checkers4, base4, 4);
//                ChineseCheckers.Player player5 = new ChineseCheckers.Player(checkers5, base5, 5);
//                ChineseCheckers.Player player6 = new ChineseCheckers.Player(checkers6, base6, 6);
//            } else {
//                ChineseCheckers.Player player1 = new ChineseCheckers.Player(checkers1.addAll(checkers2).addAll(checkers6), )
//            }
//            //
//            for ()
//
//            if (baseFull) {
//                gameOver = true;
//            }
//        }
    }
}
