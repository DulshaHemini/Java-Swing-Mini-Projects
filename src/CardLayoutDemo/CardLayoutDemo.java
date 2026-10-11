package CardLayoutDemo;

import javax.swing.*;
import java.awt.*;

public class CardLayoutDemo {

    public static void main(String[] args) {

        // Main Frame
        JFrame frame = new JFrame("CardLayout Demo");

        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout
        CardLayout cardLayout = new CardLayout();

        // Main panel that holds all cards
        JPanel mainPanel = new JPanel(cardLayout);

        // Fonts
        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 20);

        // =========================
        // LOGIN PANEL
        // =========================

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        JLabel loginTitle = new JLabel("Login");
        loginTitle.setFont(titleFont);
        loginTitle.setBounds(300, 80, 150, 40);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(normalFont);
        usernameLabel.setBounds(170, 180, 130, 40);

        JTextField usernameField = new JTextField();
        usernameField.setFont(normalFont);
        usernameField.setBounds(320, 180, 220, 40);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(normalFont);
        passwordLabel.setBounds(170, 250, 130, 40);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(normalFont);
        passwordField.setBounds(320, 250, 220, 40);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(normalFont);
        loginButton.setBounds(275, 340, 150, 45);

        JLabel messageLabel = new JLabel("");
        messageLabel.setFont(normalFont);
        messageLabel.setBounds(200, 410, 400, 40);

        loginPanel.add(loginTitle);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(messageLabel);

        // =========================
        // DASHBOARD PANEL
        // =========================

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);

        JLabel dashboardTitle = new JLabel("Dashboard");
        dashboardTitle.setFont(titleFont);
        dashboardTitle.setBounds(270, 80, 250, 40);

        JLabel welcomeLabel = new JLabel("Welcome, Admin");
        welcomeLabel.setFont(normalFont);
        welcomeLabel.setBounds(270, 150, 250, 40);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(normalFont);
        logoutButton.setBounds(275, 250, 150, 45);

        dashboardPanel.add(dashboardTitle);
        dashboardPanel.add(welcomeLabel);
        dashboardPanel.add(logoutButton);

        // =========================
        // ADD PANELS TO CARDLAYOUT
        // =========================

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(dashboardPanel, "Dashboard");

        frame.add(mainPanel);

        // =========================
        // LOGIN BUTTON ACTION
        // =========================

        loginButton.addActionListener(e -> {

            String username = usernameField.getText();

            String password =
                    new String(passwordField.getPassword());

            if (username.equals("admin")
                    && password.equals("1234")) {

                messageLabel.setText("");

                cardLayout.show(
                        mainPanel,
                        "Dashboard"
                );

            } else {

                messageLabel.setText(
                        "Invalid Username or Password"
                );
            }
        });

        // =========================
        // LOGOUT BUTTON ACTION
        // =========================

        logoutButton.addActionListener(e -> {

            usernameField.setText("");
            passwordField.setText("");
            messageLabel.setText("");

            cardLayout.show(
                    mainPanel,
                    "Login"
            );
        });

        frame.setVisible(true);
    }
}