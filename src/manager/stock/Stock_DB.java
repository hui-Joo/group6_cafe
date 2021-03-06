package manager.stock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import common.commonDB.DBClass;
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
				dto.setStock_ice(rs.getInt("ice"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public int update(ManagerDTO dto) {
		int result = 0;

		String sql = "update STOCKDB set bean=?,water=?,milk=?,vanilasyrup=?,ice=? where num=1 ";

		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setInt(1, dto.getBean());
			ps.setInt(2, dto.getWater());
			ps.setInt(3, dto.getMilk());
			ps.setInt(4, dto.getVanilaSyrup());
			ps.setInt(5, dto.getStock_ice());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
