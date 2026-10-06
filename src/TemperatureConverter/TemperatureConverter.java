package TemperatureConverter;
import javax.swing.*;

public class TemperatureConverter {
    static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");

        frame.setSize(600, 250);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel celsiusLabel = new JLabel("Celsius:");
        JTextField celsiusField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Fahrenheit: ");

        panel.add(celsiusLabel);
        panel.add(celsiusField);
        panel.add(convertButton);
        panel.add(resultLabel);

        frame.add(panel);

        convertButton.addActionListener(e -> {

            try {
                double celsius = Double.parseDouble(celsiusField.getText());

                double fahrenheit = (celsius * 9 / 5) + 32;

                resultLabel.setText("Fahrenheit: " + fahrenheit);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Enter a valid number");
            }
        });

        frame.setVisible(true);
    }
}
