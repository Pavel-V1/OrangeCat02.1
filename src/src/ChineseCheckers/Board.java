package ChineseCheckers;

import java.util.ArrayList;

public class Board {
    private ArrayList<Checker> checkers1 = new ArrayList<>();
    private ArrayList<Checker> checkers2 = new ArrayList<>();
    private ArrayList<Checker> checkers3 = new ArrayList<>();
    private ArrayList<Checker> checkers4 = new ArrayList<>();
    private ArrayList<Checker> checkers5 = new ArrayList<>();
    private ArrayList<Checker> checkers6 = new ArrayList<>();
    private ArrayList<ArrayList<Cell>> bases = new ArrayList<>();
    private ArrayList<Cell> base1 = new ArrayList<>();
    private ArrayList<Cell> base2 = new ArrayList<>();
    private ArrayList<Cell> base3 = new ArrayList<>();
    private ArrayList<Cell> base4 = new ArrayList<>();
    private ArrayList<Cell> base5 = new ArrayList<>();
    private ArrayList<Cell> base6 = new ArrayList<>();
    private ArrayList<ArrayList<Checker>> allCheckers = new ArrayList<>();

    public Board() {
        bases.add(base1);
        bases.add(base2);
        bases.add(base3);
        bases.add(base4);
        bases.add(base5);
        bases.add(base6);
        allCheckers.add(checkers1);
        allCheckers.add(checkers2);
        allCheckers.add(checkers3);
        allCheckers.add(checkers4);
        allCheckers.add(checkers5);
        allCheckers.add(checkers6);
        ArrayList<ArrayList<Integer>> graphList = createGraphList();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 6; j++) {
                bases.get(j).add(new Cell(j * 10 + i, false));
            }
        }
        //
    }

    public ArrayList<Cell> getBase(int i) {
        if (i < 1 || i > 6) {
            return bases.get(i - 1);
        } else {
            return null;
        }
    }

    private ArrayList<ArrayList<Integer>> createGraphList() {
        ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();

        for (int i = 0; i < 60; i += 10) {  // строю базы игроков
            for (int j = 0; j < 10; j++) {
                ArrayList<Integer> a = new ArrayList<>();
                if (j <= 2) {
                    for (int k = 0; k < (j == 0 ? 3 : j + 3); k++) {
                        if (k != j) {
                            a.add(k + i);
                        }
                    }
                } else {
                    if (j == 3) {
                        a.add(i + 1);
                        a.add(i + 4);
                        a.add(i + 6);
                        a.add(i + 7);
                    } else if (j == 5) {
                        a.add(i + 2);
                        a.add(i + 4);
                        a.add(i + 8);
                        a.add(i + 9);
                    } else if (j == 6) {
                        a.add(i + 3);
                        a.add(i + 7);
                        a.add(i + 60);
                        a.add(i + 61);
                    } else if (j == 9) {
                        a.add(i + 5);
                        a.add(i + 8);
                        a.add(i + 63);
                        a.add(i == 50 ? 60 : i + 70);
                    } else {
                        int r = j < 6 ? 3 : 4;
                        for (int k = (r == 3 ? 3 : 6); k <= (r == 3 ? 5 : 9); k++) {
                            a.add(j - r + i);
                            a.add(j - r + 1 + i);
                            a.add(j - 1 + i);
                            a.add(j + 1 + i);
                            a.add(r == 3 ? (j + r + i    ) : (j + 54 + i));
                            a.add(r == 3 ? (j + r + 1 + i) : (j + 55 + i));
                        }
                    }
                }
                graphList.add(i + j, a);
                a.clear();
            }
        }
        for (int i = 60; i < 120; i++) {  // строю общее поле (центр)
            for (int j = 0; j < 10; j++) {
                ArrayList<Integer> a = new ArrayList<>();
                if (j == 0) {
                    a.add(j - 54 + i);
                    a.add(i == 60 ? 59 : i - 61);
                    a.add(i == 60 ? 113 : i - 7);
                    a.add(i + 1);
                    a.add(i + 4);
                } else if (j == 9) {
                    a.add(120);
                    a.add(i == 110 ? 69 : i + 19);
                    a.add(i == 60 ? 119 : i - 1);
                    a.add(i == 60 ? 118 : i - 2);
                    a.add(i + j - 1);
                    a.add(i + j - 2);
                } else if (j < 4) {
                    a.add(i + j - 55);
                    a.add(i + j - 54);
                    if (i == 110) {
                        //
                    } else {
                        a.add(j == 3 ? i + j + 7 : i + j + 1);
                        a.add(j == 3 ? i + j + 11 : i + j + 4);
                        a.add(i + j + 3);
                        a.add(i + j - 1);
                    }
                }
                graphList.add(i + j, a);
                a.clear();
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 6; i < 12; i++) {
            a.add(i * 10 + 9);
        }
        graphList.add(120, a);
        return graphList;
    }
}
