package main.order;

import java.net.URL;
import java.util.ResourceBundle;

import common.commonStage.StageStore;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import main.login.*;

public class OrderController implements Initializable {

	Parent root;
	Order order;
	Stage stage = StageStore.stage;
	Login_Main login;

	public void setRoot(Parent root) {
		this.root = root;
		order.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		order = new OrderImpl();
		login = new Login_Main();

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
	
	public void clickAdmin() {
		order.ZeroCnt();
		try {
			stage.close();
			stage = new Stage();
			login.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}