package manager.chart;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import manager.commonMA.ManagerDTO;

public class Chart_DB {

	ManagerDTO dto;
	
	public ManagerDTO getTotalMenu() {
		String sql = "select * from \"MENUDB\" where num=1";
		
		try {
			PreparedStatement ps = common.commonDB.DBClass.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new ManagerDTO();
				dto.setMenu_ice(rs.getInt("ice"));
				dto.setHot(rs.getInt("hot"));
				dto.setAmericano(rs.getInt("americano"));
				dto.setLatte(rs.getInt("latte"));
				dto.setCapucino(rs.getInt("cappuccino"));
				dto.setVanilaLatte(rs.getInt("vanilaLatte"));
				dto.setSmall(rs.getInt("small"));
				dto.setRegular(rs.getInt("regular"));
				dto.setLarge(rs.getInt("large"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
