import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultTest {

	public static void main(String[] args) throws ClassNotFoundException {
		String foodest = "Baby Berk";
		String inspector = "Steve Inspector";
		String date = null;
		String violation = null;
		boolean crit = false;
		
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
		
		System.out.println(query);
		/*
		Statement q = SqliteConnection.dbConnect();
		ResultSet rs;
		try {
			rs = q.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query is invalid");
			return;
		}
		*/
	}

}
