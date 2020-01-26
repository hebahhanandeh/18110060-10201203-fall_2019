import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Toolkit;

public class VacationsPage extends JFrame {

	private static final long serialVersionUID = 3402793595818297141L;

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private String[] typesOfVacations = { "Select One", "Leaving", "Sick Leave", "Annual Vacation" };
	private File file = new File("C:\\MinistryOfFinanceFiles\\Vacations.txt");
	private FileWriter fileWriter;
	private MainPage mainPage = new MainPage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VacationsPage frame = new VacationsPage();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VacationsPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VacationsPage.class.getResource("/images/calendar.png")));
		setTitle("Vacations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		JLabel lblMinistryOfFinance = new JLabel("Ministry of Finance");
		lblMinistryOfFinance.setForeground(new Color(255, 255, 51));
		lblMinistryOfFinance.setHorizontalAlignment(SwingConstants.CENTER);
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

		JLabel lblType = new JLabel("Type");
		lblType.setForeground(new Color(255, 255, 102));
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblType.setBounds(71, 38, 51, 14);
		panel_1.add(lblType);

		final JComboBox comboBox = new JComboBox(typesOfVacations);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "Leaving", "Sick Leave", "Annual Vacation" }));
		comboBox.setBackground(new Color(255, 255, 153));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setForeground(new Color(0, 204, 153));
		comboBox.setBounds(115, 36, 119, 20);
		panel_1.add(comboBox);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setForeground(new Color(255, 255, 102));
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitle.setBounds(71, 77, 46, 14);
		panel_1.add(lblTitle);

		textFieldTitle = new JTextField();
		textFieldTitle.setBackground(new Color(255, 255, 153));
		textFieldTitle.setForeground(new Color(0, 204, 153));
		textFieldTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldTitle.setBounds(115, 75, 234, 20);
		panel_1.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		JLabel lblText = new JLabel("Text");
		lblText.setForeground(new Color(255, 255, 102));
		lblText.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblText.setBounds(71, 113, 46, 14);
		panel_1.add(lblText);

		JTextArea textAreaText = new JTextArea();
		textAreaText.setBackground(new Color(255, 255, 153));
		textAreaText.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textAreaText.setForeground(new Color(0, 204, 153));
		textAreaText.setBounds(115, 113, 234, 142);
		panel_1.add(textAreaText);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fileWriter = new FileWriter(file, true);
					String type = (String) comboBox.getSelectedItem();
					String title = textFieldTitle.getText();
					String text = textAreaText.getText();
					fileWriter.write(String.format("%s, %s, %s%n", type, title, text, "\n"));
					fileWriter.flush();
					fileWriter.close();
					
				} catch (IOException e1) {
					System.out.println(e1);
				}
	
				textFieldTitle.setText("");
				textAreaText.setText("");
				comboBox.updateUI();
				mainPage.setVisible(true);
				mainPage.setLocationRelativeTo(null);
				mainPage.setResizable(false);
				setVisible(false);
			}
		});
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSend.setForeground(new Color(0, 204, 153));
		btnSend.setBackground(new Color(255, 255, 102));
		btnSend.setBounds(71, 290, 89, 23);
		panel_1.add(btnSend);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPage.setVisible(true);
				mainPage.setLocationRelativeTo(null);
				mainPage.setResizable(false);
				setVisible(false);
			}
		});
		btnBack.setBackground(new Color(255, 255, 102));
		btnBack.setForeground(new Color(0, 204, 153));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(278, 290, 89, 23);
		panel_1.add(btnBack);
	}
}
