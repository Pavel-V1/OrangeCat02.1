import java.awt.*;

public class Checker {
    private int x;
    private int y;
    private final int player;

    public Checker(int x, int y, int player) {
        this.x = x;
        this.y = y;
        this.player = player;
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
}
