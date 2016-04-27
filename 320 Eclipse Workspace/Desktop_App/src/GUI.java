import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class GUI {

	private JFrame frame;
	private JPanel landingFrame, searchFrame, syncFrame, resultsFrame, loginFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtRestaurant;
	private JTextField txtfldLoginUsername;
	private JPasswordField passwordFieldLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1069, 738);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		//all the frames below
		landingFrame = new JPanel();
		frame.getContentPane().add(landingFrame, "name_383423057927825");
		landingFrame.setLayout(null);
		//set visible
		landingFrame.setVisible(false);
		
		searchFrame = new JPanel();
		frame.getContentPane().add(searchFrame, "name_383437413698620");
		searchFrame.setLayout(null);
		//set visible
		searchFrame.setVisible(false);
		
		syncFrame = new JPanel();
		frame.getContentPane().add(syncFrame, "name_383440436424780");
		syncFrame.setLayout(null);
		//set visible
		syncFrame.setVisible(false);
		
		resultsFrame = new JPanel();
		frame.getContentPane().add(resultsFrame, "name_429943713179041");
		resultsFrame.setLayout(null);
		//set visible
		syncFrame.setVisible(false);
		
		loginFrame = new JPanel();
		frame.getContentPane().add(loginFrame, "name_13525621333437");
		loginFrame.setLayout(null);
		//set visible
		loginFrame.setVisible(true);
		
		JLabel lblHima = new JLabel("H.I.M.A.");
		lblHima.setFont(new Font("Tahoma", Font.PLAIN, 98));
		lblHima.setBounds(350, 45, 358, 169);
		landingFrame.add(lblHima);
		
		JLabel lblHimaLong = new JLabel("Health Inspection Mobile Application");
		lblHimaLong.setFont(new Font("Tahoma", Font.PLAIN, 46));
		lblHimaLong.setBounds(152, 203, 750, 82);
		landingFrame.add(lblHimaLong);
		
		JButton btnLandingSearch = new JButton("Search Inspections");
		btnLandingSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				landingFrame.setVisible(false);
				searchFrame.setVisible(true);
			}
		});
		btnLandingSearch.setFont(new Font("SansSerif", Font.PLAIN, 56));
		btnLandingSearch.setBounds(229, 326, 596, 134);
		landingFrame.add(btnLandingSearch);
		
		JButton btnLandingSync = new JButton("Sync");
		btnLandingSync.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				syncFrame.setVisible(true);
				landingFrame.setVisible(false);
			}
		});
		btnLandingSync.setFont(new Font("SansSerif", Font.PLAIN, 56));
		btnLandingSync.setBounds(229, 518, 596, 134);
		landingFrame.add(btnLandingSync);
		
		JButton btnLandingLogout = new JButton("Logout");
		btnLandingLogout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				loginFrame.setVisible(true);
				landingFrame.setVisible(false);
			}
		});
		btnLandingLogout.setBounds(872, 45, 118, 69);
		landingFrame.add(btnLandingLogout);
		
		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRestaurant.setBounds(59, 27, 443, 59);
		searchFrame.add(lblRestaurant);
		
		JButton btnSearchSearch = new JButton("Search");
		btnSearchSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				searchFrame.setVisible(false);
				resultsFrame.setVisible(true);
			}
		});
		btnSearchSearch.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnSearchSearch.setBounds(114, 590, 558, 73);
		searchFrame.add(btnSearchSearch);
		
		JCheckBox chckbxCritical = new JCheckBox("Critical");
		chckbxCritical.setFont(new Font("Tahoma", Font.PLAIN, 28));
		chckbxCritical.setBounds(717, 597, 225, 59);
		searchFrame.add(chckbxCritical);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDate.setBounds(59, 285, 443, 59);
		searchFrame.add(lblDate);
		
		JLabel lblViolation = new JLabel("Violation");
		lblViolation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblViolation.setBounds(543, 285, 443, 59);
		searchFrame.add(lblViolation);
		
		JLabel lblInspector = new JLabel("Inspector");
		lblInspector.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblInspector.setBounds(543, 27, 443, 59);
		searchFrame.add(lblInspector);
		
		JTextArea txtrMcdonalds = new JTextArea();
		txtrMcdonalds.setText("McDonalds\r\nWendy's\r\nRoots Cafe\r\nWorcester Dining Common\r\nRoute 9 Diner");
		txtrMcdonalds.setBounds(69, 99, 391, 158);
		searchFrame.add(txtrMcdonalds);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("1/15/15\r\n2/25/15\r\n8/8/15\r\n2/1/16\r\n4/10/16");
		textArea.setBounds(69, 357, 391, 158);
		searchFrame.add(textArea);
		
		JTextArea txtrSteveSteveNot = new JTextArea();
		txtrSteveSteveNot.setText("Steve\r\nSteve\r\nNot Steve\r\nSteve\r\nSteve");
		txtrSteveSteveNot.setBounds(543, 99, 391, 158);
		searchFrame.add(txtrSteveSteveNot);
		
		JTextArea txtrSmellyPotatoesBirds = new JTextArea();
		txtrSmellyPotatoesBirds.setText("Smelly Potatoes\r\nBirds living in bread drawer\r\nGreen mac n' cheese\r\nManager didn't wear deoderant: terrible odor\r\nRat poop. Rat poop everywhere");
		txtrSmellyPotatoesBirds.setBounds(543, 357, 391, 158);
		searchFrame.add(txtrSmellyPotatoesBirds);
		
		textField = new JTextField();
		textField.setBounds(179, 270, 278, 22);
		searchFrame.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Find:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(79, 270, 88, 22);
		searchFrame.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(182, 528, 278, 22);
		searchFrame.add(textField_1);
		
		JLabel label_1 = new JLabel("Find:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(82, 528, 88, 22);
		searchFrame.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(653, 270, 278, 22);
		searchFrame.add(textField_2);
		
		JLabel label_2 = new JLabel("Find:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(553, 270, 88, 22);
		searchFrame.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(653, 528, 278, 22);
		searchFrame.add(textField_3);
		
		JLabel label_3 = new JLabel("Find:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(553, 528, 88, 22);
		searchFrame.add(label_3);
		
		JButton btnSearchReturn = new JButton("Main Menu");
		btnSearchReturn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				searchFrame.setVisible(false);
				landingFrame.setVisible(true);
			}
		});
		btnSearchReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearchReturn.setBounds(847, 13, 139, 43);
		searchFrame.add(btnSearchReturn);
		
		JLabel lblSyncingToMobile = new JLabel("Syncing to Mobile Device");
		lblSyncingToMobile.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblSyncingToMobile.setBounds(153, 119, 866, 336);
		syncFrame.add(lblSyncingToMobile);
		
		JLabel label = new JLabel("...");
		label.setFont(new Font("Tahoma", Font.PLAIN, 96));
		label.setBounds(475, 395, 338, 96);
		syncFrame.add(label);
		
		JButton btnSyncCancel = new JButton("Cancel");
		btnSyncCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				syncFrame.setVisible(false);
				landingFrame.setVisible(true);
			}
		});
		btnSyncCancel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnSyncCancel.setBounds(422, 527, 199, 77);
		syncFrame.add(btnSyncCancel);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Dialog", Font.PLAIN, 70));
		lblResults.setBounds(365, 33, 269, 123);
		resultsFrame.add(lblResults);
		
		JLabel lblResultsMatching = new JLabel("6 results matching searched criteria:");
		lblResultsMatching.setBounds(375, 144, 222, 27);
		resultsFrame.add(lblResultsMatching);
		
		JTextArea txtrRootsCafe = new JTextArea();
		txtrRootsCafe.setText("Roots Cafe       Steve        1/19/13     Stinky Stuff\r\n\r\nRoots Cafe       Steve        5/28/14     Rabid guinea pig loose in fries\r\n\r\nRoots Cafe       Steve        9/14/15     Manager left his hairnet in the break room\r\n\r\nRoots Cafe       Steve        2/8/16      Emloyee didn't wash hands");
		txtrRootsCafe.setBounds(90, 234, 692, 362);
		resultsFrame.add(txtrRootsCafe);
		
		txtRestaurant = new JTextField();
		txtRestaurant.setText("Restaurant\t             Inspector             Date                 Violation");
		txtRestaurant.setBounds(90, 211, 692, 22);
		resultsFrame.add(txtRestaurant);
		txtRestaurant.setColumns(10);
		
		JButton btnResultsReturn = new JButton("Return");
		btnResultsReturn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				resultsFrame.setVisible(false);
				searchFrame.setVisible(true);
			}
		});
		btnResultsReturn.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnResultsReturn.setBounds(365, 609, 269, 54);
		resultsFrame.add(btnResultsReturn);
		
		JButton btnDownloadPdf = new JButton("Download PDF");
		btnDownloadPdf.setBounds(794, 233, 131, 25);
		resultsFrame.add(btnDownloadPdf);
		
		JButton button = new JButton("Download PDF");
		button.setBounds(794, 271, 131, 25);
		resultsFrame.add(button);
		
		JButton button_1 = new JButton("Download PDF");
		button_1.setBounds(794, 309, 131, 25);
		resultsFrame.add(button_1);
		
		JButton button_2 = new JButton("Download PDF");
		button_2.setBounds(794, 347, 131, 25);
		resultsFrame.add(button_2);
		
		JLabel lblLoginHimaTitle = new JLabel("H.I.M.A. Login");
		lblLoginHimaTitle.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblLoginHimaTitle.setBounds(303, 48, 429, 163);
		loginFrame.add(lblLoginHimaTitle);
		
		JLabel lblLoginUsername = new JLabel("Username");
		lblLoginUsername.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLoginUsername.setBounds(303, 237, 134, 53);
		loginFrame.add(lblLoginUsername);
		
		txtfldLoginUsername = new JTextField();
		txtfldLoginUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtfldLoginUsername.setBounds(303, 303, 394, 45);
		loginFrame.add(txtfldLoginUsername);
		txtfldLoginUsername.setColumns(10);
		
		JLabel lblLoginPassword = new JLabel("Password");
		lblLoginPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLoginPassword.setBounds(303, 385, 134, 53);
		loginFrame.add(lblLoginPassword);
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setBounds(313, 451, 380, 45);
		loginFrame.add(passwordFieldLogin);
		
		JButton btnLoginLogin = new JButton("Login");
		btnLoginLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				loginFrame.setVisible(false);
				landingFrame.setVisible(true);
			}
		});
		btnLoginLogin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnLoginLogin.setBounds(382, 563, 250, 62);
		loginFrame.add(btnLoginLogin);
	}
}