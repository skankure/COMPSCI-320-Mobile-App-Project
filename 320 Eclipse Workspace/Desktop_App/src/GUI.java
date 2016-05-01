import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JPasswordField;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;

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
	private JTable tableEstablishment, tableDate, tableViolation, tableInspector, tableResults;
	private JScrollPane scrollPaneEstablishment, scrollPaneDate, scrollPaneViolation, scrollPaneInspector, scrollPaneResults;

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

	
	//connect to the database
	Connection connection=null;
	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public GUI() throws ClassNotFoundException {
		initialize();
		connection=sqlConnect.dbConnector();
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
				//looking for help from paul here
				
				//Establishment
				try
					{
						//Populate Food Establishment Table
						String query1="SELECT f.name FROM food_establishment f";
						PreparedStatement pst1=connection.prepareStatement(query1);
						ResultSet rs1 = pst1.executeQuery();
						tableEstablishment.setModel(DbUtils.resultSetToTableModel(rs1));
						
						//close establishment stuff
						rs1.close();
						pst1.close();
					}
				catch (Exception ex1)
					{
						JOptionPane.showMessageDialog(null, ex1);
					}
				
				//date
				try
					{
						//Populate Date Table
						String query2="SELECT DISTINCT i.date FROM inspection i; (Format YYYY-MM-DD HH:MM:SS)";
						PreparedStatement pst2=connection.prepareStatement(query2);
						ResultSet rs2 = pst2.executeQuery();
						tableDate.setModel(DbUtils.resultSetToTableModel(rs2));
						
						//close date stuff
						rs2.close();
						pst2.close();
					}
				catch (Exception ex2)
					{
						JOptionPane.showMessageDialog(null, ex2);
					}
				
				//inspector
				try
					{
						//Populate Inspector Table
						String query3="SELECT f.name FROM food_establishment f";
						PreparedStatement pst3=connection.prepareStatement(query3);
						ResultSet rs3 = pst3.executeQuery();
						tableInspector.setModel(DbUtils.resultSetToTableModel(rs3));
						
						//close inspector stuff
						rs3.close();
						pst3.close();
					}
				catch (Exception ex3)
					{
						JOptionPane.showMessageDialog(null, ex3);
					}
				
				//violation
				try
					{
						//Populate Violation Table
						String query4="SELECT f.name FROM food_establishment f";
						PreparedStatement pst4=connection.prepareStatement(query4);
						ResultSet rs4 = pst4.executeQuery();
						tableViolation.setModel(DbUtils.resultSetToTableModel(rs4));
						
						//close violation stuff
						rs4.close();
						pst4.close();
					}
				catch (Exception ex4)
					{
						JOptionPane.showMessageDialog(null, ex4);
					}
					
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
				try
				{
					//Populate Results Table
					String query="SELECT f.name, f.telephone, i.inspector, i.date, v.desc FROM food_establishment f";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableViolation.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
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
		
		scrollPaneEstablishment = new JScrollPane();
		scrollPaneEstablishment.setBounds(69, 99, 391, 158);
		searchFrame.add(scrollPaneEstablishment);
		
		tableEstablishment = new JTable();
		scrollPaneEstablishment.setViewportView(tableEstablishment);
		
		scrollPaneInspector = new JScrollPane();
		scrollPaneInspector.setBounds(553, 99, 389, 158);
		searchFrame.add(scrollPaneInspector);
		
		tableInspector = new JTable();
		scrollPaneInspector.setViewportView(tableInspector);
		
		scrollPaneDate = new JScrollPane();
		scrollPaneDate.setBounds(69, 357, 388, 158);
		searchFrame.add(scrollPaneDate);
		
		tableDate = new JTable();
		scrollPaneDate.setViewportView(tableDate);
		
		scrollPaneViolation = new JScrollPane();
		scrollPaneViolation.setBounds(543, 357, 399, 158);
		searchFrame.add(scrollPaneViolation);
		
		tableViolation = new JTable();
		scrollPaneViolation.setViewportView(tableViolation);
		
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
				//Establishment
				try
					{
						//Populate Food Establishment Table
						String query1="SELECT f.name FROM food_establishment f";
						PreparedStatement pst1=connection.prepareStatement(query1);
						ResultSet rs1 = pst1.executeQuery();
						tableEstablishment.setModel(DbUtils.resultSetToTableModel(rs1));
						
						//close establishment stuff
						rs1.close();
						pst1.close();
					}
				catch (Exception ex1)
					{
						JOptionPane.showMessageDialog(null, ex1);
					}
				
				//date
				try
					{
						//Populate Date Table
						String query2="SELECT DISTINCT i.date FROM inspection i; (Format YYYY-MM-DD HH:MM:SS)";
						PreparedStatement pst2=connection.prepareStatement(query2);
						ResultSet rs2 = pst2.executeQuery();
						tableDate.setModel(DbUtils.resultSetToTableModel(rs2));
						
						//close date stuff
						rs2.close();
						pst2.close();
					}
				catch (Exception ex2)
					{
						JOptionPane.showMessageDialog(null, ex2);
					}
				
				//inspector
				try
					{
						//Populate Inspector Table
						String query3="SELECT f.name FROM food_establishment f";
						PreparedStatement pst3=connection.prepareStatement(query3);
						ResultSet rs3 = pst3.executeQuery();
						tableInspector.setModel(DbUtils.resultSetToTableModel(rs3));
						
						//close inspector stuff
						rs3.close();
						pst3.close();
					}
				catch (Exception ex3)
					{
						JOptionPane.showMessageDialog(null, ex3);
					}
				
				//violation
				try
					{
						//Populate Violation Table
						String query4="SELECT f.name FROM food_establishment f";
						PreparedStatement pst4=connection.prepareStatement(query4);
						ResultSet rs4 = pst4.executeQuery();
						tableViolation.setModel(DbUtils.resultSetToTableModel(rs4));
						
						//close violation stuff
						rs4.close();
						pst4.close();
					}
				catch (Exception ex4)
					{
						JOptionPane.showMessageDialog(null, ex4);
					}
				
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
		
		JButton btnEmail1 = new JButton("Email");
		btnEmail1.setBounds(937, 233, 63, 25);
		resultsFrame.add(btnEmail1);
		
		JButton buttonEmail2 = new JButton("Email");
		buttonEmail2.setBounds(937, 271, 63, 25);
		resultsFrame.add(buttonEmail2);
		
		JButton buttonEmail3 = new JButton("Email");
		buttonEmail3.setBounds(937, 309, 63, 25);
		resultsFrame.add(buttonEmail3);
		
		JButton buttonEmail4 = new JButton("Email");
		buttonEmail4.setBounds(937, 347, 63, 25);
		resultsFrame.add(buttonEmail4);
		
		scrollPaneResults = new JScrollPane();
		scrollPaneResults.setBounds(90, 232, 692, 364);
		resultsFrame.add(scrollPaneResults);
		
		tableResults = new JTable();
		scrollPaneResults.setViewportView(tableResults);
		
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
				try
				{
					//looking for help from paul here for username authentication
					String query="";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, txtfldLoginUsername.getText());
					pst.setString(2, passwordFieldLogin.getText());
					
					ResultSet rs = pst.executeQuery();
					int count=0;
					while (rs.next())
					{
						count++;
						
						if(count == 1)
						{
							JOptionPane.showMessageDialog(null, "Username and password is correct");
						}
						else if(count >= 1)
						{
							JOptionPane.showMessageDialog(null, "Duplicate Username and password");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Invalid Username and password");
						}
					}
					
					rs.close();
					pst.close();
				}
				catch (Exception x)
				{
					JOptionPane.showMessageDialog(null, x);
				}
				loginFrame.setVisible(false);
				landingFrame.setVisible(true);
			}
		});
		btnLoginLogin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnLoginLogin.setBounds(382, 563, 250, 62);
		loginFrame.add(btnLoginLogin);
	}
}
