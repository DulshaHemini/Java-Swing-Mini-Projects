package ContactList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ContactList {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Contact List");

        frame.setSize(850, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font titleFont = new Font("Arial", Font.BOLD, 30);
        Font normalFont = new Font("Arial", Font.PLAIN, 18);

        // Title
        JLabel titleLabel = new JLabel("Contact List");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(320, 30, 250, 40);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(normalFont);
        nameLabel.setBounds(120, 100, 120, 40);

        JTextField nameField = new JTextField();
        nameField.setFont(normalFont);
        nameField.setBounds(250, 100, 250, 40);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(normalFont);
        phoneLabel.setBounds(120, 160, 120, 40);

        JTextField phoneField = new JTextField();
        phoneField.setFont(normalFont);
        phoneField.setBounds(250, 160, 250, 40);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(normalFont);
        emailLabel.setBounds(120, 220, 120, 40);

        JTextField emailField = new JTextField();
        emailField.setFont(normalFont);
        emailField.setBounds(250, 220, 250, 40);

        // Buttons
        JButton addButton = new JButton("Add Contact");
        addButton.setFont(normalFont);
        addButton.setBounds(530, 120, 160, 45);

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(normalFont);
        clearButton.setBounds(530, 180, 160, 45);

        // Table headings
        String[] columns = {
                "Name",
                "Phone",
                "Email"
        };

        // Table model
        DefaultTableModel tableModel =
                new DefaultTableModel(columns, 0);

        // JTable
        JTable contactTable = new JTable(tableModel);
        contactTable.setFont(normalFont);
        contactTable.setRowHeight(30);

        // Table header font
        contactTable.getTableHeader().setFont(normalFont);

        // Scroll pane
        JScrollPane scrollPane =
                new JScrollPane(contactTable);

        scrollPane.setBounds(100, 310, 650, 230);

        // Remove button
        JButton removeButton =
                new JButton("Remove Selected");

        removeButton.setFont(normalFont);
        removeButton.setBounds(300, 570, 220, 45);

        // Message
        JLabel messageLabel = new JLabel("");
        messageLabel.setFont(normalFont);
        messageLabel.setBounds(250, 625, 400, 30);

        // Add components
        panel.add(titleLabel);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(phoneLabel);
        panel.add(phoneField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(addButton);
        panel.add(clearButton);

        panel.add(scrollPane);

        panel.add(removeButton);

        panel.add(messageLabel);

        frame.add(panel);

        // Add Contact
        addButton.addActionListener(e -> {

            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (    name.isEmpty() ||
                    phone.isEmpty() ||
                    email.isEmpty()) {

                messageLabel.setText(
                        "Please fill all fields"
                );

            } else {

                Object[] row = {
                        name,
                        phone,
                        email
                };

                tableModel.addRow(row);

                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");

                messageLabel.setText(
                        "Contact added successfully"
                );
            }
        });

        // Clear fields
        clearButton.addActionListener(e -> {

            nameField.setText("");
            phoneField.setText("");
            emailField.setText("");

            messageLabel.setText("");
        });

        // Remove selected row
        removeButton.addActionListener(e -> {

            int selectedRow =
                    contactTable.getSelectedRow();

            if (selectedRow != -1) {

                tableModel.removeRow(selectedRow);

                messageLabel.setText(
                        "Contact removed"
                );

            } else {

                messageLabel.setText(
                        "Please select a contact"
                );
            }
        });

        frame.setVisible(true);
    }
}