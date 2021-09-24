package main.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.commonDB.DBClass;

public class LoginDB {
	LoginDTO dto;

	public LoginDTO selectPw() {
		String sql = "select * from ADMINDB";
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new LoginDTO();
				dto.setPw(rs.getString("PASS"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
