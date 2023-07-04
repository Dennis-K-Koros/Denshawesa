package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {
    JFrame frame;
    JTextField usernameField;
    JPasswordField passwordField;
    JLabel titleLabel,usernameLabel,passwordLabel;
    JPanel bottomPanel;
    JButton btnLog,btnSignUp,btnExit;
    Font myFont = new Font("Arial",Font.PLAIN,16);

    public SignUp() {
        frame = new JFrame("DenShaWesa Online Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLayout(null);


        titleLabel = new JLabel("Denshawesa OnlineShop");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setBounds(25,15,450,75);


        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50,100,150,25);
        usernameLabel.setFont(myFont);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50,150,150,25);
        passwordLabel.setFont(myFont);

        usernameField = new JTextField();
        usernameField.setBounds(200,100,150,25);
        usernameField.setFont(myFont);

        passwordField = new JPasswordField();
        passwordField.setBounds(200,150,150,25);
        passwordField.setFont(myFont);

        btnLog = new JButton("SignIn");
        btnLog.setFocusable(false);
        btnLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainMenu menu = new MainMenu();
            }
        });

        btnSignUp = new JButton("SignUp");
        btnSignUp.setFocusable(false);
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 frame.dispose();
            }
        });

        bottomPanel = new JPanel();
        bottomPanel.setBounds(50,250,300,25);
        bottomPanel.setLayout(new GridLayout(1,3,10,10));
        bottomPanel.add(btnLog);
        bottomPanel.add(btnSignUp);
        bottomPanel.add(btnExit);

        frame.add(titleLabel);
        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(bottomPanel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUp();
            }
        });
    }
}

