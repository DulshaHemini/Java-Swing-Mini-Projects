import javax.swing.*;

public class ClickCounter {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Click Counter");

        frame.setSize(300, 200);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Count: 0");

        JButton button = new JButton("Click Me");

        JPanel panel = new JPanel();

        panel.add(label);
        panel.add(button);

        final int[] count = {0};
        button.addActionListener(e -> {
            count[0]++;
            label.setText("Count: " + count[0]);
        });

        frame.add(panel);

        frame.setVisible(true);
    }
}