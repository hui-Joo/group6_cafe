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
import main.order.OrderDTO;
import main.order.Order_ChkStock;
import main.pay.PayMain;
import manager.stock.Stock_DB;

public class ChooseController implements Initializable {

	PayMain pay;
	main.MainClass order;
	Parent root = StageStore.root;
	Stage stage = StageStore.stage;
	OrderDTO orderDto;
	Stock_DB stock;
	Order_ChkStock StChk;

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

	int cost = 0;
	int hi = 0;
	int si = 0;
	int oi = 0;

	public void setRoot(Parent root) {
		this.root = root;
		StageStore.root = root;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pay = new PayMain();
		order = new main.MainClass();
		StChk = new Order_ChkStock();
	}

	public void price() {
		orderDto = new OrderDTO();
		sort();
		if (OrderDTO.iceI == 1) {
			hi = 500;
		} else if (OrderDTO.iceI == 0) {
			hi = 0;
		}
		if (orderDto.sizeI == 1) {
			si = 500;
		} else if (orderDto.sizeI == 2) {
			si = 1000;
		} else if (orderDto.sizeI == 0) {
			si = 0;
		}
		cost = oi + hi + si;
		hi = 0;
		si = 0;
	}

	public void sort() {
		if (orderDto.cntA == 1) {
			oi = orderDto.americano;
		}
		if (orderDto.cntL == 1) {
			oi = orderDto.latte;
		}
		if (orderDto.cntC == 1) {
			oi = orderDto.capuccino;
		}
		if (orderDto.cntV == 1) {
			oi = orderDto.vanilaLatte;
		}
	}

	public void label() {
		root = StageStore.root;
		Label LabelPrice = (Label) root.lookup("#LabelPrice");
		LabelPrice.setText(cost + " won");
	}

	public void selectHotIce(ActionEvent event) {

		if (hot.isSelected()) {
			OrderDTO.iceI = 0;
			price();
			label();

		} else if (ice.isSelected()) {
			OrderDTO.iceI = 1;

			boolean ice = StChk.Chkice();

			if (!ice) {
				price();
				label();
			} else {
				hot.setSelected(true);
				OrderDTO.iceI = 0;

			}

		}
	}

	public void selectSize(ActionEvent event) {

		if (small.isSelected()) {
			orderDto.sizeI = 0;
			price();
			label();

		} else if (regular.isSelected()) {
			orderDto.sizeI = 1;
			price();
			label();

		} else if (large.isSelected()) {
			orderDto.sizeI = 2;
			price();
			label();
		}
	}

	public void reset() {
		orderDto.cntA = 0;
		orderDto.cntL = 0;
		orderDto.cntC = 0;
		orderDto.cntV = 0;
		orderDto.iceI = 0;
		orderDto.sizeI = 0;
	}

	public void clickReset() {
		try {
			stage.close();
			reset();
			stage = new Stage();
			order.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickPay() {
		try {
			stage.close();
			stage = new Stage();
			pay.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
