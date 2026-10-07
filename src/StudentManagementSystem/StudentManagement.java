package StudentManagementSystem;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagement {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Management");

        frame.setSize(850, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 20);

        // Title
        JLabel titleLabel = new JLabel("Student Management");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(260, 40, 350, 40);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(normalFont);
        nameLabel.setBounds(180, 120, 150, 40);

        JTextField nameField = new JTextField();
        nameField.setFont(normalFont);
        nameField.setBounds(350, 120, 280, 40);

        // Student ID
        JLabel stuIDLabel = new JLabel("Student ID:");
        stuIDLabel.setFont(normalFont);
        stuIDLabel.setBounds(180, 180, 150, 40);

        JTextField stuIDField = new JTextField();
        stuIDField.setFont(normalFont);
        stuIDField.setBounds(350, 180, 280, 40);

        // Course
        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setFont(normalFont);
        courseLabel.setBounds(180, 240, 150, 40);

        JTextField courseField = new JTextField();
        courseField.setFont(normalFont);
        courseField.setBounds(350, 240, 280, 40);

        JButton addButton = new JButton("Add");
        addButton.setFont(normalFont);
        addButton.setBounds(180, 320, 120, 45);

        JButton updateButton = new JButton("Update");
        updateButton.setFont(normalFont);
        updateButton.setBounds(330, 320, 120, 45);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(normalFont);
        deleteButton.setBounds(480, 320, 120, 45);

        String[] columns = {
                "Name",
                "Student ID",
                "Course"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        JTable studentTable = new JTable(tableModel);
        studentTable.setFont(normalFont);
        studentTable.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBounds(120, 400, 600, 200);

        // Add components
        panel.add(titleLabel);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(stuIDLabel);
        panel.add(stuIDField);

        panel.add(courseLabel);
        panel.add(courseField);

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        panel.add(scrollPane);

        frame.add(panel);

        addButton.addActionListener(e->{
            String name = nameField.getText();
            String studID = stuIDField.getText();
            String course = courseField.getText();

            if(name.isEmpty()||
                studID.isEmpty()||
                course.isEmpty()){
            } else {
                Object[] row = {name, studID, course};
                tableModel.addRow(row);

                nameField.setText("");
                stuIDField.setText("");
                courseField.setText("");
            }


        });

        updateButton.addActionListener(e -> {

            int selectedRow = studentTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a student to update"
                );

            } else {

                String name = nameField.getText();
                String studentID = stuIDField.getText();
                String course = courseField.getText();

                if (name.isEmpty() ||
                        studentID.isEmpty() ||
                        course.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please fill all fields"
                    );

                } else {

                    tableModel.setValueAt(name, selectedRow, 0);
                    tableModel.setValueAt(studentID, selectedRow, 1);
                    tableModel.setValueAt(course, selectedRow, 2);

                    nameField.setText("");
                    stuIDField.setText("");
                    courseField.setText("");
                }
            }
        });

        deleteButton.addActionListener(e -> {

            int selectedRow = studentTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a student to delete"
                );

            } else {

                tableModel.removeRow(selectedRow);

                nameField.setText("");
                stuIDField.setText("");
                courseField.setText("");
            }
        });

        frame.setVisible(true);
    }
}