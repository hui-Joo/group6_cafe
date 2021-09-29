package main.choose;

import java.net.URL;
import java.util.ResourceBundle;

import common.commonStage.StageStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import main.loading.WaitingMain;
import main.order.OrderDB;
import main.order.OrderDTO;
import manager.commonMA.ManagerDTO;
import manager.stock.Stock_DB;

public class ChooseController implements Initializable {

	Parent root;
	Stage stage = StageStore.stage;
	WaitingMain loading;
	OrderDB db;
	OrderDTO orderDto;
	ManagerDTO dto = OrderDTO.dto;
	Stock_DB stock;
	String fxmlName;

	@FXML
	private ToggleGroup hotIce;
	@FXML
	private ToggleGroup size;

	@FXML
	private RadioButton hot;
	@FXML
	private RadioButton ice;
	@FXML
	private RadioButton small;
	@FXML
	private RadioButton regular;
	@FXML
	private RadioButton large;

	int ame;
	int iceI = 0;
	int sizeI = 0;
	int totalI = 0;

	int c = 0 ;
	int la = 0 ;
	int si = 0 ;

	public void setRoot(Parent root) {
		this.root = root;
		total();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void total() {
		orderDto = new OrderDTO();
		c = orderDto.getCapuccino();
		System.out.println(c);
		price();
		label();
		System.out.println(c);

	}

	public void price() {
		if (iceI == 1) {
			la = 500;
		} else if (iceI ==0) {
			la = 0;
		}
		if (sizeI == 1) {
			si = 500;
		} else if (sizeI == 2) {
			si = 1000;
		} else if (sizeI == 0) {
			si = 0;
		}
		c = c+ la + si;
		la = 0;
		si = 0;
		System.out.println(c);
	}

	public void label() {
		Label LabelPrice = (Label) root.lookup("#LabelPrice");
		LabelPrice.setText(c + " won");
	}

	public void selectHotIce(ActionEvent event) {

		if (hot.isSelected()) {
			iceI = 0 ;
			price();
			label();

		} else if (ice.isSelected()) {
			iceI = 1 ;
			price();
			label();

		}
	}

	public void selectSize(ActionEvent event) {

		if (small.isSelected()) {
			sizeI = 0;
			price();
			//label();

		} else if (regular.isSelected()) {
			sizeI = 1;
			price();
			//label();

		} else if (large.isSelected()) {
			sizeI = 2;
			price();
			//label();
		}
	}

}
