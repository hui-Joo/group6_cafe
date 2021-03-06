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
		if (result == 1) {
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
		if (resultwater == 1) {
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
		if (resultmilk == 1) {
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
		if (resultvanila == 1) {
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

	// ????????? ?????????
	public void warning() {
		Alert alert;

		if (db.selectstock().getBean() < 100) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("?????? ?????? ??????");
			alert.setHeaderText("?????? ?????? ??????");
			alert.setContentText("????????? ?????? ?????? ???????????????");
			alert.show();

		}
		if (db.selectstock().getWater() < 200) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("?????? ?????? ??????");
			alert.setHeaderText("?????? ??? ??????");
			alert.setContentText("?????? ?????? ?????? ???????????????");
			alert.show();

		}
		if (db.selectstock().getMilk() < 200) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("?????? ?????? ??????");
			alert.setHeaderText("?????? ?????? ??????");
			alert.setContentText("????????? ?????? ?????? ???????????????");
			alert.show();

		}
		if (db.selectstock().getVanilaSyrup() < 100) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("?????? ?????? ??????");
			alert.setHeaderText("?????? ?????? ??????");
			alert.setContentText("????????? ????????? ?????? ?????? ???????????????");
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
		if (resultice == 1) {
			icetext.clear();
		}

	}

}
