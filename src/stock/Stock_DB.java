package stock;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import commonDB.DBClass;
import manager.commonMA.ManagerDTO;

public class Stock_DB {

	public ManagerDTO selectstock() {
		ManagerDTO dto = null;
		String sql = "select * from STOCKDB";
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new ManagerDTO();
				dto.setBean(rs.getInt("bean"));
				dto.setMilk(rs.getInt("milk"));
				dto.setWater(rs.getInt("water"));
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
			ps.setInt(1,mg);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
