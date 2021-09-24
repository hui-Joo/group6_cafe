package main.order;

import java.sql.PreparedStatement;

import common.commonDB.DBClass;
import manager.commonMA.ManagerDTO;

public class OrderDB {
	
	//ManagerDTO dto;
	
	public int updateMenu(ManagerDTO managerDto, OrderDTO orderDto) {
		
		//dto = new ManagerDTO();
		
		String sql = "update \"MENUDB\" set americano=?, latte=?, capucino=?, vanilaLatte=? where num=1";
		int result = 0;
		
		try {
			PreparedStatement ps = common.commonDB.DBClass.conn.prepareStatement(sql);
			ps.setInt(1, orderDto.getCntA());
			ps.setInt(2, orderDto.getCntL());
			ps.setInt(3, orderDto.getCntC());
			ps.setInt(4, orderDto.getCntV());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
