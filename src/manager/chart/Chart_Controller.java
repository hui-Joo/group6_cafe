package manager.chart;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class Chart_Controller implements Initializable {

	private Parent root;
	private PieChart menuSalesChart;
	private BarChart menuPriceChart;
	
	public void setRoot(Parent root) {
		this.root = root;
		menuSalesChart = (PieChart)root.lookup("#menuSalesChart");
		menuPriceChart = (BarChart)root.lookup("#menuPriceChart");
		chart();
	}
	
	public void chart() {
		
		menuSalesChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("Americano", 40), new PieChart.Data("Latte", 20),
				new PieChart.Data("Capucino", 15), new PieChart.Data("VanilaLatte", 25)));
		
		XYChart.Series price = new XYChart.Series();
		price.setName("판매금액");
		price.setData(FXCollections.observableArrayList(
				new XYChart.Data("Americano",120000), new XYChart.Data("Latte",60000),
				new XYChart.Data("Capucino",45000), new XYChart.Data("VanilaLatte",100000)));
		menuPriceChart.getData().add(price);
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
	
}
