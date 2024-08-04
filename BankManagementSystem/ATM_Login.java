package BankingApp;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.sql.*;
public class ATM_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM_Login frame = new ATM_Login();
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
	public ATM_Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 592, 383);
		setTitle("Login");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter your Login Credentials");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 19));
		lblNewLabel.setBounds(163, 25, 343, 70);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Card No:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1.setBounds(181, 116, 103, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PIN:");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_2.setBounds(181, 190, 72, 35);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(322, 122, 184, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(322, 190, 184, 35);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cardNo = textField.getText();
		        String pin = new String(passwordField.getPassword());

		        // Database connection details
		        String url = "jdbc:mysql://localhost:3306/BankManagementSystem";
		        String user = "root";
		        String password = "Ak,3f.p8@&!wE";

		        // SQL query to check if the card number and PIN exist
		        String query = "SELECT * FROM customers WHERE card_no = ? AND pin = ?";

		        try (Connection conn = DriverManager.getConnection(url, user, password)) {
		            PreparedStatement pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, cardNo);
		            pstmt.setString(2, pin);

		            ResultSet rs = pstmt.executeQuery();

		            if (rs.next()) {
		                Menu menu=new Menu();
		                menu.setVisible(true);
		                dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Invalid card number or PIN.");
		                textField.setText("");
		                passwordField.setText("");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(181, 281, 103, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SignUp");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account_Creation accountCreationForm = new Account_Creation();
				accountCreationForm.setVisible(true);			}
		});
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(304, 281, 103, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(427, 281, 93, 41);
		contentPane.add(btnNewButton_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(38, 256, 507, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\login.png"));
		lblNewLabel_3.setBounds(23, -12, 117, 156);
		contentPane.add(lblNewLabel_3);
	}
}
