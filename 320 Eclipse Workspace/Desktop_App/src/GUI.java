import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager.*;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

import net.proteanit.sql.DbUtils;

import javax.swing.JPasswordField;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GUI {
//carriage return to login
	private String foodest,	inspector, date, violation;
	private boolean crit;
	private JFrame frame;
	private JPanel landingFrame, searchFrame, syncFrame, resultsFrame, loginFrame;
	private JTextField textFieldEstablishment;
	private JTextField textFieldDate;
	private JTextField textFieldInspector;
	private JTextField textFieldViolation;
	private JTextField txtfldLoginUsername;
	private JPasswordField passwordFieldLogin;
	private JTable tableEstablishment, tableDate, tableViolation, tableInspector, tableResults;
	private JScrollPane scrollPaneEstablishment, scrollPaneDate, scrollPaneViolation, scrollPaneInspector, scrollPaneResults;
	private JCheckBox chckbxCritical;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
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
		frame.setBounds(100, 100, 1900, 1000);
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
		lblHima.setBounds(761, 45, 358, 169);
		landingFrame.add(lblHima);
		
		JLabel lblHimaLong = new JLabel("Health Inspection Mobile Application");
		lblHimaLong.setFont(new Font("Tahoma", Font.PLAIN, 46));
		lblHimaLong.setBounds(557, 205, 750, 82);
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
						String query2="SELECT DISTINCT i.date FROM inspection i;";
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
						String query3="SELECT DISTINCT i.inspector FROM inspection i;";
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
						String query4="SELECT DISTINCT v.desc FROM violation v;";
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
		btnLandingSearch.setFont(new Font("SansSerif", Font.PLAIN, 66));
		btnLandingSearch.setBounds(587, 360, 696, 173);
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
		btnLandingSync.setFont(new Font("SansSerif", Font.PLAIN, 66));
		btnLandingSync.setBounds(587, 593, 696, 173);
		landingFrame.add(btnLandingSync);
		
		JButton btnLandingLogout = new JButton("Log Out");
		btnLandingLogout.setFont(new Font("Tahoma", Font.PLAIN, 42));
		btnLandingLogout.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				loginFrame.setVisible(true);
				landingFrame.setVisible(false);
			}
		});
		btnLandingLogout.setBounds(1628, 45, 206, 82);
		landingFrame.add(btnLandingLogout);
		
		JLabel lblEstablishment = new JLabel("Restaurant");
		lblEstablishment.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblEstablishment.setBounds(59, 20, 245, 68);
		searchFrame.add(lblEstablishment);
		
		JButton btnSearchSearch = new JButton("Search");
		btnSearchSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				foodest = textFieldEstablishment.getText();
				inspector = textFieldInspector.getText();
				date = textFieldDate.getText();
				violation = textFieldViolation.getText();
				crit = chckbxCritical.isSelected();
				//System.out.println("establishment: " + foodest  + ", inspector: " + inspector + ", date: " + date + ", violation: " + violation + ", crit: " + crit);
				
				String querySel = "SELECT i.iid, i.inspector, f.name, i.date, i.type, i.total_violation, i.re_required";
				String queryFrm = "FROM inspection i, food_establishment f, insp_to_est ie";
				String queryWhr = "WHERE ie.iid = i.iid AND ie.rid = f.rid";
				
				if (!foodest.equals("")) {
					queryWhr = queryWhr + " AND f.name = \"" + foodest + "\"";
				}
				if (!inspector.equals("")) {
					queryWhr = queryWhr + " AND i.inspector = \"" + inspector + "\"";
				}
				if (!date.equals("")) {
					queryWhr = queryWhr + " AND i.date = \"" + date + "\"";
				}
				if (!violation.equals("")) {
					queryFrm = queryFrm + ", violation v, vio_to_insp vi";
					queryWhr = queryWhr + " AND v.desc = \"" + violation + "\" AND vi.vid = v.vid AND vi.iid = i.iid";
				}
				if (crit != false) {
					queryWhr = queryWhr + " AND i.re_required = 1";
				}
				
				String query = querySel + " " + queryFrm + " " + queryWhr;
				
				try
				{
					//System.out.println(query);
					//Populate Results Table
					// String query="SELECT f.name, f.telephone, i.inspector, i.date, v.desc FROM food_establishment f, inspection i, violation v";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableResults.setModel(DbUtils.resultSetToTableModel(rs));
					
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
		btnSearchSearch.setFont(new Font("Tahoma", Font.PLAIN, 44));
		btnSearchSearch.setBounds(348, 894, 722, 59);
		searchFrame.add(btnSearchSearch);
		
		chckbxCritical = new JCheckBox("Reinspection Required");
		chckbxCritical.setFont(new Font("Tahoma", Font.PLAIN, 40));
		chckbxCritical.setBounds(1111, 885, 549, 59);
		searchFrame.add(chckbxCritical);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblDate.setBounds(68, 438, 194, 69);
		searchFrame.add(lblDate);
		
		JLabel lblViolation = new JLabel("Violation");
		lblViolation.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblViolation.setBounds(1039, 438, 234, 68);
		searchFrame.add(lblViolation);
		
		JLabel lblInspector = new JLabel("Inspector");
		lblInspector.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblInspector.setBounds(1039, 20, 234, 68);
		searchFrame.add(lblInspector);
		
		textFieldEstablishment = new JTextField();
		textFieldEstablishment.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldEstablishment.setBounds(169, 380, 673, 45);
		searchFrame.add(textFieldEstablishment);
		textFieldEstablishment.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Find:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel.setBounds(56, 377, 101, 48);
		searchFrame.add(lblNewLabel);
		
		textFieldDate = new JTextField();
		textFieldDate.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(158, 799, 673, 45);
		searchFrame.add(textFieldDate);
		
		JLabel label_1 = new JLabel("Find:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		label_1.setBounds(59, 799, 101, 45);
		searchFrame.add(label_1);
		
		textFieldInspector = new JTextField();
		textFieldInspector.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldInspector.setColumns(10);
		textFieldInspector.setBounds(1139, 375, 683, 45);
		searchFrame.add(textFieldInspector);
		
		JLabel label_2 = new JLabel("Find:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		label_2.setBounds(1039, 374, 125, 45);
		searchFrame.add(label_2);
		
		textFieldViolation = new JTextField();
		textFieldViolation.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textFieldViolation.setColumns(10);
		textFieldViolation.setBounds(1139, 790, 683, 45);
		searchFrame.add(textFieldViolation);
		
		JLabel label_3 = new JLabel("Find:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 32));
		label_3.setBounds(1039, 792, 88, 38);
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
		btnSearchReturn.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSearchReturn.setBounds(1612, 20, 234, 59);
		searchFrame.add(btnSearchReturn);
		
		scrollPaneEstablishment = new JScrollPane();
		scrollPaneEstablishment.setBounds(59, 101, 783, 261);
		searchFrame.add(scrollPaneEstablishment);
		
		tableEstablishment = new JTable();
		scrollPaneEstablishment.setViewportView(tableEstablishment);
		tableEstablishment.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		scrollPaneInspector = new JScrollPane();
		scrollPaneInspector.setBounds(1039, 101, 783, 260);
		searchFrame.add(scrollPaneInspector);
		
		tableInspector = new JTable();
		scrollPaneInspector.setViewportView(tableInspector);
		tableInspector.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		scrollPaneDate = new JScrollPane();
		scrollPaneDate.setBounds(69, 519, 762, 261);
		searchFrame.add(scrollPaneDate);
		
		tableDate = new JTable();
		scrollPaneDate.setViewportView(tableDate);
		tableDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		scrollPaneViolation = new JScrollPane();
		scrollPaneViolation.setBounds(1039, 519, 783, 260);
		searchFrame.add(scrollPaneViolation);
		
		tableViolation = new JTable();
		scrollPaneViolation.setViewportView(tableViolation);
		tableViolation.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnClear = new JButton("Clear Data");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				textFieldEstablishment.setText("");
				textFieldInspector.setText("");
				textFieldDate.setText("");
				textFieldViolation.setText("");
				chckbxCritical.setSelected(false);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 44));
		btnClear.setBounds(12, 894, 306, 59);
		searchFrame.add(btnClear);
		
		
		//************************SearchPanel's Four JTable mouse listeners:*****************
				//tableEstablishment, tableDate, tableViolation, tableInspector
				tableEstablishment.addMouseListener(new java.awt.event.MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(java.awt.event.MouseEvent evt) 
				    {
				        textFieldEstablishment.setText((String) tableEstablishment.getValueAt(tableEstablishment.rowAtPoint(evt.getPoint()), tableEstablishment.columnAtPoint(evt.getPoint())));
				    }
				});

				tableDate.addMouseListener(new java.awt.event.MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(java.awt.event.MouseEvent evt) 
				    {
				        textFieldDate.setText((String) tableDate.getValueAt(tableDate.rowAtPoint(evt.getPoint()), tableDate.columnAtPoint(evt.getPoint())));
				    }
				});
				
				tableViolation.addMouseListener(new java.awt.event.MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(java.awt.event.MouseEvent evt) 
				    {
				        textFieldViolation.setText((String) tableViolation.getValueAt(tableViolation.rowAtPoint(evt.getPoint()), tableViolation.columnAtPoint(evt.getPoint())));
				    }
				});
				
				tableInspector.addMouseListener(new java.awt.event.MouseAdapter() 
				{
				    @Override
				    public void mouseClicked(java.awt.event.MouseEvent evt) 
				    {
				        textFieldInspector.setText((String) tableInspector.getValueAt(tableInspector.rowAtPoint(evt.getPoint()), tableInspector.columnAtPoint(evt.getPoint())));
				    }
				});
		
		
		JLabel lblSyncingToMobile = new JLabel("Syncing to Mobile Device");
		lblSyncingToMobile.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblSyncingToMobile.setBounds(536, 121, 866, 336);
		syncFrame.add(lblSyncingToMobile);
		
		JLabel label = new JLabel("...");
		label.setFont(new Font("Tahoma", Font.PLAIN, 96));
		label.setBounds(889, 420, 173, 96);
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
		btnSyncCancel.setBounds(853, 675, 199, 77);
		syncFrame.add(btnSyncCancel);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Dialog", Font.PLAIN, 82));
		lblResults.setBounds(792, 13, 330, 142);
		resultsFrame.add(lblResults);
		
		JLabel lblResultsMatching = new JLabel("Results matching searched criteria:");
		lblResultsMatching.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblResultsMatching.setBounds(706, 164, 504, 62);
		resultsFrame.add(lblResultsMatching);
		
		JButton btnResultsReturn = new JButton("Return");
		btnResultsReturn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				foodest = textFieldEstablishment.getText();
				inspector = textFieldInspector.getText();
				date = textFieldDate.getText();
				violation = textFieldViolation.getText();
				crit = chckbxCritical.isSelected();
				//System.out.println("establishment: " + foodest  + ", inspector: " + inspector + ", date: " + date + ", violation: " + violation + ", crit: " + crit);
				
				String querySel = "SELECT i.iid, i.inspector, f.name, i.date, i.type, i.total_violation, i.re_required";
				String queryFrm = "FROM inspection i, food_establishment f, insp_to_est ie";
				String queryWhr = "WHERE ie.iid = i.iid AND ie.rid = f.rid";
				
				if (foodest != "") {
					queryWhr = queryWhr + " AND f.name = \"" + foodest + "\"";
				}
				if (inspector != "") {
					queryWhr = queryWhr + " AND i.inspector = \"" + inspector + "\"";
				}
				if (date != "") {
					queryWhr = queryWhr + " AND i.date = \"" + date + "\"";
				}
				if (violation != "") {
					queryFrm = queryFrm + ", violation v, vio_to_insp vi";
					queryWhr = queryWhr + " AND v.desc = \"" + violation + "\" AND vi.vid = v.vid AND vi.iid = i.iid";
				}
				if (crit != false) {
					queryWhr = queryWhr + " AND i.re_required = 1";
				}
				
				String query = querySel + " " + queryFrm + " " + queryWhr;
				
				try
				{
					//Populate Results Table
					// String query="SELECT f.name, f.telephone, i.inspector, i.date, v.desc FROM food_establishment f, inspection i, violation v";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableResults.setModel(DbUtils.resultSetToTableModel(rs));
					
					rs.close();
					pst.close();
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
				}
				
				searchFrame.setVisible(true);
				resultsFrame.setVisible(false);
			}
		});
		btnResultsReturn.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnResultsReturn.setBounds(766, 822, 362, 102);
		resultsFrame.add(btnResultsReturn);
		
		JButton btnDownloadPdf = new JButton("Download PDF");
		btnDownloadPdf.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDownloadPdf.setBounds(1564, 252, 275, 62);
		resultsFrame.add(btnDownloadPdf);
		
		JButton btnEmail1 = new JButton("Email");
		btnEmail1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnEmail1.setBounds(1564, 339, 275, 62);
		resultsFrame.add(btnEmail1);
		
		scrollPaneResults = new JScrollPane();
		scrollPaneResults.setBounds(393, 252, 1100, 519);
		resultsFrame.add(scrollPaneResults);
		
		tableResults = new JTable();
		scrollPaneResults.setViewportView(tableResults);
		tableResults.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblLoginHimaTitle = new JLabel("H.I.M.A. Login");
		lblLoginHimaTitle.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblLoginHimaTitle.setBounds(705, 69, 560, 220);
		loginFrame.add(lblLoginHimaTitle);
		
		JLabel lblLoginUsername = new JLabel("Username");
		lblLoginUsername.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblLoginUsername.setBounds(679, 302, 193, 72);
		loginFrame.add(lblLoginUsername);
		
		txtfldLoginUsername = new JTextField();
		txtfldLoginUsername.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtfldLoginUsername.setBounds(679, 387, 475, 62);
		loginFrame.add(txtfldLoginUsername);
		txtfldLoginUsername.setColumns(10);
		
		JLabel lblLoginPassword = new JLabel("Password");
		lblLoginPassword.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblLoginPassword.setBounds(679, 495, 193, 72);
		loginFrame.add(lblLoginPassword);
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passwordFieldLogin.setBounds(679, 580, 485, 62);
		loginFrame.add(passwordFieldLogin);
		
		JButton btnLoginLogin = new JButton("Login");
		btnLoginLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					//looking for help from paul here for username authentication
					String user = txtfldLoginUsername.getText();
					String password = passwordFieldLogin.getText();
					String query="SELECT u.pass FROM user u WHERE user = \"" + user + "\"";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					// Salt and Hash
					password = password + "GwxH0kv50#Jo%QyDLff#BT9n9L5PmuUj";
					MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
					messageDigest.update(password.getBytes());
					String encryptedString = new String(messageDigest.digest());
					
					try {
						if (!rs.next()) {
							JOptionPane.showMessageDialog(null, "User: \"" + user + "\" doesn't exist!");
						}
					} catch (SQLException ex5) {
						ex5.printStackTrace();
					}
					
					// Check if password hashes match
					try {
						if (rs.getString(1).equals(encryptedString)) {
							JOptionPane.showMessageDialog(null, "User authenticated");
							loginFrame.setVisible(false);
							landingFrame.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "User found, wrong password");
						}
					} catch (SQLException ex6) {
						ex6.printStackTrace();
					}
					
					rs.close();
					pst.close();
				}
				catch (Exception x)
				{
					JOptionPane.showMessageDialog(null, x);
				}
			}
		});
		btnLoginLogin.setFont(new Font("Tahoma", Font.PLAIN, 42));
		btnLoginLogin.setBounds(705, 713, 432, 102);
		loginFrame.add(btnLoginLogin);
	}
}
