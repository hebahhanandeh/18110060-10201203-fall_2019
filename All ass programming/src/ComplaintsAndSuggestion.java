import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComplaintsAndSuggestion extends JFrame {

	private static final long serialVersionUID = 8390933109734734842L;

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private String[] type = { "", "Complaint", "Suggestion" };
	private File file = new File("C:\\MinistryOfFinanceFiles\\ComplaintsAndSuggestion.txt");
	private FileWriter fileWriter;
	private MainPage mainPage = new MainPage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComplaintsAndSuggestion frame = new ComplaintsAndSuggestion();
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
	public ComplaintsAndSuggestion() {
		setTitle("Complaints & Suggestions");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ComplaintsAndSuggestion.class.getResource("/images/red-card.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 424);
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
		lblMinistryOfFinance.setBackground(new Color(255, 255, 255));
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
		lblType.setBounds(65, 40, 46, 14);
		panel_1.add(lblType);

		JComboBox comboBox = new JComboBox(type);
		comboBox.setBackground(new Color(255, 255, 153));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setForeground(new Color(0, 204, 153));
		comboBox.setBounds(121, 38, 132, 20);
		panel_1.add(comboBox);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTitle.setForeground(new Color(255, 255, 102));
		lblTitle.setBounds(65, 65, 46, 14);
		panel_1.add(lblTitle);

		textFieldTitle = new JTextField();
		textFieldTitle.setForeground(new Color(0, 204, 153));
		textFieldTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldTitle.setBackground(new Color(255, 255, 153));
		textFieldTitle.setBounds(121, 63, 231, 20);
		panel_1.add(textFieldTitle);
		textFieldTitle.setColumns(10);

		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblText.setForeground(new Color(255, 255, 102));
		lblText.setBounds(65, 90, 46, 14);
		panel_1.add(lblText);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 153));
		textArea.setForeground(new Color(0, 204, 153));
		textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textArea.setBounds(121, 92, 231, 189);
		panel_1.add(textArea);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					fileWriter = new FileWriter(file, true);
					String type = (String) comboBox.getSelectedItem();
					String title = textFieldTitle.getText();
					String text = textArea.getText();
					fileWriter.write(String.format("%s, %s, %s%n", type, title, text, "\n"));
					fileWriter.flush();
					fileWriter.close();
					
				} catch (IOException e1) {
					System.out.println(e1);
				}
	
				textFieldTitle.setText("");
				textArea.setText("");
				comboBox.updateUI();
				mainPage.setVisible(true);
				mainPage.setLocationRelativeTo(null);
				mainPage.setResizable(false);
				setVisible(false);
				
			}
		});
		btnSend.setForeground(new Color(0, 204, 153));
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSend.setBackground(new Color(255, 255, 102));
		btnSend.setBounds(53, 311, 89, 23);
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
		btnBack.setBackground(new Color(255, 255, 153));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setForeground(new Color(0, 204, 153));
		btnBack.setBounds(296, 312, 89, 23);
		panel_1.add(btnBack);
	}

}
