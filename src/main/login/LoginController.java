package main.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.commonDB.DBClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.StageStore;
import manager.admin.Admin_Main;

public class LoginController implements Initializable {
	private Parent root;
	public DBClass db;
	LoginDB ldb;
	LoginDTO dto;
	Admin_Main am;
	Stage stage = StageStore.stage;

	public void setRoot(Parent root) {
		this.root = root;
		db = new DBClass();
		ldb = new LoginDB();
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		am = new Admin_Main();

	}

	public void PwAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("로그인 오류");
		alert.setHeaderText("비밀번호   오류");
		alert.setContentText("비밀번호가 틀립니다.");
		alert.show();
	}

	public void Login(ActionEvent event) {

		PasswordField pwf = (PasswordField) root.lookup("#adminpw");

		dto = ldb.selectPw();
		String pw = dto.getPw();

		pwf.requestFocus();
		if (pw.equals(pwf.getText())) {
			try {
				System.out.println("로그인 성공");
				stage.close();
				stage = new Stage();
				am.start(stage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			PwAlert();
			pwf.requestFocus();
			pwf.clear();

		}

	}

}
