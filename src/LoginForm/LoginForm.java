package LoginForm;
import javax.swing.*;
import java.awt.*;

public class LoginForm {
    public static void main(String[] args) {
         JFrame frame = new JFrame("Login Form");

         frame.setSize(700,750);
         frame.setLocationRelativeTo(null);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         JPanel panel = new JPanel();
         panel.setLayout(null);

         Font titleFont = new Font("Arial", Font.BOLD, 30);
         Font font1 = new Font("Arial",Font.PLAIN,25);

         JLabel titleLabel = new JLabel("Login Form");
         titleLabel.setFont(titleFont);
         titleLabel.setBounds(240, 50, 250, 40);

         JLabel usernameLabel = new JLabel("Username: ");
         usernameLabel.setFont(font1);
         usernameLabel.setBounds(140, 140, 250, 40);

         JTextField usernamefield = new JTextField();
         usernamefield.setFont(font1);
         usernamefield.setBounds(340, 140, 250, 40);

         JLabel passwordLabel = new JLabel("Password: ");
         passwordLabel.setFont(font1);
         passwordLabel.setBounds(140, 240, 250, 40);

         JPasswordField passwordField = new JPasswordField();
         passwordField.setFont(font1);
         passwordField.setBounds(340, 240, 250, 40);

         JButton loginButton = new JButton("Login");
         loginButton.setFont(font1);
         loginButton.setBounds(340, 340, 250, 40);

         JButton clearButton = new JButton("Clear");
         clearButton.setFont(font1);
         clearButton.setBounds(340, 440, 250, 40);

         JLabel message = new JLabel("");
         message.setFont(font1);
         message.setBounds(140, 540, 550, 40);

         panel.add(titleLabel);
         panel.add(usernameLabel);
         panel.add(usernamefield);
         panel.add(passwordLabel);
         panel.add(passwordField);
         panel.add(loginButton);
         panel.add(clearButton);
         panel.add(message);
         frame.add(panel);

         loginButton.addActionListener(e->{
              String username = usernamefield.getText();
              String password = new String(passwordField.getPassword());

              if(username.equals("admin") && password.equals("1234")){
                   message.setText("---Login Successful---");
              }else {
                   message.setText("---Invalid Username or Password---");
              }
         });


         clearButton.addActionListener(e ->{
              usernamefield.setText("");
              passwordField.setText("");
              message.setText("");

         });


         frame.setVisible(true);
    }
}
