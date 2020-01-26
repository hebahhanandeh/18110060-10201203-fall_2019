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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MonthlyFillData extends JFrame {

	private static final long serialVersionUID = -9006972087798190207L;
	
	private JPanel contentPane;
	private JTextField textFieldSpending;
	private JTextField textFieldEarning;
	private String[] months = {"Select Month", "January", "February", "March", "April", "May", "June", 
			"July", "August", "September", "October", "November", "December"};
	private File file = new File("C:\\MinistryOfFinanceFiles\\MonthlyReports.txt");
	private FileWriter fileWriter;
	private ReportsPage reports = new ReportsPage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonthlyFillData frame = new MonthlyFillData();
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
	public MonthlyFillData() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MonthlyFillData.class.getResource("/images/diagram.png")));
		setTitle("Fill Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 235);
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
		lblMinistryOfFinance.setBackground(new Color(0, 0, 102));
		panel.add(lblMinistryOfFinance);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginPage login = new LoginPage();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				login.setResizable(false);
				setVisible(false);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/images/logout.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setForeground(new Color(255, 255, 102));
		lblMonth.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMonth.setEnabled(true);
		lblMonth.setBounds(29, 26, 46, 14);
		panel_1.add(lblMonth);
		
		JComboBox comboBox = new JComboBox(months);
		comboBox.setBackground(new Color(255, 255, 153));
		comboBox.setForeground(new Color(0, 204, 153));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(119, 23, 109, 20);
		panel_1.add(comboBox);
		
		JLabel lblSpending = new JLabel("Spending");
		lblSpending.setForeground(new Color(255, 255, 102));
		lblSpending.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSpending.setBounds(29, 62, 56, 20);
		panel_1.add(lblSpending);
		
		textFieldSpending = new JTextField();
		textFieldSpending.setBackground(new Color(255, 255, 153));
		textFieldSpending.setForeground(new Color(0, 204, 153));
		textFieldSpending.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldSpending.setBounds(119, 63, 86, 20);
		panel_1.add(textFieldSpending);
		textFieldSpending.setColumns(10);
		
		JLabel lblEarning = new JLabel("Earning");
		lblEarning.setForeground(new Color(255, 255, 102));
		lblEarning.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEarning.setBounds(29, 93, 56, 20);
		panel_1.add(lblEarning);
		
		textFieldEarning = new JTextField();
		textFieldEarning.setBackground(new Color(255, 255, 153));
		textFieldEarning.setForeground(new Color(0, 204, 153));
		textFieldEarning.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldEarning.setBounds(119, 94, 86, 20);
		panel_1.add(textFieldEarning);
		textFieldEarning.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fileWriter = new FileWriter(file, true);
					String month = (String) comboBox.getSelectedItem();
					String spending = textFieldSpending.getText();
					String earning = textFieldEarning.getText();
					fileWriter.write(String.format("%s\t\t%s\t\t%s%n", month, spending, earning, "\n"));
					fileWriter.flush();
					fileWriter.close();
					
				} catch (IOException e1) {
					System.out.println(e1);
				}
	
				textFieldSpending.setText("");
				textFieldEarning.setText("");
				comboBox.updateUI();
				reports.setVisible(true);
				reports.setLocationRelativeTo(null);
				reports.setResizable(false);
				setVisible(false);
			}
		});
		btnSave.setBackground(new Color(255, 255, 102));
		btnSave.setForeground(new Color(0, 204, 153));
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBounds(269, 39, 89, 23);
		panel_1.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reports.setVisible(true);
				reports.setLocationRelativeTo(null);
				reports.setResizable(false);
				setVisible(false);
			}
		});
		btnBack.setForeground(new Color(0, 204, 153));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBackground(new Color(255, 255, 102));
		btnBack.setBounds(269, 79, 89, 23);
		panel_1.add(btnBack);
	}
}
