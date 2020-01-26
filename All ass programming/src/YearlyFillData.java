import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class YearlyFillData extends JFrame {

	private static final long serialVersionUID = 5834064110938567639L;
	
	private JPanel contentPane;
	private JTextField textFieldYear;
	private JTextField textFieldSpending;
	private JTextField textFieldEarning;
	private File file = new File("C:\\MinistryOfFinanceFiles\\YearlyReports.txt");
	private FileWriter fileWriter;
	private ReportsPage reports = new ReportsPage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YearlyFillData frame = new YearlyFillData();
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
	public YearlyFillData() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(YearlyFillData.class.getResource("/images/diagram.png")));
		setTitle("Fill Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 252);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblMinistryOfFinance = new JLabel("Ministry of Finance");
		lblMinistryOfFinance.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinistryOfFinance.setForeground(new Color(255, 255, 51));
		lblMinistryOfFinance.setBackground(new Color(0, 0, 102));
		lblMinistryOfFinance.setFont(new Font("Times New Roman", Font.BOLD, 20));
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
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/images/logout.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblYear.setForeground(new Color(255, 255, 102));
		lblYear.setBackground(new Color(0, 0, 102));
		lblYear.setEnabled(true);
		lblYear.setBounds(53, 37, 46, 14);
		panel_1.add(lblYear);
		
		textFieldYear = new JTextField();
		textFieldYear.setBackground(new Color(255, 255, 153));
		textFieldYear.setForeground(new Color(0, 204, 153));
		textFieldYear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldYear.setBounds(124, 34, 86, 20);
		panel_1.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		JLabel lblSpending = new JLabel("Spending");
		lblSpending.setForeground(new Color(255, 255, 102));
		lblSpending.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSpending.setBounds(53, 71, 70, 20);
		panel_1.add(lblSpending);
		
		textFieldSpending = new JTextField();
		textFieldSpending.setBackground(new Color(255, 255, 153));
		textFieldSpending.setForeground(new Color(0, 204, 153));
		textFieldSpending.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldSpending.setBounds(124, 72, 86, 20);
		panel_1.add(textFieldSpending);
		textFieldSpending.setColumns(10);
		
		JLabel lblEarning = new JLabel("Earning");
		lblEarning.setForeground(new Color(255, 255, 102));
		lblEarning.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEarning.setBounds(53, 105, 59, 20);
		panel_1.add(lblEarning);
		
		textFieldEarning = new JTextField();
		textFieldEarning.setForeground(new Color(0, 204, 153));
		textFieldEarning.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldEarning.setBackground(new Color(255, 255, 153));
		textFieldEarning.setBounds(124, 106, 86, 20);
		panel_1.add(textFieldEarning);
		textFieldEarning.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fileWriter = new FileWriter(file, true);
					String year = textFieldYear.getText();
					String spending = textFieldSpending.getText();
					String earning = textFieldEarning.getText();
					fileWriter.write(String.format("%s\t\t%s\t\t%s%n", year, spending, earning, "\n"));
					fileWriter.flush();
					fileWriter.close();
					
				} catch (IOException e1) {
					System.out.println(e1);
				}
	
				textFieldYear.setText("");
				textFieldSpending.setText("");
				textFieldEarning.setText("");
				reports.setVisible(true);
				reports.setLocationRelativeTo(null);
				reports.setResizable(false);
				setVisible(false);
			}
		});
		btnSave.setBackground(new Color(255, 255, 102));
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setForeground(new Color(0, 204, 153));
		btnSave.setBounds(272, 53, 89, 23);
		panel_1.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportsPage reports = new ReportsPage();
				reports.setVisible(true);
				reports.setLocationRelativeTo(null);
				reports.setResizable(false);
				setVisible(false);
			}
		});
		btnBack.setForeground(new Color(0, 204, 153));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBackground(new Color(255, 255, 102));
		btnBack.setBounds(272, 87, 89, 23);
		panel_1.add(btnBack);
	}

}
