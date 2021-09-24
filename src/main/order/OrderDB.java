package main.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.commonDB.DBClass;
import manager.commonMA.ManagerDTO;

public class OrderDB {
	
	ManagerDTO dto;
	
	public ManagerDTO setManagerDTO() {
		
		String sql = "select * from \"MENUDB\" where num=1";
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
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
	
	public int updateMenu(ManagerDTO dto, OrderDTO orderDto) {
		
		
		String sql = "update \"MENUDB\" set americano=?, latte=?, capucino=?, vanilaLatte=? where num=1";
		int result = 0;
		
		try {
			PreparedStatement ps = common.commonDB.DBClass.conn.prepareStatement(sql);
			ps.setInt(1, dto.getAmericano()+orderDto.getCntA());
			ps.setInt(2, dto.getLatte()+orderDto.getCntL());
			ps.setInt(3, dto.getCapucino() + orderDto.getCntC());
			ps.setInt(4, dto.getVanilaLatte() + orderDto.getCntV());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
