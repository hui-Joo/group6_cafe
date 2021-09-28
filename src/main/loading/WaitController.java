package main.loading;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.*;
import main.order.*;

public class WaitController implements Initializable {
	private Stage stage = StageStore.stage;
	Parent root;
	WaitingMediaService ms;
	WaitingMain main;
	main.MainClass order;
	OrderDTO orderDto;

	public void setRoot(Parent root) {
		this.root = root;
		ms.setMedia(root);
		ms.myPlay();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new WaitingMediaServiceImpl();
		order = new main.MainClass();
		orderDto = new OrderDTO();
	}

	public void setNewStage() {

		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("completion.fxml"));
			Parent comproot = loader.load();
			
			Scene scene = new Scene(comproot);
			stage.setTitle("완료화면");
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void reset() {
		orderDto.cntA =0;
		orderDto.cntL =0;
		orderDto.cntC =0;
		orderDto.cntV =0;
		orderDto.sum =0;
	}
	
 // 버튼 멘트 수정
	public void restart() {
		try {
			stage.close();
			reset();
			stage = new Stage();
			order.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
