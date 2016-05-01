import java.sql.*;
import javax.swing.*;

public class sqlConnect 
{
	Connection conn=null;
	
	public static Connection dbConnector() throws ClassNotFoundException
	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:database.db");
			JOptionPane.showMessageDialog(null, "Connection to Database Successful");
			return conn;
		}
		catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
	}
}
