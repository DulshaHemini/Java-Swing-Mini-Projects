package MultiscreenSwingapplication;

import javax.swing.*;
import java.awt.*;

public class Registration {

    public Registration() {

        JFrame frame = new JFrame("Registration");

        frame.setSize(700, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 20);

        JLabel titleLabel = new JLabel("Create Account");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(240, 40, 300, 40);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(normalFont);
        nameLabel.setBounds(150, 130, 150, 40);

        JTextField nameField = new JTextField();
        nameField.setFont(normalFont);
        nameField.setBounds(320, 130, 250, 40);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(normalFont);
        usernameLabel.setBounds(150, 200, 150, 40);

        JTextField usernameField = new JTextField();
        usernameField.setFont(normalFont);
        usernameField.setBounds(320, 200, 250, 40);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(normalFont);
        passwordLabel.setBounds(150, 270, 150, 40);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(normalFont);
        passwordField.setBounds(320, 270, 250, 40);

        JLabel confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setFont(normalFont);
        confirmLabel.setBounds(150, 340, 180, 40);

        JPasswordField confirmField = new JPasswordField();
        confirmField.setFont(normalFont);
        confirmField.setBounds(320, 340, 250, 40);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(normalFont);
        registerButton.setBounds(250, 430, 150, 45);

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(normalFont);
        clearButton.setBounds(420, 430, 120, 45);

        JLabel messageLabel = new JLabel("");
        messageLabel.setFont(normalFont);
        messageLabel.setBounds(180, 510, 400, 40);

        panel.add(titleLabel);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(usernameLabel);
        panel.add(usernameField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(confirmLabel);
        panel.add(confirmField);

        panel.add(registerButton);
        panel.add(clearButton);

        panel.add(messageLabel);

        clearButton.addActionListener(e -> {

            nameField.setText("");
            usernameField.setText("");
            passwordField.setText("");
            confirmField.setText("");
            messageLabel.setText("");
        });

        registerButton.addActionListener(e -> {

            String password =
                    new String(passwordField.getPassword());

            String confirmPassword =
                    new String(confirmField.getPassword());

            if (nameField.getText().isEmpty()
                    || usernameField.getText().isEmpty()
                    || password.isEmpty()
                    || confirmPassword.isEmpty()) {

                messageLabel.setText("Please fill all fields");

            } else if (!password.equals(confirmPassword)) {

                messageLabel.setText("Passwords do not match");

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Registration Successful"
                );

                frame.dispose();
            }
        });

        frame.add(panel);

        frame.setVisible(true);
    }
}