package manager.stock;

import java.util.ArrayList;

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
		// 일단 출력은 됨 근데 이전 값을 못 불러오니 arraylist 이용해서 dto값을 넣어준 후 다시 접근하자

		ArrayList<Integer> arr = new ArrayList<>();
		
		Label beanlabel = (Label) root.lookup("#beanlabel");
		Label waterlabel = (Label) root.lookup("#waterlabel");
		Label milklabel = (Label) root.lookup("#milklabel");
		Label vanilalabel = (Label) root.lookup("#vanilalabel");
		dto = db.selectstock();

		


		Integer bean = dto.getBean();
		beanlabel.setText("보유량 :" + bean.toString() + " g");
		Integer water = dto.getWater();
		waterlabel.setText("보유량 :" + water.toString() + " ML");
		Integer milk = dto.getMilk();
		milklabel.setText("보유량 :" + milk.toString() + " ML");
		Integer vanila = dto.getVanilaSyrup();
		vanilalabel.setText("보유량 :" + vanila.toString() + " ML");

	}

}
