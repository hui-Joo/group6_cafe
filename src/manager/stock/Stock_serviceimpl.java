package manager.stock;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import manager.commonMA.ManagerDTO;

public class Stock_serviceimpl implements Stock_service {
	Stock_DB db;
	ManagerDTO dto;

	public Stock_serviceimpl() {
		db = new Stock_DB();
	}

	public void updateBean(Parent root) {
		TextField beantext = (TextField) root.lookup("#beantext");
		Label beanlabel = (Label) root.lookup("#beanlabel");

		Integer intbeanTx = Integer.parseInt(beantext.getText());
		Integer intbeanLa = Integer.parseInt(beanlabel.getText());
		Integer bean = intbeanTx + intbeanLa;
		beanlabel.setText(Integer.toString(bean));

		dto.setBean(bean);
		int result = db.update(dto);
		if (result == 0) {
			System.out.println("원두 추가 실패");
		} else {
			beantext.clear();
		}

	}

	public void updateWater(Parent root) {

		TextField watertext = (TextField) root.lookup("#watertext");
		Label waterlabel = (Label) root.lookup("#waterlabel");

		Integer intwaterTx = Integer.parseInt(watertext.getText());
		Integer intwaterLa = Integer.parseInt(waterlabel.getText());
		Integer water = intwaterTx + intwaterLa;
		waterlabel.setText(Integer.toString(water));
		dto.setWater(water);

		int resultwater = db.update(dto);
		if (resultwater == 0) {
			System.out.println("물 추가 실패");
		} else {
			watertext.clear();
		}

	}

	public void updateMilk(Parent root) {

		TextField milktext = (TextField) root.lookup("#milktext");
		Label milklabel = (Label) root.lookup("#milklabel");

		Integer intmilkTx = Integer.parseInt(milktext.getText());
		Integer intmilkLa = Integer.parseInt(milklabel.getText());
		Integer milk = intmilkTx + intmilkLa;
		milklabel.setText(Integer.toString(milk));
		dto.setMilk(milk);

		int resultmilk = db.update(dto);
		if (resultmilk == 0) {
			System.out.println("우유 추가 실패");
		} else {
			milktext.clear();
		}

	}

	public void updateVanila(Parent root) {
		TextField vanilatext = (TextField) root.lookup("#vanilatext");
		Label vanilalabel = (Label) root.lookup("#vanilalabel");

		Integer intvanilaTx = Integer.parseInt(vanilatext.getText());
		Integer intvanilaLa = Integer.parseInt(vanilalabel.getText());
		Integer vanila = intvanilaTx + intvanilaLa;
		vanilalabel.setText(Integer.toString(vanila));
		dto.setVanilaSyrup(vanila);

		int resultvanila = db.update(dto);
		if (resultvanila == 0) {
			System.out.println("바닐라시럽 추가 실패");
		} else {
			vanilatext.clear();
		}

	}

	public void selectlabel(Parent root) {

		Label beanlabel = (Label) root.lookup("#beanlabel");
		Label waterlabel = (Label) root.lookup("#waterlabel");
		Label milklabel = (Label) root.lookup("#milklabel");
		Label vanilalabel = (Label) root.lookup("#vanilalabel");
		Label icelabel = (Label) root.lookup("#icelabel");

		dto = db.selectstock();

		Integer bean = dto.getBean();
		beanlabel.setText(bean.toString());
		Integer water = dto.getWater();
		waterlabel.setText(water.toString());
		Integer milk = dto.getMilk();
		milklabel.setText(milk.toString());
		Integer vanila = dto.getVanilaSyrup();
		vanilalabel.setText(vanila.toString());
		Integer ice = dto.getStock_ice();
		icelabel.setText(ice.toString());

	}

	// 경고창 타이밍
	public void warning() {
		Alert alert = new Alert(AlertType.WARNING);
		if (db.selectstock().getBean() < 200) {
			alert.setTitle("잔여 재고 경고");
			alert.setHeaderText("잔여 원두 경고");
			alert.setContentText("원두가 얼마 남지 않았습니다");
			alert.show();

		}
		if (db.selectstock().getWater() < 200) {
			alert.setTitle("잔여 재고 경고");
			alert.setHeaderText("잔여 물 경고");
			alert.setContentText("물이 얼마 남지 않았습니다");
			alert.show();

		}
		if (db.selectstock().getMilk() < 200) {
			alert.setTitle("잔여 재고 경고");
			alert.setHeaderText("잔여 우유 경고");
			alert.setContentText("우유가 얼마 남지 않았습니다");
			alert.show();

		}
		if (db.selectstock().getVanilaSyrup() < 200) {
			alert.setTitle("잔여 재고 경고");
			alert.setHeaderText("잔여 시럽 경고");
			alert.setContentText("바닐라 시럽이 얼마 남지 않았습니다");
			alert.show();
		}
	}

	@Override
	public void updateIce(Parent root) {

		TextField icetext = (TextField) root.lookup("#icetext");
		Label icelabel = (Label) root.lookup("#icelabel");

		Integer iceTx = Integer.parseInt(icetext.getText());
		Integer iceLa = Integer.parseInt(icelabel.getText());
		Integer ice = iceTx + iceLa;
		icelabel.setText(Integer.toString(ice));
		dto.setStock_ice(ice);

		int resultice = db.update(dto);
		if (resultice == 0) {
			System.out.println("얼음 추가 실패");
		} else {
			icetext.clear();
		}

	}

}
