package ChineseCheckers;

import java.awt.*;
import java.util.ArrayList;

public class Player {
    private final ArrayList<Point> baseCells;
    private final ArrayList<Point> finishCells;
    private final ArrayList<Checker> checkers;
    private final int number;

    public Player(ArrayList<Checker> checkers, ArrayList<Point> baseCells, ArrayList<Point> finishCells, int number) {
        this.checkers = checkers;
        this.baseCells = baseCells;
        this.finishCells = finishCells;
        this.number = number;
    }

    public ArrayList<Point> getBaseCells() {
        return baseCells;
    }

    public ArrayList<Checker> getCheckers() {
        return checkers;
    }

    public ArrayList<Point> getFinishCells() {
        return finishCells;
    }

    public int getNumber() {
        return number;
    }
}
