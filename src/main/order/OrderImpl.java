package main.order;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
		Button minA = (Button) root.lookup("#minA");
		orderDto.cntA++;
		Label LabelCntA = (Label) root.lookup("#LabelCntA");
		LabelCntA.setText(orderDto.getCntA() + "ea");
		minA.setDisable(false);
		total();

	}

	@Override
	public void clickLatte() {
		Button minL = (Button)root.lookup("#minL");
		orderDto.cntL++;
		Label LabelCntL = (Label) root.lookup("#LabelCntL");
		LabelCntL.setText(orderDto.getCntL() + "ea");
		minL.setDisable(false);
		total();
	}

	@Override
	public void clickCapuccino() {
		Button minC = (Button)root.lookup("#minC");
		orderDto.cntC++;
		Label LabelCntC = (Label) root.lookup("#LabelCntC");
		LabelCntC.setText(orderDto.getCntC() + "ea");
		minC.setDisable(false);
		total();
	}

	@Override
	public void clickVanilaLatte() {
		Button minV = (Button)root.lookup("#minV");
		orderDto.cntV++;
		Label LabelCntV = (Label) root.lookup("#LabelCntV");
		LabelCntV.setText(orderDto.getCntV() + "ea");
		minV.setDisable(false);
		total();
	}

	@Override
	public void total() {
		orderDto.setSum(orderDto.getAmericano() * orderDto.getCntA() + orderDto.getLatte() * orderDto.getCntL()
				+ orderDto.getCapuccino() * orderDto.getCntC() + orderDto.getVanilaLatte() * orderDto.getCntV());
		Label LabelPrice = (Label) root.lookup("#LabelPrice");
		LabelPrice.setText(orderDto.getSum() + "won");
	}

	@Override
	public void resetMenu() { // 고른 메뉴 초기화
		orderDto.setCntA(0);
		orderDto.setCntL(0);
		orderDto.setCntC(0);
		orderDto.setCntV(0);

		Label LabelCntA = (Label) root.lookup("#LabelCntA");
		LabelCntA.setText(orderDto.getCntA() + "ea");

		Label LabelCntL = (Label) root.lookup("#LabelCntL");
		LabelCntL.setText(orderDto.getCntL() + "ea");

		Label LabelCntC = (Label) root.lookup("#LabelCntC");
		LabelCntC.setText(orderDto.getCntC() + "ea");

		Label LabelCntV = (Label) root.lookup("#LabelCntV");
		LabelCntV.setText(orderDto.getCntV() + "ea");

		total();
	}

	@Override
	public void clickMinA() {
		Button minA = (Button) root.lookup("#minA");

		if (orderDto.cntA <= 0) {
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("수량을 선택 해주세요");
			alert.show();
			orderDto.setCntA(0);
			minA.setDisable(true);
			
		}else if(orderDto.cntA > 0) {
			orderDto.cntA--;
			minA.setDisable(false);
		}

		Label LabelCntA = (Label) root.lookup("#LabelCntA");
		LabelCntA.setText(orderDto.getCntA() + "ea");
		total();

	}

	@Override
	public void clickMinL() {
		Button minL = (Button) root.lookup("#minL");

		if (orderDto.cntL <= 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("수량을 선택 해주세요");
			alert.show();
			orderDto.setCntL(0);
			minL.setDisable(true);
		}else if(orderDto.cntL > 0) {
			orderDto.cntL--;
			minL.setDisable(false);
		}

		Label LabelCntL = (Label) root.lookup("#LabelCntL");
		LabelCntL.setText(orderDto.getCntL() + "ea");
		total();

	}

	@Override
	public void clickMinC() {
		Button minC = (Button)root.lookup("#minC");
		if (orderDto.cntC <= 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("수량을 선택 해주세요");
			alert.show();
			orderDto.setCntC(0);
			minC.setDisable(true);			
		}else if(orderDto.cntC > 0) {
			orderDto.cntC--;
			minC.setDisable(false);
		}

		Label LabelCntC = (Label) root.lookup("#LabelCntC");
		LabelCntC.setText(orderDto.getCntC() + "ea");
		total();

	}

	@Override
	public void clickMinV() {
		Button minV = (Button)root.lookup("#minV");		
		if (orderDto.cntV <= 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("수량을 선택 해주세요");
			alert.show();
			orderDto.setCntV(0);
			minV.setDisable(true);
		}else if(orderDto.cntV > 0) {
			orderDto.cntV--;
			minV.setDisable(false);
		}

		Label LabelCntV = (Label) root.lookup("#LabelCntV");
		LabelCntV.setText(orderDto.getCntV() + "ea");
		total();

	}

}
