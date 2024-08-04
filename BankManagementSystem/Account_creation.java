package BankingApp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.sql.*
;
import javax.swing.ImageIcon;public class Account_Creation extends JFrame {

	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField nationalityField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JDateChooser dateChooser;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JLabel form_No;
	long applicationNumber;
	private JLabel lblNewLabel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_Creation frame = new Account_Creation();
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
	public Account_Creation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1154, 731);
		setTitle("Personal Details");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Generating Application No
        applicationNumber = Math.abs((rand.nextLong() % 90001 + 10001));
        form_No = new JLabel("Application Form No: " + applicationNumber);
		form_No.setFont(new Font("Verdana", Font.BOLD, 22));
		form_No.setBounds(362, 11, 408, 68);
		contentPane.add(form_No);
		
		
		lblNewLabel_1 = new JLabel("Page 1: Personal Details");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(427, 90, 267, 30);
		contentPane.add(lblNewLabel_1);
		
		//First Name
		JLabel nameLabel = new JLabel("First Name:");
		nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nameLabel.setBounds(60, 171, 109, 30);
		contentPane.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(181, 172, 305, 30);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		//Middle Name
		JLabel lblMiddleName = new JLabel("Middle Name:");
		lblMiddleName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMiddleName.setBounds(578, 171, 109, 30);
		contentPane.add(lblMiddleName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(736, 171, 305, 30);
		contentPane.add(textField);
		
		//Last Name
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLastName.setBounds(60, 212, 109, 30);
		contentPane.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 213, 305, 30);
		contentPane.add(textField_1);
		
		//Father Name
		lblNewLabel_2 = new JLabel("Father's Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(578, 212, 109, 37);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(736, 213, 305, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		//Date_Of_Birth
		JLabel dobLabel = new JLabel("Date of Birth:");
		dobLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		dobLabel.setBounds(60, 253, 135, 30);
		contentPane.add(dobLabel);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(181, 254, 305, 29);
		contentPane.add(dateChooser);

		//CNIC No
		JLabel lblNewLabel_2_1 = new JLabel("CNIC No:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(60, 294, 75, 37);
		contentPane.add(lblNewLabel_2_1);
				
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(181, 295, 305, 30);
		contentPane.add(textField_3);
				
		
		//Phone Number
		JLabel phoneLabel = new JLabel("Phone Number:");
		phoneLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		phoneLabel.setBounds(578, 297, 159, 30);
		contentPane.add(phoneLabel);
		phoneField = new JTextField();
		phoneField.setBounds(736, 298, 305, 30);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		//Email Address
		JLabel emailLabel = new JLabel("Email Address:");
		emailLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		emailLabel.setBounds(60, 376, 123, 30);
		contentPane.add(emailLabel);
		emailField = new JTextField();
		emailField.setBounds(181, 377, 305, 30);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		//Gender
		JLabel lblNewLabel_2_2 = new JLabel("Gender:");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(578, 250, 96, 37);
		contentPane.add(lblNewLabel_2_2);
				
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female", "Prefer not to say"}));
		comboBox_1.setBounds(736, 254, 305, 30);
		contentPane.add(comboBox_1);
				
		//Religion
		JLabel lblNewLabel_2_3 = new JLabel("Religion:");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(60, 332, 153, 37);
		contentPane.add(lblNewLabel_2_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Islam", "Christian", "Jew", "Athiest"}));
		comboBox.setBounds(181, 336, 305, 30);
		contentPane.add(comboBox);
		
		//Nationality
		JLabel nationalityLabel = new JLabel("Nationality:");
		nationalityLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nationalityLabel.setBounds(578, 338, 123, 30);
		contentPane.add(nationalityLabel);
		
		nationalityField = new JTextField();
		nationalityField.setBounds(736, 339, 305, 30);
		contentPane.add(nationalityField);
		nationalityField.setColumns(10);

		//Country
		JLabel countryLabel = new JLabel("Country: ");
		countryLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		countryLabel.setBounds(60, 417, 135, 30);
		contentPane.add(countryLabel);
				
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(181, 417, 305, 30);
		contentPane.add(textField_5);
				
		
		//City:
		JLabel lblNewLabel_2_1_1 = new JLabel("City: ");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(578, 376, 75, 37);
		contentPane.add(lblNewLabel_2_1_1);
		
		addressField = new JTextField();
		addressField.setBounds(736, 380, 305, 30);
		contentPane.add(addressField);
		addressField.setColumns(10);
		
		//Postal Code:
		JLabel lblNewLabel_2_1_2 = new JLabel("Postal Code:");
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(578, 417, 109, 37);
		contentPane.add(lblNewLabel_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(736, 421, 305, 30);
		contentPane.add(textField_4);
		
		//Next Button to open form 2
		btnNewButton = new JButton("Next");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 64, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String name = nameField.getText().trim();
					Date dob = dateChooser.getDate();
					 String email = emailField.getText();
				    if (name.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "Please enter your Name");
				       
				    }
				    else if (dob == null) {
				        JOptionPane.showMessageDialog(null, "Please select a Date of Birth");
				    }
				    else if (email.isEmpty()) {
				        JOptionPane.showMessageDialog(null, "Please enter your Email");
				       
				    }
				    else 
				    {
					insertDataIntoDatabase();
					 Form2 form2 = new Form2(applicationNumber);
		                form2.setVisible(true);
		                dispose();  // Close current window
				    }		
					}
				});
		btnNewButton.setBounds(952, 491, 89, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\acco1.jpg"));
		lblNewLabel.setBounds(162, 0, 185, 149);
		contentPane.add(lblNewLabel);
		
		
	}
	//Inserting Data into DataBase
	private void insertDataIntoDatabase() {
        try {
            // Collecting data from the input fields
            String firstName = nameField.getText();
            String middleName = textField.getText();
            String lastName = textField_1.getText();
            Date dob = dateChooser.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dobStr = sdf.format(dob);
            String cnic = textField_3.getText();
            String religion = (String) comboBox.getSelectedItem();
            String nationality = nationalityField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String fatherName = textField_2.getText();
            String gender = (String) comboBox_1.getSelectedItem();
            String address = addressField.getText();
            String city = textField_4.getText();
            String province = textField_5.getText();
            String applicationNo = form_No.getText().split(": ")[1];

            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/BankManagementSystem"; 
            String user = "root"; 
            String password = "Ak,3f.p8@&!wE"; 

            // Creating connection
            Connection con = DriverManager.getConnection(url, user, password);

            // SQL query
            String query = "INSERT INTO customers (application_no, first_name, middle_name, last_name, dob, cnic, religion, nationality, phone, email, father_name, gender, address, city, province) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Prepare statement
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, applicationNo);
            pst.setString(2, firstName);
            pst.setString(3, middleName);
            pst.setString(4, lastName);
            pst.setString(5, dobStr);
            pst.setString(6, cnic);
            pst.setString(7, religion);
            pst.setString(8, nationality);
            pst.setString(9, phone);
            pst.setString(10, email);
            pst.setString(11, fatherName);
            pst.setString(12, gender);
            pst.setString(13, address);
            pst.setString(14, city);
            pst.setString(15, province);
           

            // Execute query
            pst.executeUpdate();

            // Close connection
            pst.close();
            con.close();

            System.out.println("Data inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}
