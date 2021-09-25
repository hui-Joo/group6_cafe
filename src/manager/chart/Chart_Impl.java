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
	
	private PieChart menuSalesChart;
	private BarChart menuPriceChart;
	
	private Label labelCupsAm,labelCupsLa,labelCupsCa,labelCupsVa,labelCupsSum;
	private Label labelPriceAm, labelPriceLa, labelPriceCa, labelPriceVa, labelPriceSum;
	
	public Chart_Impl() {
		db = new Chart_DB();
	}
	
	@Override
	public void chart(Parent root) {
		
		ManagerDTO dto = db.getTotalMenu();
	
		menuSalesChart = (PieChart)root.lookup("#menuSalesChart");
		menuPriceChart = (BarChart)root.lookup("#menuPriceChart");
		
		int americano = dto.getAmericano();
		int latte = dto.getLatte();
		int capucino = dto.getCapucino();
		int vanilaLatte = dto.getVanilaLatte();
		
		menuSalesChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("Americano",americano), new PieChart.Data("Latte", latte),
				new PieChart.Data("Capucino", capucino), new PieChart.Data("VanilaLatte", vanilaLatte)));
	
		XYChart.Series priceChart = new XYChart.Series();
		priceChart.setName("판매금액");
		priceChart.setData(FXCollections.observableArrayList(
				new XYChart.Data("Americano",americano*price_americano), new XYChart.Data("Latte",latte*price_latte),
				new XYChart.Data("Capucino",capucino*price_capucino), new XYChart.Data("VanilaLatte",vanilaLatte*price_vanilaLatte)));
		menuPriceChart.getData().add(priceChart);
		
		labelCupsAm = (Label)root.lookup("#labelCupsAm");
		labelCupsAm.setText(americano+"잔");
		labelCupsLa = (Label)root.lookup("#labelCupsLa");
		labelCupsLa.setText(latte+"잔");
		labelCupsCa = (Label)root.lookup("#labelCupsCa");
		labelCupsCa.setText(capucino+"잔");
		labelCupsVa = (Label)root.lookup("#labelCupsVa");
		labelCupsVa.setText(vanilaLatte+"잔");
		labelCupsSum = (Label)root.lookup("#labelCupsSum");
		labelCupsSum.setText(americano+latte+capucino+vanilaLatte+"잔");

		labelPriceAm = (Label)root.lookup("#labelPriceAm");
		labelPriceAm.setText(americano*price_americano+"원");
		labelPriceLa = (Label)root.lookup("#labelPriceLa");
		labelPriceLa.setText(latte*price_latte+"원");
		labelPriceCa = (Label)root.lookup("#labelPriceCa");
		labelPriceCa.setText(capucino*price_capucino+"원");
		labelPriceVa = (Label)root.lookup("#labelPriceVa");
		labelPriceVa.setText(vanilaLatte*price_vanilaLatte+"원");
		labelPriceSum = (Label)root.lookup("#labelPriceSum");
		labelPriceSum.setText(americano*price_americano+latte*price_latte+capucino*price_capucino+vanilaLatte*price_vanilaLatte+"원");
}


}
