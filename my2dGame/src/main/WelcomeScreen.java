package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomeScreen extends JFrame {

    public WelcomeScreen() {
        // Frame setup
        setTitle("Academy of Legends - Welcome");
        setSize(768, 576);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Background Panel
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(245, 234, 200)); // parchment color
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(60, 150, 60, 150));

        // -----------------------------------------------------
        // 🔥 ADD LOGO HERE
        // -----------------------------------------------------
        ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
 
        Image scaled = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaled));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        // -----------------------------------------------------

        JLabel title = new JLabel("ACADEMY OF LEGENDS", SwingConstants.CENTER);
        title.setFont(new Font("Rocketfuel", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.BLACK);

        JTextField txtUsername = new JTextField();
        txtUsername.setMaximumSize(new Dimension(300, 40));
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 20));
        txtUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtUsername.setHorizontalAlignment(JTextField.CENTER);

        JButton btnEnter = new JButton("ENTER");
        btnEnter.setFont(new Font("Rocketfuel", Font.BOLD, 26));
        btnEnter.setFocusPainted(false);
        btnEnter.setBackground(new Color(255, 220, 90));
        btnEnter.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        btnEnter.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnEnter.addActionListener(e -> {
            String username = txtUsername.getText().trim();
            if (!username.isEmpty()) {
                dispose();
                new MainMenu(username); 
            } else {
                JOptionPane.showMessageDialog(this, "Please enter your username first!");
            }
        });

        // Add components to panel
        panel.add(logoLabel);                  // 🔥 add logo first
        panel.add(Box.createVerticalStrut(20));
        panel.add(title);
        panel.add(Box.createVerticalStrut(40));
        panel.add(txtUsername);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btnEnter);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WelcomeScreen::new);
    }
}
