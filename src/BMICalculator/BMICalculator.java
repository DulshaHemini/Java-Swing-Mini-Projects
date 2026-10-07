package BMICalculator;

import javax.swing.*;
import java.awt.*;

public class BMICalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("BMI Calculator");

        frame.setSize(700, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Fonts
        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 18);
        Font buttonFont = new Font("Arial", Font.BOLD, 18);

        // Title
        JLabel lblTitle = new JLabel("BMI Calculator");
        lblTitle.setFont(titleFont);
        lblTitle.setBounds(240, 50, 250, 40);

        // Weight
        JLabel lblWeight = new JLabel("Weight (kg)");
        lblWeight.setFont(normalFont);
        lblWeight.setBounds(150, 140, 150, 35);

        JTextField weightField = new JTextField();
        weightField.setFont(normalFont);
        weightField.setBounds(300, 140, 220, 40);

        // Height
        JLabel lblHeight = new JLabel("Height (m)");
        lblHeight.setFont(normalFont);
        lblHeight.setBounds(150, 210, 150, 35);

        JTextField heightField = new JTextField();
        heightField.setFont(normalFont);
        heightField.setBounds(300, 210, 220, 40);

        // Calculate Button
        JButton calculateButton = new JButton("Calculate BMI");
        calculateButton.setFont(buttonFont);
        calculateButton.setBounds(200, 300, 190, 45);

        // Clear Button
        JButton clearButton = new JButton("Clear");
        clearButton.setFont(buttonFont);
        clearButton.setBounds(410, 300, 110, 45);

        // BMI Result
        JLabel resultLabel = new JLabel("BMI:");
        resultLabel.setFont(normalFont);
        resultLabel.setBounds(220, 400, 300, 35);

        // Status
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setFont(normalFont);
        statusLabel.setBounds(220, 450, 300, 35);

        // Add components
        panel.add(lblTitle);
        panel.add(lblWeight);
        panel.add(weightField);
        panel.add(lblHeight);
        panel.add(heightField);
        panel.add(calculateButton);
        panel.add(clearButton);
        panel.add(resultLabel);
        panel.add(statusLabel);

        frame.add(panel);

        // Calculate BMI
        calculateButton.addActionListener(e -> {

            try {

                double weight =
                        Double.parseDouble(weightField.getText());

                double height =
                        Double.parseDouble(heightField.getText());

                if (weight <= 0 || height <= 0) {
                    resultLabel.setText("Please enter positive values");
                    statusLabel.setText("Status:");
                    return;
                }

                double bmi = weight / (height * height);

                resultLabel.setText(
                        "BMI: " + String.format("%.2f", bmi)
                );

                if (bmi < 18.5) {
                    statusLabel.setText("Status: Underweight");

                } else if (bmi < 25) {
                    statusLabel.setText("Status: Normal");

                } else if (bmi < 30) {
                    statusLabel.setText("Status: Overweight");

                } else {
                    statusLabel.setText("Status: Obese");
                }

            } catch (NumberFormatException ex) {

                resultLabel.setText("Please enter valid numbers");
                statusLabel.setText("Status:");
            }
        });

        // Clear
        clearButton.addActionListener(e -> {

            weightField.setText("");
            heightField.setText("");

            resultLabel.setText("BMI:");
            statusLabel.setText("Status:");
        });

        frame.setVisible(true);
    }
}