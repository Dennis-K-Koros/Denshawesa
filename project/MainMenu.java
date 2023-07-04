package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    JFrame frame;
    JPanel panel;
    JButton poBtn,orBtn,favBtn,traBtn;

    MainMenu(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setLayout(null);

        poBtn = new JButton("Pre-order");
        poBtn.setFocusable(false);
        poBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle pre-order functionality goes here,anyone in the group can do it
            }
        });

        orBtn = new JButton("Order");
        orBtn.setFocusable(false);
        orBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle order functionality goes here,anyone in the group can do it
            }
        });

        favBtn = new JButton("Favourites");
        favBtn.setFocusable(false);
        favBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle favourites functionality goes here,anyone in the group can do it
            }
        });

        traBtn = new JButton("Transactions");
        traBtn.setFocusable(false);
        traBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Transactions trans = new Transactions();
                // Code to handle transaction functionality goes here,anyone in the group can do it
            }
        });

        panel = new JPanel();
        panel.setBounds(10,20,430,50);
        panel.setLayout(new FlowLayout());
        panel.add(poBtn);
        panel.add(orBtn);
        panel.add(favBtn);
        panel.add(traBtn);

        frame.add(panel);
        frame.setVisible(true);

    }
}
