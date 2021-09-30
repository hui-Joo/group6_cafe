package main.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.commonDB.DBClass;
import manager.commonMA.ManagerDTO;

public class OrderDB {

	OrderDTO orderDto;
	ManagerDTO dto = OrderDTO.dto;
	int hot=0;
	int ice=0;
	int small=0;
	int regular=0;
	int large=0;

	public ManagerDTO setManagerDTO() {

		String sql = "select * from \"MENUDB\" where num=1";
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
				dto.setStock_ice(rs.getInt("ice"));

				OrderDTO.dto = dto;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public void sort() {
		if (orderDto.iceI == 0) {
			hot=1;
		}else if (orderDto.iceI == 1) {
			ice=1;
		}
		if (orderDto.sizeI == 0) {
			small=1;
		}else if (orderDto.sizeI == 1) {
			regular=1;
		}else if (orderDto.sizeI == 2) {
			large=1;
		}
	}

	public int updateMenu(ManagerDTO dto, OrderDTO orderDto) {

		String sql = "update \"MENUDB\" set ice=?, hot=?, americano=?, latte=?, cappuccino=?, vanilaLatte=?, small=?, regular=?, large=? where num=1";
		int result = 0;
		sort();

		try {
			PreparedStatement ps = common.commonDB.DBClass.conn.prepareStatement(sql);
			ps.setInt(1, dto.getMenu_ice() + ice);
			ps.setInt(2, dto.getHot() + hot);
			ps.setInt(3, dto.getAmericano() + orderDto.getCntA());
			ps.setInt(4, dto.getLatte() + orderDto.getCntL());
			ps.setInt(5, dto.getCapucino() + orderDto.getCntC());
			ps.setInt(6, dto.getVanilaLatte() + orderDto.getCntV());
			ps.setInt(7, dto.getSmall() + small);
			ps.setInt(8, dto.getRegular() + regular);
			ps.setInt(9, dto.getLarge() + large);

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int stockUpdate(ManagerDTO dto, OrderDTO orderDto) {
		int result = 0;

		String sql = "update STOCKDB set bean=?,water=?,milk=?,vanilasyrup=?,ice=? where num=1 ";

		int beanI = (orderDto.getCntA() + orderDto.getCntL() + orderDto.getCntC() + orderDto.getCntV()) * orderDto.bean;
		int waterI = orderDto.getCntA() * orderDto.water;
		int milkI = (orderDto.getCntL() + orderDto.getCntC() + orderDto.getCntV()) * orderDto.milk;
		int vanilaI = orderDto.getCntV() * orderDto.VanilaSyrup;
		int iceI = orderDto.iceI * orderDto.ice;

		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setInt(1, dto.getBean() - beanI);
			ps.setInt(2, dto.getWater() - waterI);
			ps.setInt(3, dto.getMilk() - milkI);
			ps.setInt(4, dto.getVanilaSyrup() - vanilaI);
			ps.setInt(5, dto.getStock_ice() - iceI);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
