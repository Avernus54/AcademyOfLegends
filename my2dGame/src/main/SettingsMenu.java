package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SettingsMenu extends JFrame {

    private boolean musicOn = true;
    private boolean soundOn = true;

    private JButton musicToggleBtn;
    private JButton soundToggleBtn;
    private String username;

    public SettingsMenu(String username) {
        this.username = username;

        // Frame setup
        setTitle("Academy of Legends - Settings");
        setSize(768, 576);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

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
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        // Title
        JLabel title = new JLabel("SETTINGS", SwingConstants.CENTER);
        title.setFont(new Font("Rocketfuel", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.BLACK);

        // MUSIC Toggle
        musicToggleBtn = createToggleButton("ON", new Color(100, 200, 100)); // green
        JPanel musicPanel = createTogglePanel("MUSIC", musicToggleBtn, e -> toggleMusic());

        // SOUND Toggle
        soundToggleBtn = createToggleButton("ON", new Color(100, 200, 100)); // green
        JPanel soundPanel = createTogglePanel("SOUND", soundToggleBtn, e -> toggleSound());

        // CREDITS Button
        JButton creditsButton = makeButton("CREDITS");
        creditsButton.addActionListener(e ->
                JOptionPane.showMessageDialog(this,
                        "Developed by: Your Team Name\n© 2025 Academy of Legends",
                        "Credits",
                        JOptionPane.INFORMATION_MESSAGE));

        // BACK Button
        JButton backButton = new JButton("←");
        backButton.setFont(new Font("Rocketfuel", Font.BOLD, 22));
        backButton.setFocusPainted(false);
        backButton.setBackground(new Color(200, 180, 130));
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        backButton.addActionListener(e -> {
            dispose();
            new MainMenu(username); // go back with same username
        });

        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setOpaque(false);
        topBar.add(backButton);

        // Add components
        add(topBar, BorderLayout.NORTH);
        panel.add(title);
        panel.add(Box.createVerticalStrut(50));
        panel.add(musicPanel);
        panel.add(Box.createVerticalStrut(25));
        panel.add(soundPanel);
        panel.add(Box.createVerticalStrut(25));
        panel.add(creditsButton);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createTogglePanel(String label, JButton toggleButton, ActionListener toggleAction) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JLabel lbl = new JLabel(label);
        lbl.setFont(new Font("Rocketfuel", Font.BOLD, 26));
        lbl.setForeground(Color.BLACK);

        toggleButton.addActionListener(toggleAction);

        panel.add(lbl, BorderLayout.WEST);
        panel.add(toggleButton, BorderLayout.EAST);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 4),
                BorderFactory.createEmptyBorder(15, 25, 15, 25)
        ));

        return panel;
    }

    private JButton createToggleButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Rocketfuel", Font.BOLD, 22));
        button.setFocusPainted(false);
        button.setBackground(color);
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        return button;
    }

    private JButton makeButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Rocketfuel", Font.BOLD, 26));
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(255, 220, 90));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 4),
                BorderFactory.createEmptyBorder(15, 40, 15, 40)
        ));

        // Hover color effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 230, 130));
            }

            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 220, 90));
            }
        });
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        return button;
    }

    private void toggleMusic() {
        musicOn = !musicOn;
        updateToggleButton(musicToggleBtn, musicOn);
    }

    private void toggleSound() {
        soundOn = !soundOn;
        updateToggleButton(soundToggleBtn, soundOn);
    }

    private void updateToggleButton(JButton button, boolean isOn) {
        if (isOn) {
            button.setText("ON");
            button.setBackground(new Color(100, 200, 100)); // green
        } else {
            button.setText("OFF");
            button.setBackground(new Color(180, 180, 180)); // gray
        }
    }
}
