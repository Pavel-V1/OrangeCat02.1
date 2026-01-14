import java.awt.*;
import java.util.ArrayList;

public class Player {
    private final ArrayList<Point> cells;
    private final ArrayList<Checker> checkers;

    public Player(ArrayList<Checker> checkers, ArrayList<Point> cells) {
        this.cells = cells;
        this.checkers = checkers;
    }

    public ArrayList<Point> getCells() {
        return cells;
    }

    public ArrayList<Checker> getCheckers() {
        return checkers;
    }
}
