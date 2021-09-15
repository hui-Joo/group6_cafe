package manager.chart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import commonDB.DBClass;
import manager.commonMA.ManagerDTO;

public class Chart_DB {

	public ManagerDTO getTotalMenu() {
		String sql = "select * from \"MENUDB\"";
		ManagerDTO dto = null;
		
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new ManagerDTO();
				dto.setAmericano(rs.getInt("americano"));
				dto.setLatte(rs.getInt("latte"));
				dto.setCapucino(rs.getInt("capucino"));
				dto.setVanilaLatte(rs.getInt("vanilaLatte"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
