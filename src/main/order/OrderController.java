package main.order;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.StageStore;
import main.login.*;
import main.pay.*;
import manager.stock.Stock_DB;

public class OrderController implements Initializable {

	Parent root;
	Order order;
	OrderDB db;
	Stage stage = StageStore.stage;
	Login_Main login;
	PayMain pay;
	int sum;

	public void setRoot(Parent root) {
		this.root = root;
		order.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		order = new OrderImpl();
		db = new OrderDB();
		login = new Login_Main();
		pay = new PayMain();
	}

	public void clickAmericano() {
		order.clickAmericano();

	}

	public void clickLatte() {
		order.clickLatte();
	}

	public void clickCapuccino() {
		order.clickCapuccino();

	}

	public void clickVanilaLatte() {
		order.clickVanilaLatte();
	}

	public void clickPay() {
		Alert alert;

		sum = OrderDTO.getSum();

		if (sum == 0) {
			alert = new Alert(AlertType.ERROR);
			alert.setTitle("주문 오류");
			alert.setHeaderText("");
			alert.setContentText("주문할 메뉴를 클릭하세요");
			alert.show();
		} else {
			try {
				stage.close();
				stage = new Stage();
				pay.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void clickAdmin() {
		try {
			stage.close();
			stage = new Stage();
			login.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}