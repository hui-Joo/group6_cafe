package main.pay;


import java.net.URL;
import java.util.ResourceBundle;

import common.commonStage.StageStore;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import main.loading.WaitingMain;
import main.order.OrderDB;
import main.order.OrderDTO;
import manager.commonMA.ManagerDTO;
import manager.stock.Stock_DB;

public class PayController implements Initializable {
	
	Parent root;
	Stage stage = StageStore.stage;
	WaitingMain loading;
	OrderDB db;
	OrderDTO orderDto ;
	ManagerDTO dto = OrderDTO.dto;
	Stock_DB stock;
	String fxmlName;
	
	public void setRoot(Parent root) {
		this.root = root;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		loading = new WaitingMain();
		db = new OrderDB();
		stock = new Stock_DB();
		orderDto = new OrderDTO();

	}

	public void newOpen() {
		try {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
		Parent clickRoot = loader.load();
		Scene scene = new Scene(clickRoot);
		stage = StageStore.stage;
		
		stage.setTitle("결제 화면");
		stage.setScene(scene);
		stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//결제수단에 따라 팝업 내용 변경?
	public void clickCard() {
		try {
			fxmlName = "payment.fxml";
			stage.close();
			stage = new Stage();
			newOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickKakao() {
		try {
			fxmlName = "payment_kakao.fxml";
			stage.close();
			stage = new Stage();
			newOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void clickPayco() {
		try {
			fxmlName = "payment_payco.fxml";
			stage.close();
			stage = new Stage();
			newOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickLoading() {
		
		
		db.setManagerDTO();
		db.selectStock();
		
		dto = OrderDTO.dto;
	
		
		int result = db.updateMenu(dto,orderDto);
		if (result == 1) {
			System.out.println("DB연동 성공");
		} else {
			System.out.println("DB연동 실패");
		}
		
		result = db.stockUpdate(dto,orderDto);
		if (result == 1) {
			System.out.println("DB연동 성공");
		} else {
			System.out.println("DB연동 실패");
		}
		
		try {
			stage = StageStore.stage;
			stage.close();
			stage = new Stage();
			loading.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}