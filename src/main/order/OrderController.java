package main.order;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class OrderController implements Initializable{
	
	Parent root;
	Order order;
	OrderDB db;


	public void setRoot(Parent root) {
		this.root = root;
		order.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		order = new OrderImpl();
		db=new OrderDB();
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
	
	public void clickPay() {
		order.clickPay();
	}
	
	public void clickAdmin() {
		
	}


	
}