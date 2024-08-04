package BankingApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Deposit extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCardNumber;
    private JTextField txtPin;
    private JTextField txtAmount;
    private JLabel lblNewBalance;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Deposit frame = new Deposit();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Deposit() {
        setTitle("Deposit Money");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Pictures\\deposit.PNG"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 797, 522);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setForeground(Color.WHITE);
        lblCardNumber.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblCardNumber.setBounds(100, 100, 150, 25);
        contentPane.add(lblCardNumber);

        txtCardNumber = new JTextField();
        txtCardNumber.setBounds(250, 100, 200, 25);
        contentPane.add(txtCardNumber);
        txtCardNumber.setColumns(10);

        JLabel lblPin = new JLabel("PIN:");
        lblPin.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPin.setForeground(Color.WHITE);
        lblPin.setBounds(100, 150, 150, 25);
        contentPane.add(lblPin);

        txtPin = new JTextField();
        txtPin.setBounds(250, 150, 200, 25);
        contentPane.add(txtPin);
        txtPin.setColumns(10);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblAmount.setForeground(Color.WHITE);
        lblAmount.setBounds(100, 200, 150, 25);
        contentPane.add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setBounds(250, 200, 200, 25);
        contentPane.add(txtAmount);
        txtAmount.setColumns(10);

        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                depositMoney();
                txtAmount.setText("");
                txtPin.setText("");
                txtCardNumber.setText("");
                dispose();
                Menu menu=new Menu();
                menu.setVisible(true);
            }
        });
        btnDeposit.setBounds(350, 264, 100, 25);
        contentPane.add(btnDeposit);

        lblNewBalance = new JLabel("");
        lblNewBalance.setBounds(100, 300, 350, 25);
        contentPane.add(lblNewBalance);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\deposit1.jpg"));
        lblNewLabel.setBounds(0, 0, 783, 485);
        contentPane.add(lblNewLabel);
    }

    private void depositMoney() {
        String cardNumber = txtCardNumber.getText();
        String pin = txtPin.getText();
        String amountStr = txtAmount.getText();
        double amount;

        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.", "Invalid Amount", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
        	String DB_URL = "jdbc:mysql://localhost:3306/BankManagementSystem";
            String DB_USER = "root";
            String DB_PASSWORD = "Ak,3f.p8@&!wE";
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Check if the card number and pin are correct
            String query = "SELECT Balance FROM customers WHERE card_no = ? AND pin = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, cardNumber);
            pst.setString(2, pin);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("Balance");

                // Update the balance
                double newBalance = currentBalance + amount;
                query = "UPDATE customers SET Balance = ? WHERE card_no = ? AND pin = ?";
                pst = con.prepareStatement(query);
                pst.setDouble(1, newBalance);
                pst.setString(2, cardNumber);
                pst.setString(3, pin);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Deposit successful. New balance: $" + newBalance, "Success", JOptionPane.INFORMATION_MESSAGE);
               
            } else {
                JOptionPane.showMessageDialog(this, "Invalid card number or PIN.", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while processing the transaction.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
