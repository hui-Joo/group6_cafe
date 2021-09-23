package test01;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    Parent root;
    oder01 order;



    public void setRoot(Parent root) {
        this.root = root;
        oder01.setRoot(root);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        oder = new oderImpl();
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
        System.out.println("주문하기");
    }




}