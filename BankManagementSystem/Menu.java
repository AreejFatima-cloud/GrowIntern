package BankingApp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Menu extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static final String WELCOME_TEXT = "WELCOME TO BANK MANAGEMENT SYSTEM";
    private static final int TYPING_DELAY = 100; // delay in milliseconds

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
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
    public Menu() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Pictures\\bank.PNG"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 611, 403);
        setTitle("Menu");

        JMenuBar menuBar = new JMenuBar();
        menuBar.setForeground(Color.WHITE);
        menuBar.setBackground(new Color(4, 5, 38));
        setJMenuBar(menuBar);

        JMenu mnNewMenu_1 = new JMenu("Account Info");
        mnNewMenu_1.setForeground(Color.WHITE);
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("About Account Info");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Account_Info info = new Account_Info();
        		info.setVisible(true);
        		dispose();
        	}
        });
        mnNewMenu_1.add(mntmNewMenuItem_2);

        JMenu mnNewMenu = new JMenu("Transaction");
        mnNewMenu.setForeground(Color.WHITE);
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Deposit");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Deposit deposit= new Deposit();
        		deposit.setVisible(true);
        		dispose();
        	}
        });
        mntmNewMenuItem_3.setForeground(Color.BLACK);
        mnNewMenu.add(mntmNewMenuItem_3);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("WithDraw");
        mntmNewMenuItem_1.setForeground(Color.BLACK);
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WithDraw withdrawal = new WithDraw();
                withdrawal.setVisible(true);
                dispose();
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_2 = new JMenu("Balance Inquiry");
        mnNewMenu_2.setForeground(Color.WHITE);
        menuBar.add(mnNewMenu_2);

        JMenuItem mntmNewMenuItem = new JMenuItem("Balance Check");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		balanceCheck chk = new balanceCheck();
        		chk.setVisible(true);
        		dispose();
               // Menu menu=new Menu();
               // menu.setVisible(true);
        	}
        });
        mntmNewMenuItem.setForeground(Color.BLACK);
        mnNewMenu_2.add(mntmNewMenuItem);
        
        JMenu mnNewMenu_3 = new JMenu("Exit");
        mnNewMenu_3.setForeground(Color.WHITE);
        menuBar.add(mnNewMenu_3);
        
        JMenuItem mntmNewMenuItem_4 = new JMenuItem("Close");
        mntmNewMenuItem_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
		            System.exit(0);
		        }
        	}
        });
        mnNewMenu_3.add(mntmNewMenuItem_4);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblWelcome = new JLabel("");
        lblWelcome.setForeground(new Color(255, 255, 255));
        lblWelcome.setFont(new Font("Serif", Font.BOLD, 20)); // Set desired font and size
        lblWelcome.setBounds(10, 10, 580, 30);
        contentPane.add(lblWelcome);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\bank.PNG"));
        lblNewLabel.setBounds(0, -45, 603, 411);
        contentPane.add(lblNewLabel);

        // Timer to create the typewriter effect
        Timer timer = new Timer(TYPING_DELAY, new ActionListener() {
            private int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < WELCOME_TEXT.length()) {
                    lblWelcome.setText(lblWelcome.getText() + WELCOME_TEXT.charAt(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }
}
