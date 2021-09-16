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

	public void chkStock(Parent root) {
		// 라벨값 유지 시켜주는 메서드 DTO 객체 생성함
		dto = new ManagerDTO();
		Label beanlabel = (Label) root.lookup("#beanlabel");
		Label waterlabel = (Label) root.lookup("#waterlabel");
		Label milklabel = (Label) root.lookup("#milklabel");
		Label vanilalabel = (Label) root.lookup("#vanilalabel");

		Integer chkbean = Integer.parseInt(beanlabel.getText());
		beanlabel.setText(Integer.toString(chkbean));
		dto.setBean(chkbean);

		Integer chkwater = Integer.parseInt(waterlabel.getText());
		waterlabel.setText(Integer.toString(chkwater));
		dto.setWater(chkwater);

		Integer chkmilk = Integer.parseInt(milklabel.getText());
		milklabel.setText(Integer.toString(chkmilk));
		dto.setMilk(chkmilk);

		Integer chkvanila = Integer.parseInt(vanilalabel.getText());
		vanilalabel.setText(Integer.toString(chkvanila));
		dto.setVanilaSyrup(chkvanila);

	}

	public void insertBean(Parent root) {
		chkStock(root);

		TextField beantext = (TextField) root.lookup("#beantext");
		Label beanlabel = (Label) root.lookup("#beanlabel");

		Integer intbeanTx = Integer.parseInt(beantext.getText());
		Integer intbeanLa = Integer.parseInt(beanlabel.getText());
		Integer bean = intbeanTx + intbeanLa;
		beanlabel.setText(Integer.toString(bean));
		dto.setBean(bean);

		int resultbean = db.insert(dto);
		if (resultbean == 1) {
			System.out.println("원두 추가 성공");

		} else {
			System.out.println("원두 추가 실패");
		}

	}

	public void insertWater(Parent root) {
		chkStock(root);

		TextField watertext = (TextField) root.lookup("#watertext");
		Label waterlabel = (Label) root.lookup("#waterlabel");

		Integer intwaterTx = Integer.parseInt(watertext.getText());
		Integer intwaterLa = Integer.parseInt(waterlabel.getText());
		Integer water = intwaterTx + intwaterLa;
		waterlabel.setText(Integer.toString(water));
		dto.setWater(water);

		int resultwater = db.insert(dto);
		if (resultwater == 1) {
			System.out.println("물 추가 성공");

		} else {
			System.out.println("물 추가 실패");
		}

	}

	public void insertMilk(Parent root) {
		chkStock(root);

		TextField milktext = (TextField) root.lookup("#milktext");
		Label milklabel = (Label) root.lookup("#milklabel");

		Integer intmilkTx = Integer.parseInt(milktext.getText());
		Integer intmilkLa = Integer.parseInt(milklabel.getText());
		Integer milk = intmilkTx + intmilkLa;
		milklabel.setText(Integer.toString(milk));
		dto.setMilk(milk);

		int resultmilk = db.insert(dto);
		if (resultmilk == 1) {
			System.out.println("우유 추가 성공");

		} else {
			System.out.println("우유 추가 실패");
		}

	}

	public void insertvanila(Parent root) {
		chkStock(root);
		TextField vanilatext = (TextField) root.lookup("#vanilatext");
		Label vanilalabel = (Label) root.lookup("#vanilalabel");

		Integer intvanilaTx = Integer.parseInt(vanilatext.getText());
		Integer intvanilaLa = Integer.parseInt(vanilalabel.getText());
		Integer vanila = intvanilaTx + intvanilaLa;
		vanilalabel.setText(Integer.toString(vanila));
		dto.setVanilaSyrup(vanila);

		int resultvanila = db.insert(dto);
		if (resultvanila == 1) {
			System.out.println("바닐라시럽 추가 성공");

		} else {
			System.out.println("바닐라시럽 추가  실패");
		}

	}

	public void selectlabel(Parent root) {

		Label beanlabel = (Label) root.lookup("#beanlabel");
		Label waterlabel = (Label) root.lookup("#waterlabel");
		Label milklabel = (Label) root.lookup("#milklabel");
		Label vanilalabel = (Label) root.lookup("#vanilalabel");

		dto = db.selectstock();

		Integer bean = dto.getBean();
		beanlabel.setText(bean.toString());
		Integer water = dto.getWater();
		waterlabel.setText(water.toString());
		Integer milk = dto.getMilk();
		milklabel.setText(milk.toString());
		Integer vanila = dto.getVanilaSyrup();
		vanilalabel.setText(vanila.toString());

	}

}
