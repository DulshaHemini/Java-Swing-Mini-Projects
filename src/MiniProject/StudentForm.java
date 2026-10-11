package MiniProject;

import javax.swing.*;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.sql.ResultSet;

public class StudentForm {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Form");

        frame.setSize(750, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 28);
        Font normalFont = new Font("Arial", Font.PLAIN, 18);

        // =========================
        // TITLE
        // =========================

        JLabel titleLabel = new JLabel("Student Management");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(230, 30, 350, 40);

        // =========================
        // NAME
        // =========================

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(normalFont);
        nameLabel.setBounds(100, 100, 120, 40);

        JTextField nameField = new JTextField();
        nameField.setFont(normalFont);
        nameField.setBounds(250, 100, 300, 40);

        // =========================
        // STUDENT ID
        // =========================

        JLabel idLabel = new JLabel("Student ID:");
        idLabel.setFont(normalFont);
        idLabel.setBounds(100, 160, 120, 40);

        JTextField idField = new JTextField();
        idField.setFont(normalFont);
        idField.setBounds(250, 160, 300, 40);

        // =========================
        // COURSE
        // =========================

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setFont(normalFont);
        courseLabel.setBounds(100, 220, 120, 40);

        JTextField courseField = new JTextField();
        courseField.setFont(normalFont);
        courseField.setBounds(250, 220, 300, 40);

        // =========================
        // BUTTONS
        // =========================

        JButton addButton = new JButton("Add Student");
        addButton.setFont(normalFont);
        addButton.setBounds(150, 290, 180, 45);

        JButton updateButton = new JButton("Update Student");
        updateButton.setFont(normalFont);
        updateButton.setBounds(360, 290, 180, 45);

        JButton deleteButton = new JButton("Delete Student");
        deleteButton.setFont(normalFont);
        deleteButton.setBounds(255, 350, 180, 45);

        // =========================
        // SEARCH
        // =========================

        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(normalFont);
        searchLabel.setBounds(100, 410, 100, 40);

        JTextField searchField = new JTextField();
        searchField.setFont(normalFont);
        searchField.setBounds(200, 410, 300, 40);

        // =========================
        // TABLE MODEL
        // =========================

        String[] columns = {
                "ID",
                "Name",
                "Student ID",
                "Course"
        };

        DefaultTableModel tableModel =
                new DefaultTableModel(columns, 0);

        JTable studentTable =
                new JTable(tableModel);

        studentTable.setFont(normalFont);
        studentTable.setRowHeight(30);

        studentTable
                .getTableHeader()
                .setFont(normalFont);

        // =========================
        // TABLE SORTER
        // =========================

        TableRowSorter<DefaultTableModel> sorter =
                new TableRowSorter<>(tableModel);

        studentTable.setRowSorter(sorter);

        JScrollPane scrollPane =
                new JScrollPane(studentTable);

        scrollPane.setBounds(
                50,
                480,
                650,
                220
        );

        // =========================
        // ADD COMPONENTS
        // =========================

        panel.add(titleLabel);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(idLabel);
        panel.add(idField);

        panel.add(courseLabel);
        panel.add(courseField);

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        panel.add(searchLabel);
        panel.add(searchField);

        panel.add(scrollPane);

        frame.add(panel);

        // =========================
        // LOAD STUDENTS
        // =========================

        loadStudents(tableModel);

        // =========================
        // ADD STUDENT
        // =========================

        addButton.addActionListener(e -> {

            String name =
                    nameField.getText();

            String studentId =
                    idField.getText();

            String course =
                    courseField.getText();

            if (name.isEmpty()
                    || studentId.isEmpty()
                    || course.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please fill all fields"
                );

                return;
            }

            boolean success =
                    StudentDAO.addStudent(
                            name,
                            studentId,
                            course
                    );

            if (success) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Student added successfully"
                );

                nameField.setText("");
                idField.setText("");
                courseField.setText("");

