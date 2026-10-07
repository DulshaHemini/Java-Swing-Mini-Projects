package StudentMarksCalculator;

import javax.swing.*;
import  java.awt.*;

public class StudentMarksCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Marks Calculator");

        frame.setSize(700, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 20);

        JLabel titleLabel = new JLabel("Student Marks Calculator");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(170, 50, 400, 40);

        JLabel subject1Label = new JLabel("Subject 1:");
        subject1Label.setFont(normalFont);
        subject1Label.setBounds(150, 150, 150, 40);

        JTextField subject1Field = new JTextField();
        subject1Field.setFont(normalFont);
        subject1Field.setBounds(320, 150, 220, 40);

        JLabel subject2Label = new JLabel("Subject 2:");
        subject2Label.setFont(normalFont);
        subject2Label.setBounds(150, 220, 150, 40);

        JTextField subject2Field = new JTextField();
        subject2Field.setFont(normalFont);
        subject2Field.setBounds(320, 220, 220, 40);

        JLabel subject3Label = new JLabel("Subject 3:");
        subject3Label.setFont(normalFont);
        subject3Label.setBounds(150, 290, 150, 40);

        JTextField subject3Field = new JTextField();
        subject3Field.setFont(normalFont);
        subject3Field.setBounds(320, 290, 220, 40);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(normalFont);
        calculateButton.setBounds(220, 370, 140, 45);

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(normalFont);
        clearButton.setBounds(390, 370, 120, 45);

        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setFont(normalFont);
        totalLabel.setBounds(200, 450, 350, 40);

        JLabel averageLabel = new JLabel("Average:");
        averageLabel.setFont(normalFont);
        averageLabel.setBounds(200, 500, 350, 40);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setFont(normalFont);
        gradeLabel.setBounds(200, 550, 350, 40);

        panel.add(titleLabel);

        panel.add(subject1Label);
        panel.add(subject1Field);

        panel.add(subject2Label);
        panel.add(subject2Field);

        panel.add(subject3Label);
        panel.add(subject3Field);

        panel.add(calculateButton);
        panel.add(clearButton);

        panel.add(totalLabel);
        panel.add(averageLabel);
        panel.add(gradeLabel);

        frame.add(panel);

        calculateButton.addActionListener(e -> {

            try {

                double subject1 =
                        Double.parseDouble(subject1Field.getText());

                double subject2 =
                        Double.parseDouble(subject2Field.getText());

                double subject3 =
                        Double.parseDouble(subject3Field.getText());

                // Validation
                if (subject1 < 0 || subject1 > 100 ||
                        subject2 < 0 || subject2 > 100 ||
                        subject3 < 0 || subject3 > 100) {

                    totalLabel.setText(
                            "Marks must be between 0 and 100"
                    );

                    averageLabel.setText("Average:");
                    gradeLabel.setText("Grade:");

                    return;
                }

                double total = subject1 + subject2 + subject3;

                double average = total / 3;

                totalLabel.setText(
                        "Total: " + String.format("%.2f", total)
                );

                averageLabel.setText(
                        "Average: " + String.format("%.2f", average)
                );

                if (average >= 75) {

                    gradeLabel.setText("Grade: A");

                } else if (average >= 65) {

                    gradeLabel.setText("Grade: B");

                } else if (average >= 55) {

                    gradeLabel.setText("Grade: C");

                } else if (average >= 45) {

                    gradeLabel.setText("Grade: D");

                } else {

                    gradeLabel.setText("Grade: F");
                }

            } catch (NumberFormatException ex) {

                totalLabel.setText("Please enter valid marks");
                averageLabel.setText("Average:");
                gradeLabel.setText("Grade:");
            }
        });

        clearButton.addActionListener(e -> {

            subject1Field.setText("");
            subject2Field.setText("");
            subject3Field.setText("");

            totalLabel.setText("Total:");
            averageLabel.setText("Average:");
            gradeLabel.setText("Grade:");
        });

        frame.setVisible(true);


    }
}
