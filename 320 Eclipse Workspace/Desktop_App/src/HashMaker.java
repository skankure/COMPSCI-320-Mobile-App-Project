import java.sql.*;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMaker {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchAlgorithmException {
		// Obtain authentication information
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter new username:");
		String user = scan.nextLine();
		System.out.println("Enter new password:");
		String password = scan.nextLine();
		scan.close();
		
		// Salt and Hash
		password = password + "GwxH0kv50#Jo%QyDLff#BT9n9L5PmuUj";
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(password.getBytes());
		String encryptedString = new String(messageDigest.digest());
		
		// Insert new user to database
		Statement q = SqliteConnection.dbConnect();
		try {
			q.execute("INSERT INTO user(user, pass) VALUES (\"" + user + "\", \"" + encryptedString + "\")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Query is invalid");
			return;
		}
	}

}
