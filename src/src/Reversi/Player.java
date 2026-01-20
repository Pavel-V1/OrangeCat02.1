package Reversi;

public class Player {
    private final int number;
    private final String name;
    private MakerTurn mt;

    public Player(int number, String name, MakerTurn makerTurn) {
        this.number = number;
        this.name = name;
        this.mt = makerTurn;
    }

    public MakerTurn getMakerTurn() {
        return mt;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Player clone() {
        return new Player(number, name, mt);
    }
}
