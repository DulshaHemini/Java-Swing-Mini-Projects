package ToDoList;

import javax.swing.*;
import java.awt.*;

public class TodoList {
    static void main(String[] args) {

        JFrame frame = new JFrame("To-Do List");

        frame.setSize(700, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 20);

        JLabel titleLabel = new JLabel("To-Do List");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(270, 50, 200, 40);

        JLabel taskLabel = new JLabel("Task:");
        taskLabel.setFont(normalFont);
        taskLabel.setBounds(120, 130, 100, 40);

        JTextField taskField = new JTextField();
        taskField.setFont(normalFont);
        taskField.setBounds(200, 130, 300, 40);

        JButton addButton = new JButton("Add Task");
        addButton.setFont(normalFont);
        addButton.setBounds(520, 130, 130, 40);

        // Stores the tasks
        DefaultListModel<String> taskModel = new DefaultListModel<>();

        // Displays the tasks
        JList<String> taskList = new JList<>(taskModel);
        taskList.setFont(normalFont);

        // Adds scrolling
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(150, 220, 400, 220);

        JButton removeButton = new JButton("Remove Task");
        removeButton.setFont(normalFont);
        removeButton.setBounds(250, 470, 180, 45);

        JButton clearAllButton = new JButton("Clear All");
        clearAllButton.setFont(normalFont);
        clearAllButton.setBounds(450, 470, 140, 40);

        panel.add(titleLabel);
        panel.add(taskLabel);
        panel.add(taskField);
        panel.add(addButton);
        panel.add(scrollPane);
        panel.add(removeButton);
        panel.add(clearAllButton);


        frame.add(panel);

        addButton.addActionListener(e->{
            String task = taskField.getText();
            if(!task.isEmpty()){
                taskModel.addElement(task);
                taskField.setText("");
            }
        });

        removeButton.addActionListener(e -> {

            int selectedIndex = taskList.getSelectedIndex();

            if (selectedIndex != -1) {
                taskModel.remove(selectedIndex);
            }
        });

        clearAllButton.addActionListener(e -> {
            taskModel.clear();
        });

        frame.setVisible(true);
    }
}