                loadStudents(tableModel);

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Failed to add student"
                );
            }
        });

        // =========================
        // SELECT TABLE ROW
        // =========================

        studentTable
                .getSelectionModel()
                .addListSelectionListener(e -> {

                    int selectedRow =
                            studentTable.getSelectedRow();

                    if (selectedRow != -1) {

                        int modelRow =
                                studentTable
                                        .convertRowIndexToModel(
                                                selectedRow
                                        );

                        nameField.setText(
                                tableModel
                                        .getValueAt(
                                                modelRow,
                                                1
                                        )
                                        .toString()
                        );

                        idField.setText(
                                tableModel
                                        .getValueAt(
                                                modelRow,
                                                2
                                        )
                                        .toString()
                        );

                        courseField.setText(
                                tableModel
                                        .getValueAt(
                                                modelRow,
                                                3
                                        )
                                        .toString()
                        );
                    }
                });

        // =========================
        // UPDATE STUDENT
        // =========================

        updateButton.addActionListener(e -> {

            int selectedRow =
                    studentTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a student to update"
                );

                return;
            }

            int modelRow =
                    studentTable
                            .convertRowIndexToModel(
                                    selectedRow
                            );

            int id =
                    Integer.parseInt(
                            tableModel
                                    .getValueAt(
                                            modelRow,
                                            0
                                    )
                                    .toString()
                    );

            String name =
                    nameField.getText();

            String studentId =
                    idField.getText();

            String course =
                    courseField.getText();

            if (name.isEmpty()
                    || studentId.isEmpty()
                    || course.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please fill all fields"
                );

                return;
            }

            boolean success =
                    StudentDAO.updateStudent(
                            id,
                            name,
                            studentId,
                            course
                    );

            if (success) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Student updated successfully"
                );

                nameField.setText("");
                idField.setText("");
                courseField.setText("");

                studentTable.clearSelection();

                loadStudents(tableModel);

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Failed to update student"
                );
            }
        });

        // =========================
        // DELETE STUDENT
        // =========================

        deleteButton.addActionListener(e -> {

            int selectedRow =
                    studentTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a student to delete"
                );

                return;
            }

            int modelRow =
                    studentTable
                            .convertRowIndexToModel(
                                    selectedRow
                            );

            int id =
                    Integer.parseInt(
                            tableModel
                                    .getValueAt(
                                            modelRow,
                                            0
                                    )
                                    .toString()
                    );

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to delete this student?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice == JOptionPane.YES_OPTION) {

                boolean success =
                        StudentDAO.deleteStudent(id);

                if (success) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Student deleted successfully"
                    );

                    nameField.setText("");
                    idField.setText("");
                    courseField.setText("");

                    studentTable.clearSelection();

                    loadStudents(tableModel);

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Failed to delete student"
                    );
                }
            }
        });

        // =========================
        // SEARCH STUDENT
        // =========================

        searchField
                .getDocument()
                .addDocumentListener(
                        new DocumentListener() {

                            @Override
                            public void insertUpdate(
                                    DocumentEvent e
                            ) {
                                search();
                            }

                            @Override
                            public void removeUpdate(
                                    DocumentEvent e
                            ) {
                                search();
                            }

                            @Override
                            public void changedUpdate(
                                    DocumentEvent e
                            ) {
                                search();
                            }

                            private void search() {

                                String text =
                                        searchField
                                                .getText()
                                                .trim();

                                if (text.isEmpty()) {

                                    sorter.setRowFilter(null);

                                } else {

                                    sorter.setRowFilter(
                                            RowFilter.regexFilter(
                                                    "(?i)" + text
                                            )
                                    );
                                }
                            }
                        }
                );

        frame.setVisible(true);
    }

    // =========================
    // LOAD STUDENTS
    // =========================

    public static void loadStudents(
            DefaultTableModel tableModel
    ) {

        tableModel.setRowCount(0);

        try {

            ResultSet resultSet =
                    StudentDAO.getAllStudents();

            while (resultSet != null
                    && resultSet.next()) {

                Object[] row = {
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("student_id"),
                        resultSet.getString("course")
                };

                tableModel.addRow(row);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}