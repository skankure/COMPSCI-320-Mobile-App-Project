import java.sql.*;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashChecker {

	public static void main(String[] args) throws NoSuchAlgorithmException, ClassNotFoundException {
		// Obtain authentication information
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter username:");
		String user = scan.nextLine();
		System.out.println("Enter password:");
		String password = scan.nextLine();
		scan.close();

		// Salt and Hash
		password = password + "GwxH0kv50#Jo%QyDLff#BT9n9L5PmuUj";
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(password.getBytes());
		String encryptedString = new String(messageDigest.digest());

		// Get password hash
		Statement q = SqliteConnection.dbConnect();
		ResultSet rs;
		try {
			rs = q.executeQuery("SELECT u.pass FROM user u WHERE user = \"" + user + "\"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Query is invalid");
			return;
		}
		
		// Check if user exists
		try {
			if (!rs.next()) {
				System.out.println("User: " + user + " doesn't exist!");
				System.exit(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Check if password hashes match
		try {
			if (rs.getString(1).equals(encryptedString)) {
				System.out.println(true);
			}
			else {
				System.out.println(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
