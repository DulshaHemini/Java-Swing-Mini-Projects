package MultiscreenSwingapplication;

import javax.swing.*;
import java.awt.*;

public class Login {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");

        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 20);

        // Title
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(300, 60, 200, 40);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(normalFont);
        usernameLabel.setBounds(150, 160, 150, 40);

        JTextField usernameField = new JTextField();
        usernameField.setFont(normalFont);
        usernameField.setBounds(320, 160, 250, 40);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(normalFont);
        passwordLabel.setBounds(150, 230, 150, 40);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(normalFont);
        passwordField.setBounds(320, 230, 250, 40);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(normalFont);
        loginButton.setBounds(220, 330, 130, 45);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setFont(normalFont);
        registerButton.setBounds(380, 330, 140, 45);

        // Message
        JLabel messageLabel = new JLabel("");
        messageLabel.setFont(normalFont);
        messageLabel.setBounds(180, 420, 400, 40);

        // Add components
        panel.add(titleLabel);

        panel.add(usernameLabel);
        panel.add(usernameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(loginButton);
        panel.add(registerButton);

        panel.add(messageLabel);

        frame.add(panel);

        // Login Button Action
        loginButton.addActionListener(e -> {

            String username = usernameField.getText();
            String password =
                    new String(passwordField.getPassword());

            if (username.equals("admin")
                    && password.equals("1234")) {

                new Dashboard();

                frame.dispose();

            } else {

                messageLabel.setText(
                        "Invalid Username or Password"
                );
            }
        });

        // Register Button Action
        registerButton.addActionListener(e -> {

            new Registration();
        });

        frame.setVisible(true);
    }
}