package main.order;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import manager.commonMA.ManagerDTO;

public class OrderImpl implements Order {
	Order_ChkStock StChk;
	OrderDB db;
	OrderDTO orderDto;
	ManagerDTO managerDto;
	Parent root;

	public OrderImpl() {
		db = new OrderDB();
		orderDto = new OrderDTO();
		managerDto = new ManagerDTO();
		StChk = new Order_ChkStock();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		buttonSetting();
	}

	public void buttonSetting() {
		Button minA = (Button) root.lookup("#minA");
		Button minL = (Button) root.lookup("#minL");
		Button minC = (Button) root.lookup("#minC");
		Button minV = (Button) root.lookup("#minV");
		minA.setDisable(true);
		minL.setDisable(true);
		minC.setDisable(true);
		minV.setDisable(true);
	}

	@Override
	public void clickAmericano() {

		orderDto.cntA++;

		Button minA = (Button) root.lookup("#minA");
		minA.setDisable(false);

		boolean AmeBean = StChk.ChkBean();
		boolean AmeWater = StChk.ChkWater();

		if (AmeBean == true || AmeWater == true) {
			OrderDTO.cntA--;
			if (orderDto.cntA == 0) {
				minA.setDisable(true);
			}
		}
		
		Label LabelCntA = (Label) root.lookup("#LabelCntA");
		LabelCntA.setText(orderDto.getCntA() + "ea");

		total();

	}

	@Override
	public void clickLatte() {

		orderDto.cntL++;

		Button minL = (Button) root.lookup("#minL");
		minL.setDisable(false);

		Label LabelCntL = (Label) root.lookup("#LabelCntL");
		boolean LatteBean = StChk.ChkBean();
		boolean LatteMilk = StChk.ChkMilk();

		if (LatteBean == true || LatteMilk == true) {
			OrderDTO.cntL--;
			if (orderDto.cntL == 0) {
				minL.setDisable(true);
			}
		}

		LabelCntL.setText(orderDto.getCntL() + "ea");

		total();

	}

	@Override
	public void clickCapuccino() {

		orderDto.cntC++;

		Button minC = (Button) root.lookup("#minC");
		minC.setDisable(false);

		Label LabelCntC = (Label) root.lookup("#LabelCntC");
		boolean CapuBean = StChk.ChkBean();
		boolean CapuMilk = StChk.ChkMilk();

		if (CapuBean == true || CapuMilk == true) {
			OrderDTO.cntC--;
			if (orderDto.cntC == 0) {
				minC.setDisable(true);
			}

		}

		LabelCntC.setText(orderDto.getCntC() + "ea");

		total();
	}

	@Override
	public void clickVanilaLatte() {

		orderDto.cntV++;

		Button minV = (Button) root.lookup("#minV");
		minV.setDisable(false);

		Label LabelCntV = (Label) root.lookup("#LabelCntV");
		boolean VaBean = StChk.ChkBean();
		boolean VaMilk = StChk.ChkMilk();
		boolean VaSyrup = StChk.ChkVanilaSyrup();
		if (VaBean == true || VaMilk == true || VaSyrup == true) {
			OrderDTO.cntV--;
			if (orderDto.cntV == 0) {
				minV.setDisable(true);
			}
		}

		LabelCntV.setText(orderDto.getCntV() + "ea");
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
	public void ZeroCnt() {
		orderDto.setCntA(0);
		orderDto.setCntL(0);
		orderDto.setCntC(0);
		orderDto.setCntV(0);

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
		buttonSetting();
	}

	@Override
	public void clickMinA() {

		Button minA = (Button) root.lookup("#minA");

		if (orderDto.cntA > 0) {
			minA.setDisable(false);
			orderDto.cntA--;
			if (orderDto.cntA == 0) {
				minA.setDisable(true);
			}
		} else if (orderDto.cntA <= 0) {
			orderDto.setCntA(0);
			minA.setDisable(true);

		}

		Label LabelCntA = (Label) root.lookup("#LabelCntA");
		LabelCntA.setText(orderDto.getCntA() + "ea");

		total();

	}

	@Override
	public void clickMinL() {

		Button minL = (Button) root.lookup("#minL");

		if (orderDto.cntL > 0) {
			minL.setDisable(false);
			orderDto.cntL--;
			if (orderDto.cntL == 0) {
				minL.setDisable(true);
			}
		} else if (orderDto.cntL <= 0) {
			orderDto.setCntL(0);
			minL.setDisable(true);

		}

		Label LabelCntL = (Label) root.lookup("#LabelCntL");
		LabelCntL.setText(orderDto.getCntL() + "ea");

		total();

	}

	@Override
	public void clickMinC() {
		Button minC = (Button) root.lookup("#minC");

		if (orderDto.cntC > 0) {
			minC.setDisable(false);
			orderDto.cntC--;
		} else if (orderDto.cntC <= 0) {
			orderDto.setCntC(0);
			minC.setDisable(true);
			if (orderDto.cntC == 0) {
				minC.setDisable(true);
			}
		}

		Label LabelCntC = (Label) root.lookup("#LabelCntC");
		LabelCntC.setText(orderDto.getCntC() + "ea");
		total();
	}

	@Override
	public void clickMinV() {
		Button minV = (Button) root.lookup("#minV");

		if (orderDto.cntV > 0) {
			minV.setDisable(false);
			orderDto.cntV--;
			if (orderDto.cntV == 0) {
				minV.setDisable(true);
			}
		} else if (orderDto.cntV <= 0) {
			orderDto.setCntV(0);
			minV.setDisable(true);
		}

		Label LabelCntV = (Label) root.lookup("#LabelCntV");
		LabelCntV.setText(orderDto.getCntV() + "ea");
		total();
	}

}
