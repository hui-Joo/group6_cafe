package waiting;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller implements Initializable {
	Parent root;
	MediaService ms;
	ImageView fxImageView;
	int cnt;
	
	public void setRoot(Parent root) {
		this.root = root;
		ms.setMedia(root);
		ms.myPlay();
	}
	
	public void setStop() {
		ms.myStop();
		setNewStage();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MediaServiceImpl();
	}
	
	public void setNewStage() {
		try {
		FXMLLoader loader = 
				new FXMLLoader(getClass().getResource("completion.fxml"));
		Parent newRoot = null;
		Scene scene = null;
			newRoot = (Parent) loader.load();
			scene = new Scene(newRoot);
			Stage stage = (Stage)root.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			
			this.root = newRoot;
			fxImageView = (ImageView) root.lookup("#fxImageViewa");
			fxImageView.setImage(new Image("/media/coffee.jpg"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
