package main.order;

import javafx.scene.Parent;

public interface Order {

	public void setRoot(Parent root);
	public void clickAmericano();
	public void clickLatte();
	public void clickCapuccino();
	public void clickVanilaLatte();
	public void total();
	public void resetMenu();
	public void clickMinA();
	public void clickMinL();
	public void clickMinC();
	public void clickMinV();
	public void errorAlert();
	
}
