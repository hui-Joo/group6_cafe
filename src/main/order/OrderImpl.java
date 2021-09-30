package main.order;

import common.commonStage.StageStore;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.choose.ChooseController;

public class OrderImpl implements Order {
	Order_ChkStock StChk;
	OrderDTO orderDto;
	Parent root;
	Stage stage = StageStore.stage;
	String fxmlName;
	ChooseController chooseCont;
	Parent clickRoot;

	public OrderImpl() {
		orderDto = new OrderDTO();
		StChk = new Order_ChkStock();
		chooseCont = new ChooseController();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	public void choose() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlName));
			clickRoot = loader.load();
			Scene scene = new Scene(clickRoot);
			stage = StageStore.stage;
			chooseCont.setRoot(clickRoot);

			stage.setTitle("옵션 선택");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void clickAmericano() {

		orderDto.cntA = 1;
		boolean AmeBean = StChk.ChkBean();
		boolean AmeWater = StChk.ChkWater();

		if (!AmeBean && !AmeWater) {
			fxmlName = "/main/choose/chooseA.fxml";
			choose();
			chooseCont.price();
			chooseCont.label();
		} else {
			ZeroCnt();

		}

	}

	@Override
	public void clickLatte() {
		orderDto.cntL = 1;
		boolean LatteBean = StChk.ChkBean();
		boolean LatteMilk = StChk.ChkMilk();

		if (!LatteBean && !LatteMilk) {

			fxmlName = "/main/choose/chooseL.fxml";
			choose();
			chooseCont.price();
			chooseCont.label();
		} else {
			ZeroCnt();
		}

	}

	@Override
	public void clickCapuccino() {
		orderDto.cntC = 1;

		boolean CapuBean = StChk.ChkBean();
		boolean CapuMilk = StChk.ChkMilk();

		if (!CapuBean && !CapuMilk) {
			fxmlName = "/main/choose/chooseC.fxml";
			choose();
			chooseCont.price();
			chooseCont.label();
		} else {
			ZeroCnt();
		}

	}

	@Override
	public void clickVanilaLatte() {
		orderDto.cntV = 1;
		boolean VaBean = StChk.ChkBean();
		boolean VaMilk = StChk.ChkMilk();
		boolean VaSyrup = StChk.ChkVanilaSyrup();

		if (!VaBean && !VaMilk && !VaSyrup) {

			fxmlName = "/main/choose/chooseV.fxml";
			choose();
			chooseCont.price();
			chooseCont.label();
		} else {
			ZeroCnt();
		}
	}

	@Override
	public void ZeroCnt() {
		orderDto.setCntA(0);
		orderDto.setCntL(0);
		orderDto.setCntC(0);
		orderDto.setCntV(0);
	}

}
