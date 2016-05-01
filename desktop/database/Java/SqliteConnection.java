import java.sql.*;

public class SqliteConnection {

    Connection conn = null;

    public static Statement dbConnect() throws ClassNotFoundException{
    	
    	Class.forName("org.sqlite.JDBC");
    	
    	// Phase 1: Create connection to database
    	Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch(SQLException e) {
            System.out.println("Error connecting to SQLite Database!");
            return null;
        }
        
        // Phase 2: Create statement to run queries on
        Statement query = null;
        try {
			query = conn.createStatement();
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
}