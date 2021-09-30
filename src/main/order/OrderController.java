package main.order;

import java.net.URL;
import java.util.ResourceBundle;

import common.commonStage.StageStore;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
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
	OrderImpl od;

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

		sum = OrderDTO.getSum();

		if (sum == 0) {
			// 장바구니가 비었다는 경고창
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("주문 오류");
			alert.setHeaderText("");
			alert.setContentText("메뉴를 선택 해주세요");
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
		// 메뉴 선택 중 관리자 모드 갔다가 다시 주문창으로 돌아오면 전에 주문했던 값 남아있어서 값 초기화 시켜줌
		order.ZeroCnt();
		try {
			stage.close();
			stage = new Stage();
			login.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickReset() {
		order.resetMenu();
	}

	public void clickMinA() {
		order.clickMinA();
	}

	public void clickMinL() {
		order.clickMinL();
	}

	public void clickMinC() {
		order.clickMinC();
	}

	public void clickMinV() {
		order.clickMinV();
	}
}