package main.order;

import common.commonDB.DBClass;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import manager.commonMA.ManagerDTO;
import manager.stock.Stock_DB;

public class Order_ChkStock {
	DBClass db;
	Stock_DB stockdb;
	ManagerDTO dto;
	OrderDTO odto;
	Alert alert;
	int sum;

	public Order_ChkStock() {
		db = new DBClass();
		stockdb = new Stock_DB();
	}

	public boolean ChkBean() {
		dto = stockdb.selectstock();
		sum = (OrderDTO.cntA+OrderDTO.cntC+OrderDTO.cntL+OrderDTO.cntV) * OrderDTO.bean;
		boolean flag = true;

		if (dto.getBean() < sum) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("재료 부족");
			alert.setHeaderText(" ");
			alert.setContentText("원두가 부족합니다.");
			alert.show();
			
			flag = false;

		} else {
			System.out.println("커피 있음");
			flag = true;
		}
		return flag;
	}
	public boolean ChkMilk() {
		dto = stockdb.selectstock();
		sum = (OrderDTO.cntC+OrderDTO.cntL+OrderDTO.cntV) * OrderDTO.milk;
		boolean flag = true;
		
		if (dto.getMilk() < sum) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("재료 부족");
			alert.setHeaderText(" ");
			alert.setContentText("우유가 부족합니다.");
			alert.show();
			
			flag = false;
			
		} else {
			System.out.println("우유 있음");
			flag = true;
		}
		return flag;
	}
	public boolean ChkVanilaSyrup() {
		dto = stockdb.selectstock();
		sum = OrderDTO.cntV * OrderDTO.VanilaSyrup;
		boolean flag = true;
		
		if (dto.getVanilaSyrup() < sum) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("재료 부족");
			alert.setHeaderText(" ");
			alert.setContentText("시럽이 부족합니다.");
			alert.show();
			
			flag = false;
			
		} else {
			System.out.println("시럽 있음");
			flag = true;
		}
		return flag;
	}
	public boolean ChkWater() {
		dto = stockdb.selectstock();
		sum = OrderDTO.cntA * OrderDTO.water;
		boolean flag = true;
		
		if (dto.getWater() < sum) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("재료 부족");
			alert.setHeaderText(" ");
			alert.setContentText("물이 부족합니다.");
			alert.show();
			
			flag = false;
			
		} else {
			System.out.println("물 있음");
			flag = true;
		}
		return flag;
	}
	
	

}
