package CardLayoutDemo;

import javax.swing.*;
import java.awt.*;

public class CardLayoutDemo {
    public static void main(String[] args) {

        JFrame frame = new JFrame("CardLayout Demo");

        frame.setSize(700, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel mainPanel = new JPanel(cardLayout);

        JPanel loginPanel = new JPanel();
        JPanel dashboardPanel = new JPanel();

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(dashboardPanel, "Dashboard");

        frame.add(mainPanel);

        frame.setVisible(true);
    }
}
