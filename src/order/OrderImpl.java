package order;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class OrderImpl implements Order {

	
	OrderDTO dto = new OrderDTO();
	Parent root;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	
	
	
	@Override
	public void clickAmericano() {
		dto.cntA++;
		Label LabelCntA = (Label)root.lookup("#LabelCntA");
		LabelCntA.setText(dto.getCntA() + "잔");
		
		total();

	}

	@Override
	public void clickLatte() {				
		dto.cntL++;
		Label LabelCntL = (Label)root.lookup("#LabelCntL");
		LabelCntL.setText(dto.getCntL() + "잔");
		
		total();
	}

	@Override
	public void clickCapuccino() {		
		dto.cntC++;
		Label LabelCntC = (Label)root.lookup("#LabelCntC");
		LabelCntC.setText(dto.getCntC() + "잔");

		total();
	}

	@Override
	public void clickVanilaLatte() {
	
		
		dto.cntV++;
		Label LabelCntV = (Label)root.lookup("#LabelCntV");
		LabelCntV.setText(dto.getCntV() + "잔");
		
		total();
	}

	@Override
	public void total() {
		dto.setSum( dto.getAmericano() * dto.getCntA() + dto.getLatte() * dto.getCntL() + dto.getCapuccino()*dto.getCntC() + dto.getVanilaLatte() * dto.getCntV());
		Label LabelPrice = (Label)root.lookup("#LabelPrice");
		LabelPrice.setText(dto.getSum() + "원");
	}

	
	


	
}
