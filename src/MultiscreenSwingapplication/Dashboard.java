package MultiscreenSwingapplication;

import javax.swing.*;
import java.awt.*;

public class Dashboard {

    public Dashboard() {

        JFrame frame = new JFrame("Dashboard");

        frame.setSize(750, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 20);

        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(290, 50, 250, 40);

        JLabel welcomeLabel = new JLabel("Welcome, Admin");
        welcomeLabel.setFont(normalFont);
        welcomeLabel.setBounds(290, 120, 250, 40);

        JButton studentsButton = new JButton("Students");
        studentsButton.setFont(normalFont);
        studentsButton.setBounds(170, 220, 160, 50);

        JButton coursesButton = new JButton("Courses");
        coursesButton.setFont(normalFont);
        coursesButton.setBounds(400, 220, 160, 50);

        JButton profileButton = new JButton("Profile");
        profileButton.setFont(normalFont);
        profileButton.setBounds(170, 310, 160, 50);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(normalFont);
        logoutButton.setBounds(400, 310, 160, 50);

        panel.add(titleLabel);
        panel.add(welcomeLabel);
        panel.add(studentsButton);
        panel.add(coursesButton);
        panel.add(profileButton);
        panel.add(logoutButton);

        frame.add(panel);

        logoutButton.addActionListener(e -> {

            Login.main(new String[]{});

            frame.dispose();
        });

        frame.setVisible(true);
    }
}