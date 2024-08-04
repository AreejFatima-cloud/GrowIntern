package BankingApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.sql.*
;
import javax.swing.ImageIcon;public class Form2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PANField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox_2;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_3;
	private JComboBox<String> comboBox_4;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_1_1;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	 private static long applicationNumber;
	 private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form2 frame = new Form2(applicationNumber);
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
	public Form2(long appNumber) {
		this.applicationNumber = appNumber; 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 757, 663);
		setTitle("Additional Information");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Page 2: Additional Information");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel_1.setBounds(213, 32, 420, 61);
		contentPane.add(lblNewLabel_1);
		
		//Category
		JLabel CategoryLabel = new JLabel("Category:");
		CategoryLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		CategoryLabel.setBounds(190, 129, 109, 30);
		contentPane.add(CategoryLabel);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "General", "OBC", "SC", "SE", "Other"}));
		comboBox_2.setBounds(328, 130, 305, 30);
		contentPane.add(comboBox_2);

		//Pan Number
		JLabel PAN = new JLabel("PAN Number:");
		PAN.setFont(new Font("Times New Roman", Font.BOLD, 14));
		PAN.setBounds(190, 337, 123, 30);
		contentPane.add(PAN);
		PANField = new JTextField();
		PANField.setBounds(328, 338, 305, 30);
		contentPane.add(PANField);
		PANField.setColumns(10);
		
		//Qualification
		JLabel lblNewLabel_2_3 = new JLabel("Qualification:");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(190, 228, 153, 37);
		contentPane.add(lblNewLabel_2_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Matric", "Intermediate", "UnderGraduate", "Graduate", "Masters", "P.H.D", "Other"}));
		comboBox.setBounds(328, 232, 305, 30);
		contentPane.add(comboBox);
		
		//Income
		JLabel lblLastName = new JLabel("Income:");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLastName.setBounds(190, 179, 109, 30);
		contentPane.add(lblLastName);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "0-50,000", "50,000-100,000", "100,000-200,000", "200,000-400,000", ">400,000"}));
		comboBox_3.setBounds(328, 180, 305, 30);
		contentPane.add(comboBox_3);
		
		//Occupation
		JLabel lblOccupation = new JLabel("Occupation:");
		lblOccupation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblOccupation.setBounds(190, 276, 123, 30);
		contentPane.add(lblOccupation);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"", "Self-Employed", "Government Employ", "Salaried", "Business", "Student", "Retire", "Other"}));
		comboBox_4.setBounds(328, 286, 305, 30);
		contentPane.add(comboBox_4);
		
		//Senior Citizen
		JLabel lblNewLabel = new JLabel("Senior Citizen:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(190, 378, 109, 28);
		contentPane.add(lblNewLabel);
		
		rdbtnNewRadioButton_2 = new JRadioButton("Yes");
		rdbtnNewRadioButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(328, 381, 111, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_1_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdbtnNewRadioButton_1_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1_1.setBounds(472, 383, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1_1);

		ButtonGroup group1 = new ButtonGroup();
		group1.add(rdbtnNewRadioButton_2);
		group1.add(rdbtnNewRadioButton_1_1);
		
		//Existing Account
		JLabel Existing = new JLabel("Existing Account:");
		Existing.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Existing.setBounds(190, 417, 135, 30);
		contentPane.add(Existing);
		
		rdbtnNewRadioButton = new JRadioButton("Yes");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(331, 421, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setBounds(472, 421, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		//Back Button
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account_Creation acc = new Account_Creation();
				acc.setVisible(true);			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBackground(new Color(0, 64, 128));
		btnBack.setBounds(254, 516, 89, 30);
		contentPane.add(btnBack);
		
		//Next Button 
		btnNewButton = new JButton("Next");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox_4.getSelectedItem();
				String selectedIncomeRange = (String) comboBox_3.getSelectedItem();
				String panNumber = PANField.getText();
			    if (selectedItem == null || selectedItem.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Please select an option from the dropdown list of Occupation");
			        
			    }
			    else if (selectedIncomeRange == null || selectedIncomeRange.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Please select an income range from the dropdown list.");
			    }
			    else if(panNumber.isEmpty()) {
			    	JOptionPane.showMessageDialog(null, "Please enter the PAN number");
			    }
			    
			    else {
				insertDataIntoDatabase();
				Form_3 frame = new Form_3(applicationNumber);
				frame.setVisible(true);
				 dispose(); 
			    }
						
			}
		});
		btnNewButton.setBounds(424, 516, 89, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\acco1.jpg"));
		lblNewLabel_2.setBounds(0, -44, 187, 270);
		contentPane.add(lblNewLabel_2);
	}
	
	
	//Inserting Data into DataBase
	private void insertDataIntoDatabase() {
	    // Retrieve data from form components
	    String category = (String) comboBox.getSelectedItem();
	    String income = (String) comboBox_3.getSelectedItem();
	    String occupation = (String) comboBox_4.getSelectedItem();
	    boolean isSeniorCitizen = rdbtnNewRadioButton_2.isSelected();
	    String panNumber = PANField.getText();
	    String qualification = (String) comboBox.getSelectedItem();
	    boolean hasExistingAccount = rdbtnNewRadioButton_2.isSelected();

	    // Database connection details
	    String url = "jdbc:mysql://localhost:3306/BankManagementSystem";
	    String user = "root";
	    String password = "Ak,3f.p8@&!wE";

	    try (Connection conn = DriverManager.getConnection(url, user, password)) {
	        // SQL query to insert data
	    	 String query = "UPDATE customers SET category = ?, income = ?, occupation = ?, senior_citizen = ?, pan_number = ?, qualification = ?, existing_account = ? WHERE application_no = ?";

             // Prepare statement
             PreparedStatement pstmt = conn.prepareStatement(query);
             pstmt.setString(1, category);
             pstmt.setString(2, income);
             pstmt.setString(3, occupation);
             pstmt.setBoolean(4, isSeniorCitizen);
             pstmt.setString(5, panNumber);
             pstmt.setString(6, qualification);
             pstmt.setBoolean(7, hasExistingAccount);
             pstmt.setLong(8, applicationNumber);

	        // Execute the insert
	        pstmt.executeUpdate();

	        System.out.println("Data successfully inserted in form 2");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
