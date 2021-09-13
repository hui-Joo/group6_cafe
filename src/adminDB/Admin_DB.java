package adminDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin_DB {
	Connection con;
	PreparedStatement pstmt;

	public Admin_DB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:210.221.253.215:1521:xe", "group6", "group6");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jun", "wnsah12");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insert() {
		String sql = "insert into MANAGER(WATER) values(?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1000);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void select() {
		String sql = "select * from MANAGER";
		try {
			pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int ww =rs.getInt("WATER");
				System.out.println(ww);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
