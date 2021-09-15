package manager.chart;

import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import manager.commonMA.ManagerDTO;

public class Chart_Impl implements Chart {

	private Chart_DB db;

	private int price_americano = 2000;
	private int price_latte = 3000;
	private int price_capucino = 3000;
	private int price_vanilaLatte = 4000;
	
	public Chart_Impl() {
		db = new Chart_DB();
	}
	
	@Override
	public void chart(Parent root) {
		
		ManagerDTO dto = db.getTotalMenu();
	
		PieChart menuSalesChart = (PieChart)root.lookup("#menuSalesChart");
		BarChart menuPriceChart = (BarChart)root.lookup("#menuPriceChart");
		
		menuSalesChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("Americano",dto.getAmericano()), new PieChart.Data("Latte", dto.getLatte()),
				new PieChart.Data("Capucino", dto.getCapucino()), new PieChart.Data("VanilaLatte", dto.getAmericano())));
	
		XYChart.Series priceChart = new XYChart.Series();
		priceChart.setName("판매금액");
		priceChart.setData(FXCollections.observableArrayList(
				new XYChart.Data("Americano",dto.getAmericano()*price_americano), new XYChart.Data("Latte",dto.getLatte()*price_latte),
				new XYChart.Data("Capucino",dto.getCapucino()*price_capucino), new XYChart.Data("VanilaLatte",dto.getVanilaLatte()*price_vanilaLatte)));
		menuPriceChart.getData().add(priceChart);
	
}


}
