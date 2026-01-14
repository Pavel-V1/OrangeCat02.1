import java.awt.*;
import java.util.ArrayList;

public class Player {
    private final ArrayList<Point> baseCells;
    private final ArrayList<Checker> checkers;
    private final int number;

    public Player(ArrayList<Checker> checkers, ArrayList<Point> baseCells, int number) {
        this.baseCells = baseCells;
        this.checkers = checkers;
        this.number = number;
    }

    public ArrayList<Point> getBaseCells() {
        return baseCells;
    }

    public ArrayList<Checker> getCheckers() {
        return checkers;
    }

    public int getNumber() {
        return number;
    }
}
