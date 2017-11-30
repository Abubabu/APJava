package Lab3_4;

import javafx.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import Lab3_4.ShellSort;
  
 
public class HelloWorld extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("Shell Sort");
        final NumberAxis xAxis = new NumberAxis(0, 1000, 100);
        final NumberAxis yAxis = new NumberAxis(0, 5000, 500);        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Array Length");                
        yAxis.setLabel("Nanoseconds");
        sc.setTitle("Time Scatterplot");
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("ShellSort");
        
        for (int j = 0; j < 1000; j = j + 100) {
			int[] list = new int[j];
			for(int k = 0; k < j; k++)
			{
				list[k] = (int) (Math.random()*100);
			}
			double time = 0;
			for (int i = 0; i < 1000; i++) {
				long startime = System.nanoTime();
				ShellSort.shellSort(list, j / 2);
				long endtime = System.nanoTime();
				long finalTime = endtime - startime;
				time += finalTime;
			}
			series1.getData().add(new XYChart.Data(j, time / 1000));
		}
		sc.getData().addAll(series1);
        Scene scene  = new Scene(sc, 500, 400);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}