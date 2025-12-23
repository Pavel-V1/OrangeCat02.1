import javax.swing.*;
import java.awt.*;

public class StartUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chinese checkers");
        Playground playground = new Playground();
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);
        JButton startGameButton = new JButton("Play");
        startGameButton.addActionListener(e -> Playground.startGame());
        JButton button2 = new JButton("2 players");
        JButton button3 = new JButton("3 players");
        JButton button6 = new JButton("6 players");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startGameButton);

        frame.setLayout(new BorderLayout());
        panel.add(button2);
        panel.add(button3);
        panel.add(button6);
        frame.add(playground);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.getContentPane().add(panel, BorderLayout.BEFORE_FIRST_LINE);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setMinimumSize(frame.getSize());

        button2.addActionListener(e -> {
            playground.countOfPlayers = 2;
            // закрыть текущее окно
            // запустить главное окно и начать игру
            // либо
            // сменить компоненты в окне и начать игру
        });

        button3.addActionListener(e -> {
            playground.countOfPlayers = 3;
            //
        });

        button6.addActionListener(e -> {
            playground.countOfPlayers = 6;
            //
        });
    }
}
