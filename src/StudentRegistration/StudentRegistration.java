package StudentRegistration;

import javax.swing.*;
import java.awt.*;

public class StudentRegistration {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration");

        frame.setSize(750, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial",Font.PLAIN,25);

        JLabel titleLabel = new JLabel("Student Registration");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(220, 40, 350, 40);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(normalFont);
        nameLabel.setBounds(140, 130, 150, 40);

        JTextField nameField = new JTextField();
        nameField.setFont(normalFont);
        nameField.setBounds(300, 130, 280, 40);

        JLabel stuID = new JLabel("Student ID:");
        stuID.setFont(normalFont);
        stuID.setBounds(140, 180, 150, 40);

        JTextField stuIDField = new JTextField();
        stuIDField.setFont(normalFont);
        stuIDField.setBounds(300, 180, 280, 40);

        JLabel Email  = new JLabel("Email:");
        Email.setFont(normalFont);
        Email.setBounds(140, 230, 150, 40);

        JTextField EmailField = new JTextField();
        EmailField.setFont(normalFont);
        EmailField.setBounds(300, 230, 280, 40);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(normalFont);
        gender.setBounds(140, 270, 150, 40);

        JRadioButton maleButton = new JRadioButton("Male");
        maleButton.setFont(normalFont);
        maleButton.setBounds(300, 270, 100, 40);

        JRadioButton femaleButton = new JRadioButton("Female");
        femaleButton.setFont(normalFont);
        femaleButton.setBounds(410, 270, 120, 40);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setFont(normalFont);
        departmentLabel.setBounds(140, 320, 150, 40);

        String[] department ={
                "Select Department",
                "ICT",
                "Engineering Technology",
                "BioSystem Technology",
        };

        JComboBox<String> departmentBox = new JComboBox<>(department);
        departmentBox.setFont(normalFont);
        departmentBox.setBounds(300, 320, 300, 40);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JButton registerButton = new JButton("Register");
        registerButton.setFont(normalFont);
        registerButton.setBounds(230, 400, 140, 45);

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(normalFont);
        clearButton.setBounds(390, 400, 120, 45);

        JLabel messageLabel = new JLabel("");
        messageLabel.setFont(normalFont);
        messageLabel.setBounds(180, 480, 400, 40);


        panel.add(titleLabel);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(stuID);
        panel.add(stuIDField);
        panel.add(Email);
        panel.add(EmailField);
        panel.add(gender);
        panel.add(maleButton);
        panel.add(femaleButton);
        panel.add(departmentLabel);
        panel.add(departmentBox);
        panel.add(registerButton);
        panel.add(clearButton);
        panel.add(messageLabel);

        frame.add(panel);

        registerButton.addActionListener(e -> {

            String name = nameField.getText();
            String studentID = stuIDField.getText();
            String email = EmailField.getText();

            String selectedGender = "";

            if (maleButton.isSelected()) {
                selectedGender = "Male";
            } else if (femaleButton.isSelected()) {
                selectedGender = "Female";
            }

            String dep = departmentBox.getSelectedItem().toString();

            if (name.isEmpty() ||
                    studentID.isEmpty() ||
                    email.isEmpty() ||
                    selectedGender.isEmpty() ||
                    department.equals("Select Department")) {

                messageLabel.setText("Please fill all fields");

            } else {

                messageLabel.setText("Student Registered Successfully");
            }
        });

        clearButton.addActionListener(e -> {

            nameField.setText("");
            stuIDField.setText("");
            EmailField.setText("");

            genderGroup.clearSelection();

            departmentBox.setSelectedIndex(0);

            messageLabel.setText("");
        });

        frame.setVisible(true);
    }
}