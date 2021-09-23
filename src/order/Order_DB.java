package order;

import java.sql.PreparedStatement;

import manager.commonMA.ManagerDTO;

public class Order_DB {
	OrderDTO od = new OrderDTO();
	public int update(ManagerDTO dto){
		
		String sql = "update \"MENUDB\" set americano=?, latte=?, capucino=?, vanillaLatte=? where num=1";
		int result = 0;
		 
		try {
			PreparedStatement ps = common.commonDB.DBClass.conn.prepareStatement(sql);
			ps.setInt(1, od.getAmericano());
			ps.setInt(2, od.getLatte());
			ps.setInt(3, od.getCapuccino());
			ps.setInt(4, od.getVanilaLatte());
			
			result = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
}
