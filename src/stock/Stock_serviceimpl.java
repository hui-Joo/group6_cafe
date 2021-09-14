package stock;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Stock_serviceimpl {
	Stock_DB db;

	public void insertBean(Parent root) {
		db = new Stock_DB();
		Label beanlabel = (Label) root.lookup("#beanlabel");
		TextField beantext = (TextField) root.lookup("#beantext");
		Integer intbean = Integer.parseInt(beantext.getText());

		int resultbean = db.insertbean(intbean);

		if (resultbean == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}

	}

}
