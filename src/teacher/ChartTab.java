
package teacher;

import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Arrays;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.scene.Group;
//import javafx.scene.chart.BarChart;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
//import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class ChartTab {
	Tab tab;

	public ChartTab(Tab tab) {
		this.tab = tab;
	}

	public int ten;
	public int nine;
	public int eight;
	public int seven;
	public int six;
	public int five;

	public void open() {

		VBox pane = new VBox();
//		pane.getChildren().addAll(createPieChart(), createCategoryAxis());
		pane.getChildren().addAll(createPieChart());
		tab.setContent(pane);
	}


	public PieChart createPieChart() {
		PieChart pie = new PieChart();
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

		try {

			String query = "SELECT * FROM piechart";

			Statement st = DBConnection.getConnection().createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				ten = rs.getInt("ten");
				nine = rs.getInt("nine");
				eight = rs.getInt("eight");
				seven = rs.getInt("seven");
				six = rs.getInt("six");
				five = rs.getInt("five");

				// print the results
				System.out.format("%s, %s, %s, %s,%s,%s", ten,nine,eight,seven,six,five);
			}
			st.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		data.addAll(new PieChart.Data("ten", ten), new PieChart.Data("nine", nine),
				new PieChart.Data("eight", eight), new PieChart.Data("seven", seven), new PieChart.Data("six", six), new PieChart.Data("five", five));

		pie.setData(data);
		pie.setTitle("Grafikoni i notave");
		return pie;
	}

}
