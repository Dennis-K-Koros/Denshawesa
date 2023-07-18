package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserProfile{

    private Connection connection;
    private User currentUser;

    private JFrame frame;
    private JLabel titleLabel;
    private JLabel fullNameLabel;
    private JLabel phoneNumberLabel;
    private JLabel emailLabel;
    private JLabel addressLabel;
    private JLabel dobLabel;
    private JLabel nationalIdLabel;
    private JButton editButton;
    private JButton deleteButton;
    private JButton BackButton;
    public UserProfile(Connection connection,  int userId) {

        User user = getUserFromDatabase(connection, userId);

        this.connection = connection;
        this.currentUser = user;

        frame = new JFrame("User Profile");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 370);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        titleLabel = new JLabel("User Profile");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        fullNameLabel = new JLabel("Full Name: " + currentUser.getFullName());
        phoneNumberLabel = new JLabel("Phone Number: " + currentUser.getPhoneNumber());
        emailLabel = new JLabel("Email: " + currentUser.getEmailAddress());
        addressLabel = new JLabel("Address: " + currentUser.getAddress());
        dobLabel = new JLabel("Date of Birth: " + currentUser.getDob());
        nationalIdLabel = new JLabel("National ID: " + currentUser.getNatId());
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        BackButton = new JButton("Back");

        titleLabel.setBounds(200, 20, 200, 30);
        fullNameLabel.setBounds(50, 70, 400, 20);
        phoneNumberLabel.setBounds(50, 100, 400, 20);
        emailLabel.setBounds(50, 130, 400, 20);
        addressLabel.setBounds(50, 160, 400, 20);
        dobLabel.setBounds(50, 190, 400, 20);
        nationalIdLabel.setBounds(50, 220, 400, 20);
        editButton.setBounds(70, 260, 80, 30);
        deleteButton.setBounds(200, 260, 90, 30);
        BackButton.setBounds(350, 260, 90, 30);

        frame.add(titleLabel);
        frame.add(fullNameLabel);
        frame.add(phoneNumberLabel);
        frame.add(emailLabel);
        frame.add(addressLabel);
        frame.add(dobLabel);
        frame.add(nationalIdLabel);
        frame.add(editButton);
        frame.add(deleteButton);
        frame.add(BackButton);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editUser();
            }
        });


        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete your account?",
                        "Delete Account", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    deleteUser();
                }
            }
        });

        frame.setVisible(true);
    }

    private void editUser() {
        JPanel editPanel = new JPanel(new GridLayout(7, 2));
        editPanel.add(new JLabel("Full Name:"));
        JTextField fullNameTextField = new JTextField(currentUser.getFullName());
        editPanel.add(fullNameTextField);
        editPanel.add(new JLabel("Phone Number:"));
        JTextField phoneNumberTextField = new JTextField(currentUser.getPhoneNumber());
        editPanel.add(phoneNumberTextField);
        editPanel.add(new JLabel("Email:"));
        JTextField emailTextField = new JTextField(currentUser.getEmailAddress());
        editPanel.add(emailTextField);
        editPanel.add(new JLabel("Address:"));
        JTextField addressTextField = new JTextField(currentUser.getAddress());
        editPanel.add(addressTextField);
        editPanel.add(new JLabel("Date of Birth (yyyy-mm-dd):"));
        JTextField dobTextField = new JTextField(currentUser.getDob().toString());
        editPanel.add(dobTextField);
        editPanel.add(new JLabel("National ID:"));
        JTextField nationalIdTextField = new JTextField(currentUser.getNatId());
        editPanel.add(nationalIdTextField);
        editPanel.add(new JLabel("New Password:"));
        JPasswordField passwordField = new JPasswordField();

        editPanel.add(passwordField);

        int option = JOptionPane.showConfirmDialog(frame, editPanel, "Edit User Information", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String fullName = fullNameTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            String email = emailTextField.getText();
            String address = addressTextField.getText();
            Date dob = Date.valueOf(dobTextField.getText());
            String nationalId = nationalIdTextField.getText();
            String newPassword = new String(passwordField.getPassword());

            try {
                PreparedStatement statement = connection.prepareStatement("UPDATE users SET FullName = ?, PhoneNumber = ?, Email = ?, Address = ?, DOB = ?, NationalId = ?, password = ? WHERE userId = ?");
                statement.setString(1, fullName);
                statement.setString(2, phoneNumber);
                statement.setString(3, email);
                statement.setString(4, address);
                statement.setDate(5, dob);
                statement.setString(6, nationalId);
                statement.setString(7, newPassword);
                statement.setInt(8, currentUser.getUserId());
                statement.executeUpdate();
                statement.close();

                currentUser.setFullName(fullName);
                currentUser.setPhoneNumber(phoneNumber);
                currentUser.setEmailAddress(email);
                currentUser.setAddress(address);
                currentUser.setDob(String.valueOf(dob));
                currentUser.setNatId(nationalId);
                currentUser.setPassword(newPassword);

                fullNameLabel.setText("Full Name: " + fullName);
                phoneNumberLabel.setText("Phone Number: " + phoneNumber);
                emailLabel.setText("Email: " + email);
                addressLabel.setText("Address: " + address);
                dobLabel.setText("Date Of Birth: " + dob.toString());
                nationalIdLabel.setText("National ID: " + nationalId);

                JOptionPane.showMessageDialog(frame, "User information updated successfully.");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error updating user information.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    private void deleteUser() {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE userId = ?");
            statement.setInt(1, currentUser.getUserId());
            statement.executeUpdate();
            statement.close();

            JOptionPane.showMessageDialog(frame, "Account deleted successfully.");
            frame.dispose();
            // Add code to handle further actions after account deletion, e.g., return to login screen or exit the app.
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error deleting account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/trial";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);

            int userId = Integer.parseInt(args[0]); // Retrieve the userId from command line arguments or any other method

            // Create a user object based on the user details retrieved from the database
            User user = getUserFromDatabase(connection, userId);

            /*User user = getUserFromDatabase(connection, 1); */// Replace with actual user ID(enable this code and disable line 192 and 195 to test the code)

            if (user != null) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new UserProfile(connection, user.getUserId());
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "User authentication failed.", "Access Denied", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    private static User getUserFromDatabase(Connection connection, int userId) {
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE userId = ?");
            statement.setString(1, String.valueOf(userId));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String fullName = resultSet.getString("FullName");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String email = resultSet.getString("Email");
                String address = resultSet.getString("Address");
                Date dob = resultSet.getDate("DOB");
                String nationalId = resultSet.getString("NationalId");
                String role = resultSet.getString("Role");
                String password = resultSet.getString("password");

                user = new User(userId, fullName, phoneNumber, email, address, dob, nationalId, role, password);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }
}
