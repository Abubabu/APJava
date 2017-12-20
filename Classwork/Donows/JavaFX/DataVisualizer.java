package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Lab4_2.CSVUtilities;;

public class DataVisualizer extends Application{
	 @Override
	 public void start(Stage stage) throws IOException {
	        stage.setTitle("Mortality Rate");
	        final NumberAxis xAxis = new NumberAxis(2006, 2015, 1);
	        final NumberAxis yAxis = new NumberAxis(2, 11, 1);        
	        final LineChart<Number,Number> sc = new
	            LineChart<Number,Number>(xAxis,yAxis);
	        xAxis.setLabel("Year");                
	        yAxis.setLabel("Infant Mortality Rate");
	        sc.setTitle("Mortality Rate vs Year");
	       
	        File CVS = new File("Infant_Mortality.csv");
			CSVUtilities potato =  new CSVUtilities(CVS); 
			
			ArrayList<Integer> year = new ArrayList<Integer>();
			year = (ArrayList<Integer>) potato.getDataInt(0);
			
			ArrayList<Double> rate = new ArrayList<Double>();
			rate = (ArrayList<Double>) potato.getDataDouble(2);
			
			ArrayList<String> race = new ArrayList<String>();
			race = (ArrayList<String>) potato.getColumnData(1);
			
	        XYChart.Series series1 = new XYChart.Series();
	        series1.setName("Asian and Pacific Islander");
	        
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Black Non-Hispanic");
	        
	        XYChart.Series series3 = new XYChart.Series();
	        series3.setName("Other Hispanic");

	        XYChart.Series series4 = new XYChart.Series();
	        series4.setName("Other/Two or More");
	        
	        XYChart.Series series5 = new XYChart.Series();
	        series5.setName("Puerto Rican");
	        
	        XYChart.Series series6 = new XYChart.Series();
	        series6.setName("White Non-Hispanic");
	        
	        for(int i = 0; i < year.size(); i++)
	        {
	        	if(year.get(i) != null && rate.get(i) != null)
	        	{
	        		switch (race.get(i)) {
	                case "Asian and Pacific Islander":
	                	series1.getData().add(new XYChart.Data(year.get(i), rate.get(i)));
	                    break;
	                case "Black Non-Hispanic":
	                	series2.getData().add(new XYChart.Data(year.get(i), rate.get(i)));
	                    break;
	                case "White Non-Hispanic":
	                	series6.getData().add(new XYChart.Data(year.get(i), rate.get(i)));
	                    break;
	                case "Other Hispanic":
	                	series3.getData().add(new XYChart.Data(year.get(i), rate.get(i)));
	                    break;
	                case "Puerto Rican":
	                	series5.getData().add(new XYChart.Data(year.get(i), rate.get(i)));
	                    break;
	                case "Other/Two or More":
	                	series4.getData().add(new XYChart.Data(year.get(i), rate.get(i)));
	                    break;
	                default: 
	                    break;
	        		}
	        	//	series1.getData().add(new XYChart.Data(year.get(i), rate.get(i)));
	        	}
	        }
	    /*    series1.getData().add(new XYChart.Data(4.2, 193.2));
	        series1.getData().add(new XYChart.Data(2.8, 33.6));
	        series1.getData().add(new XYChart.Data(6.2, 24.8));
	        series1.getData().add(new XYChart.Data(1, 14));
	        series1.getData().add(new XYChart.Data(1.2, 26.4));
	        series1.getData().add(new XYChart.Data(4.4, 114.4));
	        series1.getData().add(new XYChart.Data(8.5, 323));
	        series1.getData().add(new XYChart.Data(6.9, 289.8));
	        series1.getData().add(new XYChart.Data(9.9, 287.1));
	        series1.getData().add(new XYChart.Data(0.9, -9));
	        series1.getData().add(new XYChart.Data(3.2, 150.8));
	        series1.getData().add(new XYChart.Data(4.8, 20.8));
	        series1.getData().add(new XYChart.Data(7.3, -42.3));
	        series1.getData().add(new XYChart.Data(1.8, 81.4));
	        series1.getData().add(new XYChart.Data(7.3, 110.3));
	        series1.getData().add(new XYChart.Data(2.7, 41.2)); */
	        
	 
	        sc.getData().addAll(series1,series2,series3,series4,series5,series6);
	        Scene scene  = new Scene(sc, 500, 400);
	        stage.setScene(scene);
	        stage.show();
	    }
	 
	    public static void main(String[] args) {
	        launch(args);
	    }
}
