package main.order;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import manager.commonMA.ManagerDTO;

public class OrderImpl implements Order {

	OrderDB db;
	OrderDTO orderDto;
	ManagerDTO managerDto;
	Parent root;
	
	public OrderImpl() {
		db = new OrderDB();
		orderDto = new OrderDTO();
		managerDto = new ManagerDTO();
	}
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void clickAmericano() {
		orderDto.cntA++;
		Label LabelCntA = (Label)root.lookup("#LabelCntA");
		LabelCntA.setText(orderDto.getCntA() + "ea");
		
		total();

	}

	@Override
	public void clickLatte() {				
		orderDto.cntL++;
		Label LabelCntL = (Label)root.lookup("#LabelCntL");
		LabelCntL.setText(orderDto.getCntL() + "ea");
		
		total();
	}

	@Override
	public void clickCapuccino() {		
		orderDto.cntC++;
		Label LabelCntC = (Label)root.lookup("#LabelCntC");
		LabelCntC.setText(orderDto.getCntC() + "ea");

		total();
	}

	@Override
	public void clickVanilaLatte() {
		orderDto.cntV++;
		Label LabelCntV = (Label)root.lookup("#LabelCntV");
		LabelCntV.setText(orderDto.getCntV() + "ea");
		
		total();
	}

	@Override
	public void total() {
		orderDto.setSum( orderDto.getAmericano() * orderDto.getCntA() + orderDto.getLatte() * orderDto.getCntL() + orderDto.getCapuccino()*orderDto.getCntC() +orderDto.getVanilaLatte() * orderDto.getCntV());
		Label LabelPrice = (Label)root.lookup("#LabelPrice");
		LabelPrice.setText(orderDto.getSum() + "won");
	}

	@Override
	public void resetMenu() {
		orderDto.setCntA(0);
		orderDto.setCntL(0);
		orderDto.setCntC(0);
		orderDto.setCntV(0);
		
		Label LabelCntA = (Label)root.lookup("#LabelCntA");
		LabelCntA.setText(orderDto.getCntA() + "ea");
		
		Label LabelCntL = (Label)root.lookup("#LabelCntL");
		LabelCntL.setText(orderDto.getCntL() + "ea");
		
		Label LabelCntC = (Label)root.lookup("#LabelCntC");
		LabelCntC.setText(orderDto.getCntC() + "ea");
		
		Label LabelCntV = (Label)root.lookup("#LabelCntV");
		LabelCntV.setText(orderDto.getCntV() + "ea");
		
		total();
	}
}
