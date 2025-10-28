package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JFrame {

    private JTextField usernameField;
    private JButton okButton;

    public WelcomeScreen() {
        // Window settings
        setTitle("Welcome Player");
        setSize(768, 576); // same as GamePanel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        // Background color
        getContentPane().setBackground(new Color(255, 230, 200)); // light peach background

        // Title label
        JLabel title = new JLabel("WELCOME", SwingConstants.LEFT);
        title.setFont(new Font("Rocketfuel", Font.BOLD, 48));
        title.setForeground(Color.RED);
        title.setBounds(160, 80, 350, 60);
        add(title);

        JLabel player = new JLabel("PLAYER", SwingConstants.LEFT);
        player.setFont(new Font("Rocketfuel", Font.BOLD, 48));
        player.setForeground(new Color(34, 120, 34));
        player.setBounds(420, 80, 300, 60);
        add(player);

        // Username label
        JLabel usernameLabel = new JLabel("UsErNaMe:");
        usernameLabel.setFont(new Font("Rocketfuel", Font.BOLD, 30));
        usernameLabel.setBounds(140, 230, 250, 50);
        add(usernameLabel);

        // Username text field
        usernameField = new JTextField();
        usernameField.setFont(new Font("Rocketfuel", Font.PLAIN, 28));
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        usernameField.setBounds(360, 230, 350, 50);
        usernameField.setText(""); // or default name
        add(usernameField);

        // OK button
        okButton = new JButton("OK");
        okButton.setFont(new Font("Rocketfuel", Font.BOLD, 28));
        okButton.setBackground(new Color(50, 120, 50));
        okButton.setForeground(Color.WHITE);
        okButton.setFocusPainted(false);
        okButton.setBounds(520, 330, 120, 55);
        okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(okButton);

        // Button click → go to main menu
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                if (!username.isEmpty()) {
                    dispose(); // close welcome window
                    new MainMenu(username); // open main menu
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter your username!");
                }
            }
        });

        setVisible(true);
    }
}
