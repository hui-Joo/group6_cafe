package commonDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBClass {

	public static Connection conn;
	
	public DBClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@210.221.253.215:1521:xe", "group6", "group6");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
