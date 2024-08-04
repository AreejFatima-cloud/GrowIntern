package BankingApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class balanceCheck extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCardNumber;
    private JTextField txtPin;
    private JLabel lblBalance;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    balanceCheck frame = new balanceCheck();
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
    public balanceCheck() {
        setTitle("Balance Inquiry");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Pictures\\balance.PNG"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 510, 499);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setBounds(50, 50, 150, 25);
        contentPane.add(lblCardNumber);

        txtCardNumber = new JTextField();
        txtCardNumber.setBounds(200, 50, 200, 25);
        contentPane.add(txtCardNumber);
        txtCardNumber.setColumns(10);

        JLabel lblPin = new JLabel("PIN:");
        lblPin.setBounds(50, 100, 150, 25);
        contentPane.add(lblPin);

        txtPin = new JTextField();
        txtPin.setBounds(200, 100, 200, 25);
        contentPane.add(txtPin);
        txtPin.setColumns(10);

        JButton btnCheckBalance = new JButton("Check Balance");
        btnCheckBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkBalance();
                dispose();
                Menu menu=new Menu();
                menu.setVisible(true);
            }
        });
        btnCheckBalance.setBounds(200, 150, 150, 25);
        contentPane.add(btnCheckBalance);

        lblBalance = new JLabel("");
        lblBalance.setBounds(50, 200, 400, 25);
        contentPane.add(lblBalance);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\balance1.jpg"));
        lblNewLabel.setBounds(0, 0, 500, 462);
        contentPane.add(lblNewLabel);
    }

    private void checkBalance() {
        String cardNumber = txtCardNumber.getText();
        String pin = txtPin.getText();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem", "root", "Ak,3f.p8@&!wE");

            String query = "SELECT Balance FROM customers WHERE card_no = ? AND pin = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, cardNumber);
            pst.setString(2, pin);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("Balance");
                JOptionPane.showMessageDialog(null, "Balance:"+ balance);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid card number or PIN.", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching the balance.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
