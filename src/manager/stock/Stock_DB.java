package manager.stock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commonDB.DBClass;
import manager.commonMA.ManagerDTO;

public class Stock_DB {
	ManagerDTO dto;

	public ManagerDTO selectstock() {
//		"SELECT * FROM (SELECT * FROM STOCKDB ORDER BY ROWNUM DESC)"
//				+ "WHERE ROWNUM = 1";
		String sql = "select * from STOCKDB";
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new ManagerDTO();
				dto.setBean(rs.getInt("bean"));
				dto.setWater(rs.getInt("water"));
				dto.setMilk(rs.getInt("milk"));
				dto.setVanilaSyrup(rs.getInt("vanilaSyrup"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public int insertbean(int mg) {
		String sql = "insert into STOCKDB(bean) values(?)";
		int result = 0;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setInt(1, mg);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int insertwater(int mg) {
		String sql = "insert into STOCKDB(water) values(?)";
		int result = 0;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setInt(1, mg);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int insertmilk(int mg) {
		String sql = "insert into STOCKDB(milk) values(?)";
		int result = 0;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setInt(1, mg);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int insertvanila(int mg) {
		String sql = "insert into STOCKDB(vanilaSyrup) values(?)";
		int result = 0;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setInt(1, mg);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
