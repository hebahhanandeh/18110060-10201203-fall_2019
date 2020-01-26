import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = -8968762955312457708L;

	private JPanel contentPane;
	private JTextField textFieldJobNo;
	private JPasswordField passwordField;
	private String jobNo;
	private String password;
	private String path = "C:\\MinistryOfFinanceFiles\\Login.txt";
	private File file = new File(path);
	private String[] resultList;
	private List<String> result = new ArrayList<String>();
	static String job;
	static String pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/images/login.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblMinistryOfFinance = new JLabel("Ministry of Finance");
		lblMinistryOfFinance.setForeground(new Color(255, 255, 51));
		lblMinistryOfFinance.setBackground(Color.WHITE);
		lblMinistryOfFinance.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinistryOfFinance.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(lblMinistryOfFinance, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblJobNo = new JLabel("Job No.");
		lblJobNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblJobNo.setForeground(new Color(255, 255, 51));
		lblJobNo.setBounds(71, 57, 71, 14);
		panel.add(lblJobNo);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 51));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(71, 88, 71, 14);
		panel.add(lblPassword);

		textFieldJobNo = new JTextField();
		textFieldJobNo.setForeground(new Color(0, 204, 153));
		textFieldJobNo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textFieldJobNo.setBackground(new Color(255, 255, 153));
		textFieldJobNo.setBounds(152, 55, 153, 20);
		panel.add(textFieldJobNo);
		textFieldJobNo.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage mainPage = new MainPage();
				jobNo = textFieldJobNo.getText();
				password = new String(passwordField.getPassword());

				try {
					FileReader reader = new FileReader(file);
					BufferedReader read = new BufferedReader(reader);

					for (String line = read.readLine(); line != null; line = read.readLine()) {
						result.add(line);
					}

					for (String list : result) {
						resultList = list.split(" ");
						if (resultList[0].equals(jobNo)) {
							job = resultList[0];
							pass = resultList[1];
						}
					}

					if (jobNo.equals(job) && password.equals(pass)) {
						mainPage.setVisible(true);
						mainPage.setLocationRelativeTo(null);
						mainPage.setResizable(false);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Job No. or Password is incorrect!", "Alert",
								JOptionPane.WARNING_MESSAGE);
					}
					read.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setForeground(new Color(0, 204, 204));
		btnLogin.setBackground(new Color(255, 255, 102));
		btnLogin.setBounds(153, 142, 89, 23);
		panel.add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 153));
		passwordField.setForeground(new Color(0, 204, 153));
		passwordField.setFont(new Font("Times New Roman", Font.BOLD, 13));
		passwordField.setBounds(152, 86, 153, 20);
		panel.add(passwordField);
	}
}
