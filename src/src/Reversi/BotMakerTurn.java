package Reversi;

import java.util.Random;

public class BotMakerTurn implements MakerTurn{
    private static final Random rnd = new Random();
    @Override
    public Position makeTurn(GameInfo gameInfo) {

        int cnt = 0;
        for (int i = 0; i < gameInfo.getHeight(); i++) {
            for (int j = 0; j < gameInfo.getWidth(); j++) {
                if (gameInfo.getCell(i, j) == 0) {
                    cnt++;
                }
            }
        }
        int n = rnd.nextInt(cnt) ;
        for (int i = 0; i < gameInfo.getHeight(); i++) {
            for (int j = 0; j < gameInfo.getWidth(); j++) {
                if (gameInfo.getCell(i, j) == 0) {
                    n--;
                    if (n <= 0) {
                        return new Position(i, j);
                    }
                }
            }
        }
        return new Position(0, 0);
    }
}
