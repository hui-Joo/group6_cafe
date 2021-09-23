package order;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class OrderImpl implements Order {

	Parent root;

	OrderDTO dto = new OrderDTO();

	public void setRoot(Parent root) {
		this.root = root;

	}

	@Override
	public void clickAmericano() {
		TextArea taMenu = (TextArea) root.lookup("#taMenu");
		taMenu.appendText("아메리카노\n");
		dto.cntA++;
		dto.setCntA(dto.cntA);
		System.out.println("A:" + dto.getCntA());
//		TextField tfPrice = (TextField)root.lookup("#tfPrice");
//		tfPrice.setText("2000원");
		Label labelPrice = (Label) root.lookup("#labelPrice");
		dto.sum += dto.getCntA() * dto.americano;
		dto.setCntA(0);
		labelPrice.setText(dto.sum + "원");
	}

	@Override
	public void clickLatte() {
		TextArea taMenu = (TextArea) root.lookup("#taMenu");
		taMenu.appendText("카페라떼\n");
		dto.cntL++;
		dto.setCntL(dto.cntL);
		System.out.println("L:" + dto.getCntL());
		Label labelPrice = (Label) root.lookup("#labelPrice");
		dto.sum += dto.getCntL() * dto.latte;
		dto.setCntL(0);
		labelPrice.setText(dto.sum + "원");

	}

	@Override
	public void clickCapuccino() {
		TextArea taMenu = (TextArea) root.lookup("#taMenu");
		taMenu.appendText("카푸치노\n");
		dto.cntC++;
		dto.setCntC(dto.cntC);
		System.out.println("C:" + dto.getCntC());
		Label labelPrice = (Label) root.lookup("#labelPrice");
		dto.sum += dto.getCntC() * dto.capuccino;
		dto.setCntC(0);
		labelPrice.setText(dto.sum + "원");

	}

	@Override
	public void clickVanilaLatte() {
		TextArea taMenu = (TextArea) root.lookup("#taMenu");
		taMenu.appendText("바닐라라떼\n");
		dto.cntV++;
		dto.setCntV(dto.cntV);
		System.out.println("V:" + dto.getCntV());
		Label labelPrice = (Label) root.lookup("#labelPrice");
		dto.sum += dto.getCntV() * dto.vanilaLatte;
		dto.setCntV(0);
		labelPrice.setText(dto.sum + "원");
	}

	@Override
	public void total() {
		// TODO Auto-generated method stub

	}

}
