import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ReportsPage extends JFrame {

	private static final long serialVersionUID = -2392379920208566623L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportsPage frame = new ReportsPage();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReportsPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReportsPage.class.getResource("/images/diagram.png")));
		setTitle("Reports");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblMinistryOfFinance = new JLabel("Ministry of Finance");
		lblMinistryOfFinance.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinistryOfFinance.setForeground(new Color(255, 255, 51));
		lblMinistryOfFinance.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblMinistryOfFinance);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LoginPage login = new LoginPage();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				login.setResizable(false);
				setVisible(false);
			}
		});
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/images/logout.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		label.setIcon(imageIcon);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnMonthlyFillData = new JButton("Fill Data");
		btnMonthlyFillData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonthlyFillData monthly = new MonthlyFillData();
				monthly.setVisible(true);
				monthly.setLocationRelativeTo(null);
				monthly.setResizable(false);
				setVisible(false);
			}
		});
		btnMonthlyFillData.setForeground(new Color(0, 204, 153));
		btnMonthlyFillData.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnMonthlyFillData.setBackground(new Color(255, 255, 102));
		btnMonthlyFillData.setBounds(56, 49, 120, 23);
		panel_1.add(btnMonthlyFillData);
		
		JButton btnFillData = new JButton("Fill Data");
		btnFillData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YearlyFillData yearly = new YearlyFillData();
				yearly.setVisible(true);
				yearly.setLocationRelativeTo(null);
				yearly.setResizable(false);
				setVisible(false);
			}
		});
		btnFillData.setForeground(new Color(0, 204, 153));
		btnFillData.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnFillData.setBackground(new Color(255, 255, 102));
		btnFillData.setBounds(240, 49, 120, 23);
		panel_1.add(btnFillData);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage mainPage = new MainPage();
				mainPage.setVisible(true);
				mainPage.setLocationRelativeTo(null);
				mainPage.setResizable(false);
				setVisible(false);
			}
		});
		btnBack.setBackground(new Color(255, 255, 102));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setForeground(new Color(0, 204, 153));
		btnBack.setBounds(312, 175, 89, 23);
		panel_1.add(btnBack);
		
		JButton btnViewReport = new JButton("View Report");
		btnViewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YearlyReports yearly = new YearlyReports();
				yearly.setVisible(true);
				yearly.setLocationRelativeTo(null);
				yearly.setResizable(false);
				setVisible(false);
			}
		});
		btnViewReport.setBackground(new Color(255, 255, 102));
		btnViewReport.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnViewReport.setForeground(new Color(0, 204, 153));
		btnViewReport.setBounds(240, 83, 120, 23);
		panel_1.add(btnViewReport);
		
		JLabel lblYearly = new JLabel("Yearly");
		lblYearly.setForeground(new Color(255, 255, 102));
		lblYearly.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblYearly.setBounds(271, 11, 46, 14);
		panel_1.add(lblYearly);
		
		JButton btnMonthlyViewReport = new JButton("View Report");
		btnMonthlyViewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MonthlyReports monthly = new MonthlyReports();
				monthly.setVisible(true);
				monthly.setLocationRelativeTo(null);
				monthly.setResizable(false);
				setVisible(false);
			}
		});
		btnMonthlyViewReport.setBackground(new Color(255, 255, 102));
		btnMonthlyViewReport.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnMonthlyViewReport.setForeground(new Color(0, 204, 153));
		btnMonthlyViewReport.setBounds(56, 83, 120, 23);
		panel_1.add(btnMonthlyViewReport);
		
		JLabel lblMonthly = new JLabel("Monthly");
		lblMonthly.setForeground(new Color(255, 255, 102));
		lblMonthly.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMonthly.setBounds(87, 12, 56, 14);
		panel_1.add(lblMonthly);
	}

}
