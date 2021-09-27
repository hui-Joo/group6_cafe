package main.order;

import javafx.scene.Parent;
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
	}

	@Override
	public void clickAmericano() {
		orderDto.cntA++;
		Label LabelCntA = (Label) root.lookup("#LabelCntA");
		boolean AmeBean = StChk.ChkBean();
		boolean AmeWater = StChk.ChkWater();

		if (AmeBean == true || AmeWater == true) {
			OrderDTO.cntA--;
		}

		LabelCntA.setText(orderDto.getCntA() + "ea");
		total();

	}

	@Override
	public void clickLatte() {
		orderDto.cntL++;
		Label LabelCntL = (Label) root.lookup("#LabelCntL");
		boolean LatteBean = StChk.ChkBean();
		boolean LatteMilk = StChk.ChkMilk();

		if (LatteBean == true || LatteMilk == true) {
			OrderDTO.cntL--;

		}

		LabelCntL.setText(orderDto.getCntL() + "ea");
		total();
	}

	@Override
	public void clickCapuccino() {
		orderDto.cntC++;
		Label LabelCntC = (Label) root.lookup("#LabelCntC");
		boolean CapuBean = StChk.ChkBean();
		boolean CapuMilk = StChk.ChkMilk();

		if (CapuBean == true || CapuMilk == true) {
			OrderDTO.cntC--;

		}

		LabelCntC.setText(orderDto.getCntC() + "ea");

		total();
	}

	@Override
	public void clickVanilaLatte() {
		orderDto.cntV++;
		Label LabelCntV = (Label) root.lookup("#LabelCntV");
		boolean VaBean = StChk.ChkBean();
		boolean VaMilk = StChk.ChkMilk();
		boolean VaSyrup = StChk.ChkVanilaSyrup();
		if (VaBean == true || VaMilk == true || VaSyrup == true) {
			OrderDTO.cntV--;
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
}
