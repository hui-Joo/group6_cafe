package main;

import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import main_loading.MediaServiceImpl;

//동영상
public class Controller implements Initializable{
	Parent root;
	MediaServiceImpl msi;
	public void setRoot(Parent root) {
		this.root = root;
		msi.setMedia(root, "/img/coffee_mv.mp4");
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		msi = new MediaServiceImpl();
	}
	public void myPlay() {
		msi.myStart();
	}
	public void myPause() {
		msi.myPause();
	}
	public void myStop() {
		msi.myStart();
	}

	@Override
	public void initialize(java.net.URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}


	
/*
public class Controller implements Initializable{
	Parent root;
	MenuButton mb;
	MediaView mv;
	MediaServiceImpl msi;
	public void setRoot1(Parent root) {
		this.root=root;
		msi.setMedia(root, "/meida/coffee_mv.mp4");
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		//MenuButton mb;
		//MediaView mv;
		msi = new MediaServiceImpl();
		
		public void myPlay() {
			msi.myStart();
		}
		public void myPlause() {
			msi.myPause();
		}
		public void myStop() {
			msi.myStop();
		}
	}
	@SuppressWarnings("unused")
	private void btnheadle(ActionEvent event) {
		mb.setText("아메리카노");
		
	//	mv.setMedia(new MediaPlayer(new Media(new File("coffee_mv.mp4").toURI().toString())));
	}
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
*/