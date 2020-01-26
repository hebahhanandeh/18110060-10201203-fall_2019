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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MonthlyReports extends JFrame {

	private static final long serialVersionUID = -8226699141491415966L;
	
	private JPanel contentPane;
	private JTable table;
	private String path = "C:\\MinistryOfFinanceFiles\\MonthlyReports.txt";
	private File file = new File(path);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonthlyReports frame = new MonthlyReports();
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
	public MonthlyReports() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MonthlyReports.class.getResource("/images/diagram.png")));
		setTitle("Monthly Reports");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 10));
		
		JLabel lblMinistryOfFinance = new JLabel("Ministry of Finance");
		lblMinistryOfFinance.setForeground(new Color(255, 255, 51));
		lblMinistryOfFinance.setHorizontalAlignment(SwingConstants.CENTER);
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
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/images/logout.png")).getImage()
				.getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 153));
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setForeground(new Color(0, 204, 153));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Month", "Spendings", "Earnings"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnInsertData = new JButton("Insert Data");
		btnInsertData.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader reader = new FileReader(file);
					BufferedReader read = new BufferedReader(reader);
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					Object[] lines = read.lines().toArray();
					
					for(int i = 0; i < lines.length; i++) {
						String[] row = lines[i].toString().split("\t\t");
						model.addRow(row);
					}
					read.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnInsertData.setBackground(new Color(255, 255, 102));
		btnInsertData.setForeground(new Color(0, 204, 153));
		btnInsertData.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(btnInsertData);
		
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
		btnBack.setBackground(new Color(255, 255, 102));
		btnBack.setForeground(new Color(0, 204, 153));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(btnBack);
	}
}
