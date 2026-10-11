package CardLayoutDemo;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class CardLayoutDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("CardLayout Demo");

        frame.setSize(700, 680);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel mainPanel = new JPanel(cardLayout);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 18);

        // =========================
        // LOGIN PANEL
        // =========================

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        JLabel loginTitle = new JLabel("Login");
        loginTitle.setFont(titleFont);
        loginTitle.setBounds(300, 80, 150, 40);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(normalFont);
        usernameLabel.setBounds(170, 180, 130, 40);

        JTextField usernameField = new JTextField();
        usernameField.setFont(normalFont);
        usernameField.setBounds(320, 180, 220, 40);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(normalFont);
        passwordLabel.setBounds(170, 250, 130, 40);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(normalFont);
        passwordField.setBounds(320, 250, 220, 40);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(normalFont);
        loginButton.setBounds(275, 340, 150, 45);

        JLabel messageLabel = new JLabel("");
        messageLabel.setFont(normalFont);
        messageLabel.setBounds(200, 410, 400, 40);

        loginPanel.add(loginTitle);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(messageLabel);


        // =========================
        // DASHBOARD PANEL
        // =========================

        JPanel dashboardPanel = new JPanel();
        dashboardPanel.setLayout(null);

        JLabel dashboardTitle = new JLabel("Dashboard");
        dashboardTitle.setFont(titleFont);
        dashboardTitle.setBounds(270, 70, 250, 40);

        JLabel welcomeLabel = new JLabel("Welcome, Admin");
        welcomeLabel.setFont(normalFont);
        welcomeLabel.setBounds(270, 130, 250, 40);

        JButton profileButton = new JButton("Profile");
        profileButton.setFont(normalFont);
        profileButton.setBounds(275, 200, 150, 45);

        JButton studentsButton = new JButton("Students");
        studentsButton.setFont(normalFont);
        studentsButton.setBounds(275, 270, 150, 45);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(normalFont);
        logoutButton.setBounds(275, 340, 150, 45);

        dashboardPanel.add(dashboardTitle);
        dashboardPanel.add(welcomeLabel);
        dashboardPanel.add(profileButton);
        dashboardPanel.add(studentsButton);
        dashboardPanel.add(logoutButton);


        // =========================
        // PROFILE PANEL
        // =========================

        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(null);

        JLabel profileTitle = new JLabel("Profile");
        profileTitle.setFont(titleFont);
        profileTitle.setBounds(300, 80, 200, 40);

        JLabel nameLabel = new JLabel("Name: Admin User");
        nameLabel.setFont(normalFont);
        nameLabel.setBounds(220, 170, 300, 40);

        JLabel emailLabel = new JLabel("Email: admin@gmail.com");
        emailLabel.setFont(normalFont);
        emailLabel.setBounds(220, 230, 350, 40);

        JButton profileBackButton = new JButton("Back");
        profileBackButton.setFont(normalFont);
        profileBackButton.setBounds(275, 330, 150, 45);

        profilePanel.add(profileTitle);
        profilePanel.add(nameLabel);
        profilePanel.add(emailLabel);
        profilePanel.add(profileBackButton);


        // =========================
        // STUDENTS PANEL
        // =========================

        JPanel studentsPanel = new JPanel();
        studentsPanel.setLayout(null);

        JLabel studentsTitle = new JLabel("Students");
        studentsTitle.setFont(titleFont);
        studentsTitle.setBounds(290, 25, 200, 40);

        JLabel studentNameLabel = new JLabel("Name:");
        studentNameLabel.setFont(normalFont);
        studentNameLabel.setBounds(50, 80, 100, 35);

        JTextField studentNameField = new JTextField();
        studentNameField.setFont(normalFont);
        studentNameField.setBounds(130, 80, 180, 35);

        JLabel studentIDLabel = new JLabel("ID:");
        studentIDLabel.setFont(normalFont);
        studentIDLabel.setBounds(330, 80, 50, 35);

        JTextField studentIDField = new JTextField();
        studentIDField.setFont(normalFont);
        studentIDField.setBounds(380, 80, 180, 35);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setFont(normalFont);
        courseLabel.setBounds(50, 130, 100, 35);

        JTextField courseField = new JTextField();
        courseField.setFont(normalFont);
        courseField.setBounds(130, 130, 180, 35);

        JButton addStudentButton = new JButton("Add");
        addStudentButton.setFont(normalFont);
        addStudentButton.setBounds(330, 130, 100, 35);

        JButton updateStudentButton = new JButton("Update");
        updateStudentButton.setFont(normalFont);
        updateStudentButton.setBounds(440, 130, 100, 35);

        JButton deleteStudentButton = new JButton("Delete");
        deleteStudentButton.setFont(normalFont);
        deleteStudentButton.setBounds(550, 130, 100, 35);

        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(normalFont);
        searchLabel.setBounds(50, 180, 100, 35);

        JTextField searchField = new JTextField();
        searchField.setFont(normalFont);
        searchField.setBounds(130, 180, 250, 35);

        String[] columns = {
                "Name",
                "Student ID",
                "Course"
        };

        DefaultTableModel tableModel =
                new DefaultTableModel(columns, 0);

        JTable studentTable = new JTable(tableModel);
        studentTable.setFont(normalFont);
        studentTable.setRowHeight(30);
        studentTable.getTableHeader().setFont(normalFont);

        TableRowSorter<DefaultTableModel> sorter =
                new TableRowSorter<>(tableModel);

        studentTable.setRowSorter(sorter);

        JScrollPane scrollPane =
                new JScrollPane(studentTable);

        scrollPane.setBounds(50, 230, 600, 230);

        JButton studentsBackButton = new JButton("Back");
        studentsBackButton.setFont(normalFont);
        studentsBackButton.setBounds(275, 500, 150, 45);

        studentsPanel.add(studentsTitle);

        studentsPanel.add(studentNameLabel);
        studentsPanel.add(studentNameField);

        studentsPanel.add(studentIDLabel);
        studentsPanel.add(studentIDField);

        studentsPanel.add(courseLabel);
        studentsPanel.add(courseField);

        studentsPanel.add(addStudentButton);
        studentsPanel.add(updateStudentButton);
        studentsPanel.add(deleteStudentButton);

        studentsPanel.add(searchLabel);
        studentsPanel.add(searchField);

        studentsPanel.add(scrollPane);

        studentsPanel.add(studentsBackButton);


        // =========================
        // ADD PANELS TO CARDLAYOUT
        // =========================

        mainPanel.add(loginPanel, "Login");
        mainPanel.add(dashboardPanel, "Dashboard");
        mainPanel.add(profilePanel, "Profile");
        mainPanel.add(studentsPanel, "Students");

        frame.add(mainPanel);


        // =========================
        // LOGIN ACTION
        // =========================

        loginButton.addActionListener(e -> {

            String username = usernameField.getText();

            String password =
                    new String(passwordField.getPassword());

            if (username.equals("admin")
                    && password.equals("1234")) {

                messageLabel.setText("");

                cardLayout.show(
                        mainPanel,
                        "Dashboard"
                );

            } else {

                messageLabel.setText(
                        "Invalid Username or Password"
                );
            }
        });


        // =========================
        // PROFILE BUTTON
        // =========================

        profileButton.addActionListener(e -> {

            cardLayout.show(
                    mainPanel,
                    "Profile"
            );
        });


        // =========================
        // PROFILE BACK
        // =========================

        profileBackButton.addActionListener(e -> {

            cardLayout.show(
                    mainPanel,
                    "Dashboard"
            );
        });


        // =========================
        // STUDENTS BUTTON
        // =========================

        studentsButton.addActionListener(e -> {

            cardLayout.show(
                    mainPanel,
                    "Students"
            );
        });


        // =========================
        // STUDENTS BACK
        // =========================

        studentsBackButton.addActionListener(e -> {

            studentNameField.setText("");
            studentIDField.setText("");
            courseField.setText("");
            searchField.setText("");

            studentTable.clearSelection();

            cardLayout.show(
                    mainPanel,
                    "Dashboard"
            );
        });


        // =========================
        // ADD STUDENT
        // =========================

        addStudentButton.addActionListener(e -> {

            String name = studentNameField.getText();
            String studentID = studentIDField.getText();
            String course = courseField.getText();

            if (name.isEmpty()
                    || studentID.isEmpty()
                    || course.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please fill all fields"
                );

            } else {

                Object[] row = {
                        name,
                        studentID,
                        course
                };

                tableModel.addRow(row);

                studentNameField.setText("");
                studentIDField.setText("");
                courseField.setText("");
            }
        });


        // =========================
        // SELECT STUDENT
        // =========================

        studentTable
                .getSelectionModel()
                .addListSelectionListener(e -> {

                    int selectedRow =
                            studentTable.getSelectedRow();

                    if (selectedRow != -1) {

                        int modelRow =
                                studentTable.convertRowIndexToModel(
                                        selectedRow
                                );

                        studentNameField.setText(
                                tableModel
                                        .getValueAt(modelRow, 0)
                                        .toString()
                        );

                        studentIDField.setText(
                                tableModel
                                        .getValueAt(modelRow, 1)
                                        .toString()
                        );

                        courseField.setText(
                                tableModel
                                        .getValueAt(modelRow, 2)
                                        .toString()
                        );
                    }
                });


        // =========================
        // UPDATE STUDENT
        // =========================

        updateStudentButton.addActionListener(e -> {

            int selectedRow =
                    studentTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a student to update"
                );

            } else {

                String name =
                        studentNameField.getText();

                String studentID =
                        studentIDField.getText();

                String course =
                        courseField.getText();

                if (name.isEmpty()
                        || studentID.isEmpty()
                        || course.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please fill all fields"
                    );

                } else {

                    int modelRow =
                            studentTable.convertRowIndexToModel(
                                    selectedRow
                            );

                    tableModel.setValueAt(
                            name,
                            modelRow,
                            0
                    );

                    tableModel.setValueAt(
                            studentID,
                            modelRow,
                            1
                    );

                    tableModel.setValueAt(
                            course,
                            modelRow,
                            2
                    );

                    studentNameField.setText("");
                    studentIDField.setText("");
                    courseField.setText("");

                    studentTable.clearSelection();
                }
            }
        });


        // =========================
        // DELETE STUDENT
        // =========================

        deleteStudentButton.addActionListener(e -> {

            int selectedRow =
                    studentTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a student to delete"
                );

            } else {

                int modelRow =
                        studentTable.convertRowIndexToModel(
                                selectedRow
                        );

                tableModel.removeRow(modelRow);

                studentNameField.setText("");
                studentIDField.setText("");
                courseField.setText("");

                studentTable.clearSelection();
            }
        });


        // =========================
        // SEARCH STUDENT
        // =========================

        searchField.getDocument().addDocumentListener(
                new DocumentListener() {

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        search();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        search();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        search();
                    }

                    private void search() {

                        String text =
                                searchField.getText().trim();

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


        // =========================
        // LOGOUT
        // =========================

        logoutButton.addActionListener(e -> {

            usernameField.setText("");
            passwordField.setText("");
            messageLabel.setText("");

            cardLayout.show(
                    mainPanel,
                    "Login"
            );
        });


        frame.setVisible(true);
    }
}