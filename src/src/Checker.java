import java.awt.*;

public class Checker {
    private int x;
    private int y;
    private final int player;
    private final int number;


    public Checker(int x, int y, int player, int number) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.number = number;
    }

    public void jump(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void jump(Point p) {
        jump(p.x, p.y);
    }

    public int getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }
}
