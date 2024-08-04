package BankingApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showaccountInfo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblAppNo;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblEmail;
    private JLabel lblBalance;
    private JLabel lblServices;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    showaccountInfo frame = new showaccountInfo("", "", "", "", "", "");
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
    public showaccountInfo(String appNo, String firstName, String lastName, String email, String balance, String services) {
    	setTitle("Show Information");
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Downloads\\showicon.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 609, 500);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblAppNo = new JLabel("Application No: " + appNo);
        lblAppNo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblAppNo.setBounds(28, 83, 400, 25);
        contentPane.add(lblAppNo);

        lblFirstName = new JLabel("First Name: " + firstName);
        lblFirstName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblFirstName.setBounds(28, 113, 400, 25);
        contentPane.add(lblFirstName);

        lblLastName = new JLabel("Last Name: " + lastName);
        lblLastName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblLastName.setBounds(28, 149, 400, 25);
        contentPane.add(lblLastName);

        lblEmail = new JLabel("Email: " + email);
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblEmail.setBounds(28, 185, 400, 25);
        contentPane.add(lblEmail);

        lblBalance = new JLabel("Balance: " + balance);
        lblBalance.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblBalance.setBounds(28, 225, 400, 25);
        contentPane.add(lblBalance);

        lblServices = new JLabel("Services: " + services);
        lblServices.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblServices.setBounds(28, 261, 400, 25);
        contentPane.add(lblServices);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Downloads\\info2.png"));
        lblNewLabel.setBounds(286, 11, 299, 387);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Go Back");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Menu menu=new Menu();
                menu.setVisible(true);
        	}
        });
        btnNewButton.setBackground(Color.LIGHT_GRAY);
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnNewButton.setBounds(213, 339, 89, 33);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("Your Account Information:");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
        lblNewLabel_1.setBounds(164, 27, 252, 36);
        contentPane.add(lblNewLabel_1);
    }
}
