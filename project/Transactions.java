package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions {

    JFrame frame;
    JPanel panel;
    JButton backBtn;
    JLabel trLabel;
    JScrollPane scrollPane;
    JTextArea transactionTextArea;

    Transactions(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLayout(null);

        trLabel = new JLabel("Transaction History");
        trLabel.setFont(new Font("Arial", Font.BOLD, 20));
        trLabel.setBounds(20,25,420,35);

        transactionTextArea = new JTextArea();
        transactionTextArea.setEditable(false);

        scrollPane = new JScrollPane(transactionTextArea);

        panel = new JPanel();
        panel.setBounds(20,60,390,260);
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane,BorderLayout.CENTER);

        backBtn = new JButton("Back");
        backBtn.setFocusable(false);
        backBtn.setBounds(175,350,80,25);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                MainMenu menu = new MainMenu();
            }
        });

        // Fetch and display transaction history for the logged-in user
        // Code to fetch and display transaction history goes here Example: transactionTextArea.setText("Transaction history goes here");
        //Shaddy mambo yako hii

        frame.add(trLabel);
        frame.add(panel);
        frame.add(backBtn);
        frame.setVisible(true);

    }

}
