package BankingApp;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class Form_3 extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnCurrentAccount;
	private JRadioButton rdbtnFixedDipositAccount;
	private JRadioButton rdbtnCombineAccount;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private String cardnumber;
	private String pinnumber;
	private JRadioButton rdbtnAtmCard;
	private JRadioButton rdbtnChecqueBook;
	private JRadioButton rdbtnEstatement;
	private JRadioButton rdbtnEmailsmsAlerts;
	 private static long applicationNumber;
	 private JTextField textField;
	 private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_3 frame = new Form_3(applicationNumber);
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
	public Form_3(long appNumber) {
		this.applicationNumber = appNumber; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 636);
		setTitle("Account Details");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Page Title
		JLabel lblNewLabel = new JLabel("Page 3: Account Details");
		lblNewLabel.setBounds(297, 25, 311, 63);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.BOLD, 21));
		contentPane.add(lblNewLabel);
		
		//Account Type
		JLabel lblNewLabel_1 = new JLabel("Account Type:");
		lblNewLabel_1.setBounds(84, 115, 116, 49);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		rdbtnNewRadioButton = new JRadioButton("Saving Account");
		rdbtnNewRadioButton.setBounds(252, 124, 136, 32);
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnCurrentAccount = new JRadioButton("Current Account");
		rdbtnCurrentAccount.setBounds(252, 172, 136, 32);
		rdbtnCurrentAccount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnCurrentAccount.setBackground(Color.WHITE);
		contentPane.add(rdbtnCurrentAccount);
		
		rdbtnFixedDipositAccount = new JRadioButton("Fixed Deposit Account");
		rdbtnFixedDipositAccount.setBounds(472, 124, 188, 32);
		rdbtnFixedDipositAccount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnFixedDipositAccount.setBackground(Color.WHITE);
		contentPane.add(rdbtnFixedDipositAccount);
		
		rdbtnCombineAccount = new JRadioButton("Combine Account");
		rdbtnCombineAccount.setBounds(472, 172, 225, 32);
		rdbtnCombineAccount.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnCombineAccount.setBackground(Color.WHITE);
		contentPane.add(rdbtnCombineAccount);
		
		ButtonGroup accountTypeGroup = new ButtonGroup();
		accountTypeGroup.add(rdbtnNewRadioButton);
		accountTypeGroup.add(rdbtnCurrentAccount);
		accountTypeGroup.add(rdbtnFixedDipositAccount);
		accountTypeGroup.add(rdbtnCombineAccount);
		
		//Card No
		JLabel lblNewLabel_1_1 = new JLabel("Card No:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(84, 215, 116, 49);
		contentPane.add(lblNewLabel_1_1);
		
		// Generating random card number and PIN
		Random rand = new Random();
		cardnumber = "" + Math.abs((rand.nextLong() % 90000000000L)) + 65145L;
		pinnumber = "" + Math.abs((rand.nextLong() % 9000L));
		
		lblNewLabel_2 = new JLabel("XXXX-XXXX-XXXX-" + cardnumber.substring(cardnumber.length() - 4));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(252, 225, 225, 31);
		contentPane.add(lblNewLabel_2);
		
		//PIN
		JLabel lblNewLabel_1_1_1 = new JLabel("PIN:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(84, 269, 116, 49);
		contentPane.add(lblNewLabel_1_1_1);
		
		lblNewLabel_2_1 = new JLabel("XXXX");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(252, 278, 225, 31);
		contentPane.add(lblNewLabel_2_1);
		
		//Services
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Services Required:");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(84, 329, 152, 49);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		rdbtnAtmCard = new JRadioButton("ATM Card");
		rdbtnAtmCard.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnAtmCard.setBackground(Color.WHITE);
		rdbtnAtmCard.setBounds(252, 329, 136, 32);
		contentPane.add(rdbtnAtmCard);
		
		rdbtnChecqueBook = new JRadioButton("Cheque Book");
		rdbtnChecqueBook.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnChecqueBook.setBackground(Color.WHITE);
		rdbtnChecqueBook.setBounds(472, 329, 136, 32);
		contentPane.add(rdbtnChecqueBook);
		
		rdbtnEstatement = new JRadioButton("E-Statement");
		rdbtnEstatement.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnEstatement.setBackground(Color.WHITE);
		rdbtnEstatement.setBounds(252, 375, 136, 32);
		contentPane.add(rdbtnEstatement);
		
		rdbtnEmailsmsAlerts = new JRadioButton("Email/SMS Alerts");
		rdbtnEmailsmsAlerts.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnEmailsmsAlerts.setBackground(Color.WHITE);
		rdbtnEmailsmsAlerts.setBounds(472, 375, 136, 32);
		contentPane.add(rdbtnEmailsmsAlerts);
		
		//Acknowledgement 
		chckbxNewCheckBox = new JCheckBox("I hereby declare that the above information is correct to the best of my knowledge");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(84, 492, 576, 32);
		contentPane.add(chckbxNewCheckBox);
		
		//EXIT Button
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
		            System.exit(0);
		        }
		    }
		});
	
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(651, 556, 89, 32);
		contentPane.add(btnNewButton);
		
		//Submit Button
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String balance=textField.getText();	
				if (!rdbtnNewRadioButton.isSelected() && !rdbtnCurrentAccount.isSelected() && !rdbtnFixedDipositAccount.isSelected() && !rdbtnCombineAccount.isSelected()) {
	                JOptionPane.showMessageDialog(null, "Please select an Account Type");
	               
	            }

	        	else  if (!rdbtnAtmCard.isSelected() && !rdbtnChecqueBook.isSelected() && !rdbtnEstatement.isSelected() && !rdbtnEmailsmsAlerts.isSelected()) {
	                JOptionPane.showMessageDialog(null, "Please select at least one Service");
	               
	            }

	        	else  if (!chckbxNewCheckBox.isSelected()) {
	                JOptionPane.showMessageDialog(null, "Please acknowledge the declaration");
	        }
	        	else if(balance.isEmpty())
	        	{
	        		JOptionPane.showMessageDialog(null, "Please Enter some balance this is the mandatory field");
	        	}
				
				else {
					insertDataIntoDatabase();
					JOptionPane.showMessageDialog(null, "Card No: "+ cardnumber +"\nPIN: " +pinnumber);
		            JOptionPane.showMessageDialog(null, "Form submitted successfully!");
		            System.exit(0);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(519, 556, 89, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Balance:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(84, 430, 76, 42);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(252, 437, 270, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\acco1.jpg"));
		lblNewLabel_3.setBounds(37, -34, 226, 174);
		contentPane.add(lblNewLabel_3);
	}
	//Inserting Data into database
	private void insertDataIntoDatabase() {
		String accountType = getSelectedAccountType();
		String services = getSelectedServices();
		String balance=textField.getText();		
		// Database connection details
		String url = "jdbc:mysql://localhost:3306/BankManagementSystem";
		String user = "root";
		String password = "Ak,3f.p8@&!wE";
		
		// SQL query to insert data
		String query = "UPDATE customers SET account_type =?, card_no =? , pin=?, services=? , Balance=? WHERE application_no = ?";
		
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, accountType);
			pstmt.setString(2, cardnumber);
			pstmt.setString(3, pinnumber);
			pstmt.setString(4, services);
			pstmt.setString(5, balance);
			pstmt.setLong(6, applicationNumber);
			
			pstmt.executeUpdate();
			
			 System.out.println("Data successfully inserted in form 3" );
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private String getSelectedAccountType() {
		if (rdbtnNewRadioButton.isSelected()) {
			return "Saving Account";
		} else if (rdbtnCurrentAccount.isSelected()) {
			return "Current Account";
		} else if (rdbtnFixedDipositAccount.isSelected()) {
			return "Fixed Deposit Account";
		} else if (rdbtnCombineAccount.isSelected()) {
			return "Combine Account";
		}
		return "Not Selected";
	}
	
	private String getSelectedServices() {
		StringBuilder services = new StringBuilder();
		if (rdbtnAtmCard.isSelected()) {
			services.append("ATM Card ");
		}
		if (rdbtnChecqueBook.isSelected()) {
			services.append("Cheque Book ");
		}
		if (rdbtnEstatement.isSelected()) {
			services.append("E-Statement ");
		}
		if (rdbtnEmailsmsAlerts.isSelected()) {
			services.append("Email/SMS Alerts ");
		}
		return services.toString().trim();
	}
}
