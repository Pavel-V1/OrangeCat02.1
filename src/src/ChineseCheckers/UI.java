package ChineseCheckers;

import javax.swing.*;
import java.awt.*;

public class UI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chinese Checkers");
        CardLayout cardLayout = new CardLayout();
        JPanel mainContainer = new JPanel(cardLayout);

        JPanel menuPanel = new JPanel(new FlowLayout());
        JButton button2 = new JButton("2 players");
        JButton button3 = new JButton("3 players");
        JButton button6 = new JButton("6 players");

        menuPanel.add(new JLabel("Select players:"));
        menuPanel.add(button2);
        menuPanel.add(button3);
        menuPanel.add(button6);

        Playground playground = new Playground();

        mainContainer.add(menuPanel, "MENU");
        mainContainer.add(playground, "GAME");

        button2.addActionListener(e -> startGame(playground, cardLayout, mainContainer, 2));
        button3.addActionListener(e -> startGame(playground, cardLayout, mainContainer, 3));
        button6.addActionListener(e -> startGame(playground, cardLayout, mainContainer, 6));

        frame.add(mainContainer);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void startGame(Playground pg, CardLayout cl, JPanel container, int players) {
        pg.countOfPlayers = players;
        pg.startGame();
        cl.show(container, "GAME");
    }
}