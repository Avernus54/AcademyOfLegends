package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
private String username;
    public MainMenu(String username) {
    	  this.username = username;
    	// Frame setup
        setTitle("Academy of Legends - Menu");
        setSize(768, 576);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Background panel
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(245, 234, 200)); // parchment color
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(80, 100, 80, 100));

        // Title
        JLabel title = new JLabel("ACADEMY OF LEGENDS", SwingConstants.CENTER);
        title.setFont(new Font("Rocketfuel", Font.BOLD, 38));
        title.setForeground(Color.BLACK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Buttons
        JButton btnNewGame = makeButton("New Game");
        JButton btnDifficulty = makeButton("Difficulty");
        JButton btnSetting = makeButton("Setting");
        JButton btnLogout = makeButton("Logout");

        // Actions
        btnNewGame.addActionListener(e -> {
            dispose(); // close menu window
            // Start your existing game
            Main.startGameWindow();
        });

        btnDifficulty.addActionListener(e -> JOptionPane.showMessageDialog(this, "Difficulty settings coming soon!"));
        btnSetting.addActionListener(e -> JOptionPane.showMessageDialog(this, "Settings coming soon!"));
        btnLogout.addActionListener(e -> System.exit(0));

        // Add components
        panel.add(title);
        panel.add(Box.createVerticalStrut(60));
        panel.add(btnNewGame);
        panel.add(Box.createVerticalStrut(25));
        panel.add(btnDifficulty);
        panel.add(Box.createVerticalStrut(25));
        panel.add(btnSetting);
        panel.add(Box.createVerticalStrut(25));
        panel.add(btnLogout);

        add(panel);
        setVisible(true);
    }

    private JButton makeButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Rocketfuel", Font.BOLD, 22));
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(255, 220, 90));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(10, 25, 10, 25)
        ));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Hover color effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 230, 130));
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 220, 90));
            }
        });

        return button;
    }
}
