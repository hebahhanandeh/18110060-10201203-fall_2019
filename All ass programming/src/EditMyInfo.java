import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EditMyInfo extends JFrame {

	private static final long serialVersionUID = -7154934275709690325L;

	private JPanel contentPane;
	private JTextField textFieldJobNo;
	private JTextField textFieldPhoneNo;
	private JTextField textFieldAddress;
	private String path = "C:\\MinistryOfFinanceFiles\\Info.txt";
	private File file = new File(path);
	private List<String> result = new ArrayList<String>();
	private MyInfoPage info = new MyInfoPage();
	private LoginPage login = new LoginPage();
	private String phone;
	private String address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditMyInfo frame = new EditMyInfo();
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
	public EditMyInfo() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader reader = new FileReader(file);
					BufferedReader read = new BufferedReader(reader);

					for (String line = read.readLine(); line != null; line = read.readLine()) {
						result.add(line);
					}

					for (String list : result) {
						String[] resultList = list.split(" ");
						if(resultList[1].equals(LoginPage.job)) {
							textFieldJobNo.setText(resultList[1]);
							textFieldPhoneNo.setText(resultList[3]);
							textFieldAddress.setText(resultList[4]);
						}
					}
					read.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditMyInfo.class.getResource("/images/support.png")));
		setTitle("Edit My Info");
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
		lblMinistryOfFinance.setBackground(new Color(0, 0, 102));
		lblMinistryOfFinance.setForeground(new Color(255, 255, 51));
		lblMinistryOfFinance.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinistryOfFinance.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblMinistryOfFinance);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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

		JLabel lblJobNo = new JLabel("Job No.");
		lblJobNo.setForeground(new Color(255, 255, 102));
		lblJobNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblJobNo.setBounds(51, 33, 46, 14);
		panel_1.add(lblJobNo);

		textFieldJobNo = new JTextField();
		textFieldJobNo.setEditable(false);
		textFieldJobNo.setForeground(new Color(0, 204, 153));
		textFieldJobNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldJobNo.setBackground(new Color(255, 255, 153));
		textFieldJobNo.setBounds(122, 31, 151, 20);
		panel_1.add(textFieldJobNo);
		textFieldJobNo.setColumns(10);

		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setForeground(new Color(255, 255, 102));
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhoneNo.setBounds(51, 70, 62, 14);
		panel_1.add(lblPhoneNo);

		textFieldPhoneNo = new JTextField();
		textFieldPhoneNo.setBackground(new Color(255, 255, 153));
		textFieldPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldPhoneNo.setForeground(new Color(0, 204, 153));
		textFieldPhoneNo.setBounds(122, 68, 151, 20);
		panel_1.add(textFieldPhoneNo);
		textFieldPhoneNo.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(255, 255, 102));
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddress.setBounds(51, 109, 62, 14);
		panel_1.add(lblAddress);

		textFieldAddress = new JTextField();
		textFieldAddress.setBackground(new Color(255, 255, 153));
		textFieldAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textFieldAddress.setForeground(new Color(0, 204, 153));
		textFieldAddress.setBounds(122, 107, 151, 20);
		panel_1.add(textFieldAddress);
		textFieldAddress.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				phone = textFieldPhoneNo.getText();
				address = textFieldAddress.getText();

				try {
					FileReader reader = new FileReader(file);
					BufferedReader read = new BufferedReader(reader);
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));

					for (String line = read.readLine(); line != null; line = read.readLine()) {
						result.add(line);
					}

					for (String list : result) {
						
						String[] resultList = list.split(" ");
						
						if(resultList[1].equals(LoginPage.job)) {
							resultList[3] = phone;
						    resultList[4] = address;
						}
						writer.write(String.format("%s %s %s %s %s%n", resultList[0], resultList[1], resultList[2],
								resultList[3], resultList[4], "\n"));
					}
					read.close();
					writer.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Saved");
				info.setVisible(true);
				info.setLocationRelativeTo(null);
				info.setResizable(false);
				setVisible(false);
			}
		});
		btnSave.setBackground(new Color(255, 255, 102));
		btnSave.setForeground(new Color(0, 204, 153));
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBounds(67, 167, 89, 23);
		panel_1.add(btnSave);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInfoPage infoPage = new MyInfoPage();
				infoPage.setVisible(true);
				infoPage.setLocationRelativeTo(null);
				infoPage.setResizable(false);
				setVisible(false);
			}
		});
		btnBack.setBackground(new Color(255, 255, 102));
		btnBack.setForeground(new Color(0, 204, 153));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(253, 168, 89, 23);
		panel_1.add(btnBack);
	}

}
