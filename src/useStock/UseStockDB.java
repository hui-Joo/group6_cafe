package useStock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.commonDB.DBClass;
import manager.commonMA.ManagerDTO;

public class UseStockDB {
	ManagerDTO dto;

	public ManagerDTO selectstock() {
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
	
	public int update(ManagerDTO dto) {
		int result = 0;

		String sql = "update STOCKDB set bean=?,water=?,milk=?,vanilasyrup=? where num=1 ";

		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setInt(1, dto.getBean());
			ps.setInt(2, dto.getWater());
			ps.setInt(3, dto.getMilk());
			ps.setInt(4, dto.getVanilaSyrup());

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
