package manager.stock;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import manager.commonMA.ManagerDTO;

public class Stock_serviceimpl {
	Stock_DB db;
	ManagerDTO dto;

	public Stock_serviceimpl() {
		db = new Stock_DB();
	}

	public void insertBean(Parent root) {
		TextField beantext = (TextField) root.lookup("#beantext");

		Integer intbean = Integer.parseInt(beantext.getText());
		int resultbean = db.insertbean(intbean);
		if (resultbean == 1) {
			System.out.println("원두 추가 성공");

		} else {
			System.out.println("원두 추가 실패");
		}

	}

	public void insertWater(Parent root) {
		TextField watertext = (TextField) root.lookup("#watertext");

		Integer intwater = Integer.parseInt(watertext.getText());
		int resultwater = db.insertwater(intwater);
		if (resultwater == 1) {
			System.out.println("물 추가 성공");

		} else {
			System.out.println("물 추가 실패");
		}

	}

	public void insertMilk(Parent root) {
		TextField milktext = (TextField) root.lookup("#milktext");

		Integer intmilk = Integer.parseInt(milktext.getText());
		int resultmilk = db.insertmilk(intmilk);
		if (resultmilk == 1) {
			System.out.println("우유 추가 성공");

		} else {
			System.out.println("우유 추가 실패");
		}

	}

	public void insertvanila(Parent root) {
		TextField vanilatext = (TextField) root.lookup("#vanilatext");

		Integer intvanila = Integer.parseInt(vanilatext.getText());
		int resultvanila = db.insertvanila(intvanila);
		if (resultvanila == 1) {
			System.out.println("바닐라시럽 추가 성공");

		} else {
			System.out.println("바닐라시럽 추가  실패");
		}

	}

	public void setlabel(Parent root) {
		Label beanlabel = (Label) root.lookup("#beanlabel");
		Label waterlabel = (Label) root.lookup("#waterlabel");
		Label milkabel = (Label) root.lookup("#milklabel");
		Label vanilalabel = (Label) root.lookup("#vanilalabel");
		dto = db.selectstock();

		Integer water = dto.getWater();
		System.out.println(dto.getWater());
		waterlabel.setText(water.toString());

	}

}
