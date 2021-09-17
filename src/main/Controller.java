package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Controller implements Initializable{
	Parent root;
	coffee_loading loading;
	public void setRoot(Parent root) {
		this.root = root;
		loading.setMedia(root, "/media/video.m4v");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loading = new MediaServiceImpl();
	}
	public void myPlay() {
		loading.myStart();
	}
	public void myPause() {
		loading.myPause();
	}
	public void myStop() {
		loading.myStop();
	}
	public void volumeControl() {
		loading.volumeControl();
	}
}
