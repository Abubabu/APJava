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
			
	        XYChart.Series series1 = new XYChart.Series();
	        series1.setName("Points");
	        
	        for(int i = 0; i < year.size(); i++)
	        {
	        	if(year.get(i) != null && rate.get(i) != null)
	        	{
	        		series1.getData().add(new XYChart.Data(year.get(i), rate.get(i)));
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
	        
	 
	        sc.getData().addAll(series1);
	        Scene scene  = new Scene(sc, 500, 400);
	        stage.setScene(scene);
	        stage.show();
	    }
	 
	    public static void main(String[] args) {
	        launch(args);
	    }
}
