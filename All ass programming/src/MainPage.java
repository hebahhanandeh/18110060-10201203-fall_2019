import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainPage extends JFrame {

	private static final long serialVersionUID = -6663992502611540965L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
					// to center the JFrame
					frame.setLocationRelativeTo(null);
					// to disable the maximize button
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
	public MainPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPage.class.getResource("/images/money.png")));
		setTitle("Main Page");
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
		lblMinistryOfFinance.setForeground(new Color(255, 255, 51));
		lblMinistryOfFinance.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMinistryOfFinance.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMinistryOfFinance);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				LoginPage login = new LoginPage();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				login.setResizable(false);
				setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/images/logout.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JButton btnMyInfo = new JButton("My Info");
		btnMyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfoPage infoPage = new MyInfoPage();
				infoPage.setVisible(true);
				infoPage.setLocationRelativeTo(null);
				infoPage.setResizable(false);
				setVisible(false);
			}
		});
		btnMyInfo.setForeground(new Color(0, 204, 153));
		btnMyInfo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnMyInfo.setBackground(new Color(255, 255, 102));
		btnMyInfo.setBounds(10, 65, 195, 23);
		panel_1.add(btnMyInfo);

		JButton btnReports = new JButton("Reports");
		btnReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportsPage reports = new ReportsPage();
				reports.setVisible(true);
				reports.setLocationRelativeTo(null);
				reports.setResizable(false);
				setVisible(false);
			}
		});
		btnReports.setBackground(new Color(255, 255, 102));
		btnReports.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReports.setForeground(new Color(0, 204, 153));
		btnReports.setBounds(10, 122, 195, 23);
		panel_1.add(btnReports);

		JButton btnVacations = new JButton("Vacations");
		btnVacations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VacationsPage vacations = new VacationsPage();
				vacations.setVisible(true);
				vacations.setLocationRelativeTo(null);
				vacations.setResizable(false);
				setVisible(false);
			}
		});
		btnVacations.setBackground(new Color(255, 255, 102));
		btnVacations.setForeground(new Color(0, 204, 153));
		btnVacations.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnVacations.setBounds(215, 65, 195, 23);
		panel_1.add(btnVacations);

		JButton btnComplaints = new JButton("Complaints & \r\nSuggestions");
		btnComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComplaintsAndSuggestion complaints = new ComplaintsAndSuggestion();
				complaints.setVisible(true);
				complaints.setLocationRelativeTo(null);
				complaints.setResizable(false);
				setVisible(false);
			}
		});
		btnComplaints.setForeground(new Color(0, 204, 153));
		btnComplaints.setBackground(new Color(255, 255, 102));
		btnComplaints.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnComplaints.setBounds(215, 122, 195, 23);
		panel_1.add(btnComplaints);
	}
}
