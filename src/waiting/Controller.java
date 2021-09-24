package waiting;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import order.MainClass;

public class Controller implements Initializable {
	private Stage stage = StageStore.stage;
	Parent root;
	MediaService ms;
	ImageView fxImageView;
	MainClass main;
	order.MainClass order;

	public void setRoot(Parent root) {
		this.root = root;
		ms.setMedia(root);
		ms.myPlay();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MediaServiceImpl();
		order = new order.MainClass();
		main = new MainClass();
	}

	public void setNewStage() {

		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("completion.fxml"));
			Parent sub = loader.load();
			
			AnchorPane subRoot = (AnchorPane) stage.getScene().getRoot();
			
			subRoot.getChildren().add(sub);

			fxImageView = (ImageView) subRoot.lookup("#fxImageViewa");
			fxImageView.setImage(new Image("/media/coffee.jpg"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void restart() {
		try {
			order.start(stage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
