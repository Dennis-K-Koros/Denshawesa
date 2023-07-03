package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {
    private final JFrame frame;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private JTextArea transactionTextArea;

    public SignUp() {
        frame = new JFrame("DanShaWesa Online Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setPreferredSize(new Dimension(800, 100));

        JLabel titleLabel = new JLabel("Danshawesa OnlineShop");
        titleLabel.setFont(new Font("Italic", Font.BOLD, 50));
        topPanel.add(titleLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(2, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel usernameLabel = new JLabel("Username:");
        centerPanel.add(usernameLabel);

        usernameField = new JTextField();
        centerPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        centerPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        centerPanel.add(passwordField);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(800, 200));
        bottomPanel.setLayout(new FlowLayout());

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();


                showMainMenu();
            }
        });
        bottomPanel.add(loginButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void showMainMenu() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());

        JButton preOrderButton = new JButton("Pre-Order");
        preOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle pre-order functionality goes here,anyone in the group can do it
            }
        });
        menuPanel.add(preOrderButton);

        JButton orderButton = new JButton("Order");
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle order functionality goes here,anyone who wants to do it
            }
        });
        menuPanel.add(orderButton);

        JButton favoriteButton = new JButton("Favorites");
        favoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to handle favorites functionality goes here
            }
        });
        menuPanel.add(favoriteButton);

        JButton transactionButton = new JButton("Transactions");
        transactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTransactions();
            }
        });
        menuPanel.add(transactionButton);

        frame.add(menuPanel);
        frame.revalidate();
        frame.repaint();
    }

    private void showTransactions() {
        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        JPanel transactionPanel = new JPanel();
        transactionPanel.setLayout(new BorderLayout());

        JLabel transactionLabel = new JLabel("Transaction History");
        transactionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        transactionPanel.add(transactionLabel, BorderLayout.NORTH);

        transactionTextArea = new JTextArea();
        transactionTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionTextArea);
        transactionPanel.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMainMenu();
            }
        });
        transactionPanel.add(backButton, BorderLayout.SOUTH);

        // Fetch and display transaction history for the logged-in user
        // Code to fetch and display transaction history goes here Example: transactionTextArea.setText("Transaction history goes here");
        //Shaddy mambo yako hii
        frame.add(transactionPanel);
        frame.revalidate();
        frame.repaint();
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

