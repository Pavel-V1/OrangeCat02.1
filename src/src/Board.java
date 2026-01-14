import java.awt.*;
import java.util.ArrayList;

public class Board {
    public static ArrayList<Checker> checkers1 = new ArrayList<>(10);
    public static ArrayList<Checker> checkers2 = new ArrayList<>(10);
    public static ArrayList<Checker> checkers3 = new ArrayList<>(10);
    public static ArrayList<Checker> checkers4 = new ArrayList<>(10);
    public static ArrayList<Checker> checkers5 = new ArrayList<>(10);
    public static ArrayList<Checker> checkers6 = new ArrayList<>(10); // static уже плохо

    public static ArrayList<Point> base1 = new ArrayList<>(10);
    public static ArrayList<Point> base2 = new ArrayList<>(10);
    public static ArrayList<Point> base3 = new ArrayList<>(10);
    public static ArrayList<Point> base4 = new ArrayList<>(10);
    public static ArrayList<Point> base5 = new ArrayList<>(10);
    public static ArrayList<Point> base6 = new ArrayList<>(10);

    private int[][] grid = new int[25][17]; // лучше сделать граф, а тут массив клеток (узлов графа)

    public Board() {
        //
    }
}

//class Main {
//    public static void main(String[] args) {
//        int[][] grid = new int[17][25];
//        for (int i = 0; i < 17; i++) {
//            StringBuilder s = new StringBuilder();
//            for (int j = 0; j < 25; j++) {
//                if ((i + j) % 2 == 0) {
//                    grid[i][j] = 1;
//                }
//                s.append(grid[i][j] == 1 ? "*" : " ").append(" ");
//            }
//            System.out.println(s);
//        }
//    }
//}