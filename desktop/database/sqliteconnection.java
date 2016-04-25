import java.sql.*;

public class sqliteconnection {

    Connection conn = null;

    public static Connection dbConnect(){

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/Andrew/Desktop/HIMA/CS320/desktop/database/database.db");
            return conn;
        } catch {
            System.out.println("Error connecting to SQLite Database!");
            return null;
        }
    }
}