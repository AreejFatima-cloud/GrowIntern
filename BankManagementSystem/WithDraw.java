package BankingApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithDraw extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCardNo;
    private JPasswordField txtPin;
    private JTextField txtAmount;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/BankManagementSystem";;
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Ak,3f.p8@&!wE";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WithDraw frame = new WithDraw();
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
    public WithDraw() {
        setTitle("WithDraw Money");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Pictures\\withdraw.PNG"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 611, 415);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCardNo = new JLabel("Account Card No:");
        lblCardNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCardNo.setBounds(70, 50, 150, 30);
        contentPane.add(lblCardNo);

        txtCardNo = new JTextField();
        txtCardNo.setBounds(246, 52, 200, 30);
        contentPane.add(txtCardNo);
        txtCardNo.setColumns(10);

        JLabel lblPin = new JLabel("PIN:");
        lblPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPin.setBounds(70, 100, 150, 30);
        contentPane.add(lblPin);

        txtPin = new JPasswordField();
        txtPin.setBounds(246, 102, 200, 30);
        contentPane.add(txtPin);

        JLabel lblAmount = new JLabel("Enter Amount:");
        lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAmount.setBounds(70, 150, 150, 30);
        contentPane.add(lblAmount);

        txtAmount = new JTextField();
        txtAmount.setBounds(246, 152, 200, 30);
        contentPane.add(txtAmount);
        txtAmount.setColumns(10);

        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnWithdraw.setBounds(346, 218, 100, 30);
        contentPane.add(btnWithdraw);

        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleWithdrawal();
                txtAmount.setText("");
                txtPin.setText("");
                txtCardNo.setText("");
                dispose();
                Menu menu=new Menu();
               menu.setVisible(true);
                
            }
        });

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\withdrawal1.jpg"));
        lblNewLabel.setBounds(0, 0, 609, 385);
        contentPane.add(lblNewLabel);
    }

    private void handleWithdrawal() {
        String cardNo = txtCardNo.getText();
        String pin = new String(txtPin.getPassword());
        String amountBalance = txtAmount.getText();

        if (cardNo.isEmpty() || pin.isEmpty() || amountBalance.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double amount = Double.parseDouble(amountBalance);

            // Database connection and query
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                String query = "SELECT Balance FROM customers WHERE card_no = ? AND pin = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, cardNo);
                pstmt.setString(2, pin);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    double currentBalance = rs.getDouble("Balance");

                    if (amount > currentBalance) {
                        JOptionPane.showMessageDialog(this, "Insufficient funds. Current balance: $" + currentBalance, "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        currentBalance -= amount;
                        String updateQuery = "UPDATE customers SET Balance = ? WHERE card_no = ?";
                        PreparedStatement updatePstmt = conn.prepareStatement(updateQuery);
                        updatePstmt.setDouble(1, currentBalance);
                        updatePstmt.setString(2, cardNo);
                        updatePstmt.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Withdrawal successful. New balance: $" + currentBalance, "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid card number or PIN.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
