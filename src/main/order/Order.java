package main.order;

import javafx.scene.Parent;

public interface Order {

	public void setRoot(Parent root);
	public void clickAmericano();
	public void clickLatte();
	public void clickCapuccino();
	public void clickVanilaLatte();
	public void total();
	
	//일단 생성
	public void clickPay();
}
