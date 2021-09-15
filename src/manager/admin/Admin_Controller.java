package manager.admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import manager.stock.StockMain;

public class Admin_Controller implements Initializable {
	private Parent root;
	StockMain sm ;
	Stage stage;

	public void setRoot(Parent root) {
		this.root = root;
	};

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		sm = new StockMain();
		stage = new Stage();
	}

	public void StockBtn() {
System.out.println("재고버튼");
try {
	sm.start(stage);
} catch (Exception e) {
	e.printStackTrace();
}

	}

	public void ChartBtn() {
	System.out.println("차트 버튼");
	}
}
