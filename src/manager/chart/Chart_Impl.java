package manager.chart;

import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import manager.commonMA.ManagerDTO;

public class Chart_Impl implements Chart {

	private Chart_DB db;

	private int price_americano = 2000;
	private int price_latte = 3000;
	private int price_capucino = 3000;
	private int price_vanilaLatte = 4000;
	private int price_ice = 500;
	private int price_regular=500;
	private int price_large=1000;
	
	
	private PieChart menuChart,hotIceChart,sizeChart;
	private BarChart totalChart;
	
	private Label labelCupsAm,labelCupsLa,labelCupsCa,labelCupsVa,labelCupsSum;
	private Label labelPriceAm, labelPriceLa, labelPriceCa, labelPriceVa, labelPriceSum;
	private Label labelPriceIce, labelPriceReg, labelPriceLar, labelPriceTotal;
	private Label labelHot, labelIce, labelSmall, labelRegular, labelLarge;
	
	public Chart_Impl() {
		db = new Chart_DB();
	}
	
	@Override
	public void menuChart(Parent root) {
		
		ManagerDTO dto = db.getTotalMenu();
		
		int americano = dto.getAmericano();
		int latte = dto.getLatte();
		int capucino = dto.getCapucino();
		int vanilaLatte = dto.getVanilaLatte();
		
		menuChart = (PieChart)root.lookup("#menuChart");
		menuChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("Americano",americano), new PieChart.Data("Latte", latte),
				new PieChart.Data("Capucino", capucino), new PieChart.Data("VanilaLatte", vanilaLatte)));
	
		
		
		labelCupsAm = (Label)root.lookup("#labelCupsAm");
		labelCupsAm.setText(americano+"ea");
		labelCupsLa = (Label)root.lookup("#labelCupsLa");
		labelCupsLa.setText(latte+"ea");
		labelCupsCa = (Label)root.lookup("#labelCupsCa");
		labelCupsCa.setText(capucino+"ea");
		labelCupsVa = (Label)root.lookup("#labelCupsVa");
		labelCupsVa.setText(vanilaLatte+"ea");
		labelCupsSum = (Label)root.lookup("#labelCupsSum");
		labelCupsSum.setText(americano+latte+capucino+vanilaLatte+"ea");

}

	@Override
	public void totalChart(Parent root) {
		
		ManagerDTO dto = db.getTotalMenu();
		
		int hot = dto.getHot();
		int ice = dto.getMenu_ice();
		int americano = dto.getAmericano();
		int latte = dto.getLatte();
		int capucino = dto.getCapucino();
		int vanilaLatte = dto.getVanilaLatte();
		int small = dto.getSmall();
		int regular = dto.getRegular();
		int large = dto.getLarge();
		
		totalChart = (BarChart)root.lookup("#totalChart");
		XYChart.Series priceChart = new XYChart.Series();
		priceChart.setName("판매금액");
		priceChart.setData(FXCollections.observableArrayList(
				new XYChart.Data("Hot",hot), new XYChart.Data("Ice",ice*price_ice),
				new XYChart.Data("Americano",americano*price_americano), new XYChart.Data("Latte",latte*price_latte),
				new XYChart.Data("Capucino",capucino*price_capucino), new XYChart.Data("VanilaLatte",vanilaLatte*price_vanilaLatte),
				new XYChart.Data("Small",small), new XYChart.Data("Regular",regular*price_regular), new XYChart.Data("Large",large*price_large)));
		totalChart.getData().add(priceChart);
		
		labelPriceAm = (Label)root.lookup("#labelPriceAm");
		labelPriceAm.setText(americano*price_americano+"won");
		labelPriceLa = (Label)root.lookup("#labelPriceLa");
		labelPriceLa.setText(latte*price_latte+"won");
		labelPriceCa = (Label)root.lookup("#labelPriceCa");
		labelPriceCa.setText(capucino*price_capucino+"won");
		labelPriceVa = (Label)root.lookup("#labelPriceVa");
		labelPriceVa.setText(vanilaLatte*price_vanilaLatte+"won");
		labelPriceIce = (Label)root.lookup("#labelPriceIce");
		labelPriceIce.setText(ice*price_ice+"won");
		labelPriceReg = (Label)root.lookup("#labelPriceReg");
		labelPriceReg.setText(regular*price_regular+"won");;
		labelPriceLar = (Label)root.lookup("#labelPriceLar");
		labelPriceLar.setText(large*price_large+"won");
		labelPriceTotal = (Label)root.lookup("#labelPriceTotal");
		labelPriceTotal.setText(americano*price_americano+latte*price_latte+capucino*price_capucino+vanilaLatte*price_vanilaLatte+
				ice*price_ice + regular*price_regular + large*price_large +"won");
	}

	@Override
	public void HISChart(Parent root) {
		
		ManagerDTO dto = db.getTotalMenu();
		
		//Hot&Ice
		int hot = dto.getHot();
		int ice = dto.getMenu_ice();
		
		hotIceChart = (PieChart)root.lookup("#hotIceChart");
		hotIceChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("hot",hot), new PieChart.Data("ice",ice)));
	
		labelHot = (Label)root.lookup("#labelHot");
		labelHot.setText(hot+"ea");
		labelIce = (Label)root.lookup("#labelIce");
		labelIce.setText(ice+"ea");
		
		//size
		int small = dto.getSmall();
		int regular = dto.getRegular();
		int large = dto.getLarge();
		
		sizeChart = (PieChart)root.lookup("#sizeChart");
		sizeChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("small",small), new PieChart.Data("regular",regular), new PieChart.Data("large", large)));
		
		labelSmall = (Label)root.lookup("#labelSmall");
		labelSmall.setText(small+"ea");
		labelRegular = (Label)root.lookup("#labelRegular");
		labelRegular.setText(regular+"ea");
		labelLarge = (Label)root.lookup("#labelLarge");
		labelLarge.setText(large+"ea");
	}




}
