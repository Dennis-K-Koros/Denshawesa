package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1, btn2;
    JPasswordField p1;

    public Login() {

        setSize(600, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login Page");


        l1 = new JLabel("Login Page");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2 = new JLabel("Username:");
        l3 = new JLabel("Password:");
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton("Login");
        btn2 = new JButton("Register");

        //deciding location for the components since we have no layout
        l1.setBounds(300, 110, 400, 30);
        l2.setBounds(80, 160, 200, 30);
        l3.setBounds(80, 210, 200, 30);
        tf1.setBounds(250, 160, 200, 30);
        p1.setBounds(250, 210, 200, 30);
        btn1.setBounds(250, 270, 80, 30);
        btn2.setBounds(350, 270, 90, 30);

        //add to container
        add(l1);
        add(l2);
        add(l3);
        add(tf1);
        add(p1);
        add(btn1);
        add(btn2);

        //actions
        btn2.addActionListener(this);
        btn1.addActionListener(this);

    }

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource() == btn2) {
            System.exit(0);
        }
        if (e.getSource() == btn1) {
            System.exit(0);
        }


    }
}

