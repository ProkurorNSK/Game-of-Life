package life;

import javax.swing.*;

public class GameOfLife extends JFrame {

    private final JLabel generationLabel;
    private final JLabel aliveLabel;
    private final MyPanel myPanel;
    private final int size = 20;

    public static void main(String[] args) {
        new GameOfLife();
    }

    public void setGeneration(int generation) {
        generationLabel.setText(String.format("Generation #%d", generation));
    }

    public void setAlive(int alive) {
        aliveLabel.setText(String.format("Alive: %d", alive));
    }

    public GameOfLife() {
        Game game = new Game(size, this);
        Thread gameThread = new Thread(game);
        gameThread.setDaemon(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        generationLabel = new JLabel(String.valueOf(0));
        generationLabel.setName("GenerationLabel");
        panel.add(generationLabel);

        aliveLabel = new JLabel(String.valueOf(0));
        aliveLabel.setName("AliveLabel");
        panel.add(aliveLabel);

        JToggleButton toggleButton = new JToggleButton("Pause", false);
        toggleButton.addActionListener(e -> {
            game.setRun(!toggleButton.isSelected());
            toggleButton.setText(toggleButton.isSelected() ? "Resume" : "Pause");
        });
        toggleButton.setName("PlayToggleButton");
        panel.add(toggleButton);

        JButton restartButton = new JButton("Restart");
        restartButton.addActionListener(e -> game.init(size));
        restartButton.setName("ResetButton");
        panel.add(restartButton);

        add(panel);

        myPanel = new MyPanel();
        add(myPanel);

        setVisible(true);
        gameThread.start();
    }

    public void setField(Universe universe) {
        myPanel.printField(universe);
    }
}
