package BankingApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Account_Info extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCardNumber;
    private JTextField txtPin;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Account_Info frame = new Account_Info();
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
    public Account_Info() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Pictures\\account_info.PNG"));
        setTitle("Account_info");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 604, 571);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblCardNumber.setForeground(Color.WHITE);
        lblCardNumber.setBounds(50, 50, 150, 25);
        contentPane.add(lblCardNumber);

        txtCardNumber = new JTextField();
        txtCardNumber.setBounds(200, 50, 200, 25);
        contentPane.add(txtCardNumber);
        txtCardNumber.setColumns(10);

        JLabel lblPin = new JLabel("PIN:");
        lblPin.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPin.setForeground(Color.WHITE);
        lblPin.setBounds(50, 100, 150, 25);
        contentPane.add(lblPin);

        txtPin = new JTextField();
        txtPin.setBounds(200, 100, 200, 25);
        contentPane.add(txtPin);
        txtPin.setColumns(10);

        JButton btnShowInfo = new JButton("Show Info");
        btnShowInfo.setBackground(Color.WHITE);
        btnShowInfo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnShowInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAccountInfo();
                dispose();
            }
        });
        btnShowInfo.setBounds(300, 165, 100, 25);
        contentPane.add(btnShowInfo);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\account_info.PNG"));
        lblNewLabel.setBounds(0, 0, 598, 534);
        contentPane.add(lblNewLabel);
    }

    private void showAccountInfo() {
        String cardNumber = txtCardNumber.getText();
        String pin = txtPin.getText();

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankManagementSystem", "root", "Ak,3f.p8@&!wE");

            String query = "SELECT * FROM customers WHERE card_no = ? AND pin = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, cardNumber);
            pst.setString(2, pin);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String appNo = rs.getString("application_no");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String balance = String.valueOf(rs.getDouble("balance"));
                String services = rs.getString("services");

                showaccountInfo infoFrame = new showaccountInfo(appNo, firstName, lastName, email, balance, services);
                infoFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid card number or PIN.", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching the account information.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
