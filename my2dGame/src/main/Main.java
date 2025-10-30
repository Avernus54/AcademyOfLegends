package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        // Show welcome Screen
        new WelcomeScreen();
    }

    // Called when "New Game" is clicked
    public static void startGameWindow() {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Academy Of Legends");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
