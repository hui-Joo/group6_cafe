package main.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.commonDB.DBClass;
import manager.commonMA.ManagerDTO;

public class OrderDB {
	
	OrderDTO orderDto ;
	ManagerDTO dto = OrderDTO.dto;
	int beanI;
	
	
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
				
				OrderDTO.dto = dto;

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public ManagerDTO selectStock() {
		String sql = "select * from STOCKDB";
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto.setBean(rs.getInt("bean"));
				dto.setWater(rs.getInt("water"));
				dto.setMilk(rs.getInt("milk"));
				dto.setVanilaSyrup(rs.getInt("vanilaSyrup"));
				
				OrderDTO.dto = dto;

			}

		} catch (SQLException e) {
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
	
	public int stockUpdate(ManagerDTO dto, OrderDTO orderDto) {
		int result = 0;

		String sql = "update STOCKDB set bean=?,water=?,milk=?,vanilasyrup=? where num=1 ";

		int beanI = (orderDto.getCntA() + orderDto.getCntL()
		+ orderDto.getCntC() + orderDto.getCntV())*orderDto.bean ;
		
		int waterI =(orderDto.getCntA() + orderDto.getCntL()
		+ orderDto.getCntC() + orderDto.getCntV())*orderDto.water ;
		
		int milkI =(orderDto.getCntL()
		+ orderDto.getCntC() + orderDto.getCntV())*orderDto.milk ;
		
		int vanilaI = orderDto.getCntV()*orderDto.VanilaSyrup;
		
		
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setInt(1, dto.getBean()-beanI);
			ps.setInt(2, dto.getWater()-waterI);
			ps.setInt(3, dto.getMilk()-milkI);
			ps.setInt(4, dto.getVanilaSyrup()-vanilaI);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
