package SimpleCalculator;

import javax.swing.*;

public class SimpleCalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Calculator");

        frame.setSize(950, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel number1Label = new JLabel("Number 1:");
        JLabel number2Label = new JLabel("Number 2:");

        JTextField number1Field = new JTextField(10);
        JTextField number2Field = new JTextField(10);

        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");
        JButton clearButton = new JButton("Clear");

        JLabel resultLabel = new JLabel("Result: ");

        panel.add(number1Label);
        panel.add(number1Field);

        panel.add(number2Label);
        panel.add(number2Field);

        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(clearButton);

        panel.add(resultLabel);

        frame.add(panel);

        addButton.addActionListener(e -> {

            try {
                int number1 = Integer.parseInt(number1Field.getText());
                int number2 = Integer.parseInt(number2Field.getText());

                int result = number1 + number2;

                resultLabel.setText("Result: " + result);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers");
            }
        });

        subtractButton.addActionListener(e -> {

            int number1 = Integer.parseInt(number1Field.getText());
            int number2 = Integer.parseInt(number2Field.getText());

            int result = number1 - number2;

            resultLabel.setText("Result: " + result);
        });

        multiplyButton.addActionListener(e -> {

            int number1 = Integer.parseInt(number1Field.getText());
            int number2 = Integer.parseInt(number2Field.getText());

            int result = number1 * number2;

            resultLabel.setText("Result: " + result);
        });

        divideButton.addActionListener(e -> {

            double number1 = Double.parseDouble(number1Field.getText());
            double number2 = Double.parseDouble(number2Field.getText());

            if (number2 == 0) {
                resultLabel.setText("Cannot divide by zero");
            } else {
                double result = number1 / number2;
                resultLabel.setText("Result: " + result);
            }
        });

        clearButton.addActionListener(e -> {

            number1Field.setText("");
            number2Field.setText("");
            resultLabel.setText("Result: ");
        });

        frame.setVisible(true);
    }
}