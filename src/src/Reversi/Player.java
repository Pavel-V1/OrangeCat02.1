package Reversi;

public class Player {
    private final int number;
    private final String name;

    public Player(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public Player(int number) {
        this.number = number;
        this.name = "";
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
