package oder;

import java.awt.BorderLayout;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import quiz.Inquiry;

public class Controller implements Initializable {
	
	
	@FXML
	private Button btn01, btn02, btn03, btn04;
	@FXML
	private TextField txt01, txt02, txt03, txt04;

	private Parent root;
	private Inquiry into;

	public void setRoot(Parent root) {
		this.root = root;
		

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn01.setOnAction(e -> {
			btnPrint01();
			
		});
		btn02.setOnAction(e -> {
			btnPrint02();
			
		});
		btn03.setOnAction(e -> {
			btnPrint03();
			
		});
		btn04.setOnAction(e -> {
			btnPrint04();
			
		});
		
	}

	
	public void btnPrint01() {
		
		btn01.setText("Americano");
		txt01.setText(btn01.getText());
	}
	
	
	
	public void btnPrint02() {
		
		txt02.setText(btn02.getText());
		btn02.setText("Latte");
	}
	
	public void btnPrint03() {
		btn03.setText("Cappuccino");
		txt03.setText(btn03.getText());
	}
	public void btnPrint04() {
		btn04.setText("Vanilla Latte");
		txt04.setText(btn04.getText());
	}
}
