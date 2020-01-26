import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MyInfoPage extends JFrame {

	private static final long serialVersionUID = -3521527429552468306L;

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldJobNo;
	private JTextField textFieldJobTitle;
	private JTextField textFieldPhone;
	private JTextField txtFieldAddress;
	private String path = "C:\\MinistryOfFinanceFiles\\Info.txt";
	private File file = new File(path); 
	private List<String> result = new ArrayList<String>();
	private String jobNo;
	private String[] resultList;
	LoginPage login = new LoginPage();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInfoPage frame = new MyInfoPage();
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
	public MyInfoPage() {
		addWindowListener(new WindowAdapter() {
			
			@SuppressWarnings("static-access")
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader reader = new FileReader(file);
					BufferedReader read = new BufferedReader(reader);
					
					for(String line = read.readLine(); line != null; line = read.readLine()) {
						result.add(line);
					}
					
					for(String list : result) {
						resultList = list.split(" ");
						
						jobNo = login.job;
						
						if(resultList[1].equals(jobNo)) {
							textFieldName.setText(resultList[0]);
							textFieldJobNo.setText(resultList[1]);
							textFieldJobTitle.setText(resultList[2]);
							textFieldPhone.setText(resultList[3]);
							txtFieldAddress.setText(resultList[4]);
						}
					}
					read.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MyInfoPage.class.getResource("/images/support.png")));
		setTitle("My Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
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

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 102));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(10, 24, 64, 22);
		panel_1.add(lblName);

		textFieldName = new JTextField();
		textFieldName.setEditable(false);
		textFieldName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldName.setForeground(new Color(0, 204, 153));
		textFieldName.setBackground(new Color(255, 255, 153));
		textFieldName.setBounds(80, 25, 145, 20);
		panel_1.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblJobNo = new JLabel("Job No.");
		lblJobNo.setForeground(new Color(255, 255, 102));
		lblJobNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblJobNo.setBounds(10, 57, 64, 14);
		panel_1.add(lblJobNo);

		textFieldJobNo = new JTextField();
		textFieldJobNo.setEditable(false);
		textFieldJobNo.setForeground(new Color(0, 204, 153));
		textFieldJobNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldJobNo.setBackground(new Color(255, 255, 153));
		textFieldJobNo.setBounds(80, 56, 145, 20);
		panel_1.add(textFieldJobNo);
		textFieldJobNo.setColumns(10);

		JLabel lblJobTitle = new JLabel("Job Title");
		lblJobTitle.setForeground(new Color(255, 255, 102));
		lblJobTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblJobTitle.setBounds(10, 90, 75, 14);
		panel_1.add(lblJobTitle);

		textFieldJobTitle = new JTextField();
		textFieldJobTitle.setEditable(false);
		textFieldJobTitle.setForeground(new Color(0, 204, 153));
		textFieldJobTitle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldJobTitle.setBackground(new Color(255, 255, 153));
		textFieldJobTitle.setBounds(80, 87, 145, 20);
		panel_1.add(textFieldJobTitle);
		textFieldJobTitle.setColumns(10);

		JLabel lblPhoneNo = new JLabel("Phone No");
		lblPhoneNo.setForeground(new Color(255, 255, 102));
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhoneNo.setBounds(10, 118, 64, 14);
		panel_1.add(lblPhoneNo);

		textFieldPhone = new JTextField();
		textFieldPhone.setEditable(false);
		textFieldPhone.setBackground(new Color(255, 255, 153));
		textFieldPhone.setForeground(new Color(0, 204, 153));
		textFieldPhone.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldPhone.setBounds(80, 115, 145, 20);
		panel_1.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(255, 255, 102));
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddress.setBounds(10, 149, 64, 14);
		panel_1.add(lblAddress);

		txtFieldAddress = new JTextField();
		txtFieldAddress.setEditable(false);
		txtFieldAddress.setForeground(new Color(0, 204, 153));
		txtFieldAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtFieldAddress.setBackground(new Color(255, 255, 153));
		txtFieldAddress.setBounds(80, 146, 145, 20);
		panel_1.add(txtFieldAddress);
		txtFieldAddress.setColumns(10);

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
		btnBack.setForeground(new Color(0, 204, 153));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBackground(new Color(255, 255, 102));
		btnBack.setBounds(302, 204, 89, 23);
		panel_1.add(btnBack);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditMyInfo editInfo = new EditMyInfo();
				editInfo.setVisible(true);
				editInfo.setLocationRelativeTo(null);
				editInfo.setResizable(false);
				setVisible(false);
			}
		});
		btnEdit.setBackground(new Color(255, 255, 102));
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEdit.setForeground(new Color(0, 204, 153));
		btnEdit.setBounds(31, 204, 89, 23);
		panel_1.add(btnEdit);
	}
}
