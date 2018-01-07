package Lab4_3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameCode extends Application{
	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simon Says");
        
        Button start = new Button();
        start.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        start.setTranslateY(-100);
        DropShadow shadow = new DropShadow();
	    start.addEventHandler(MouseEvent.MOUSE_ENTERED, 
	        new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent e) {
	            	start.setEffect(shadow);
	            }
	    });
	    start.addEventHandler(MouseEvent.MOUSE_EXITED, 
	        new EventHandler<MouseEvent>() {
	    	@Override public void handle(MouseEvent e) {
	                start.setEffect(null);
	            }
	    });
	    Image imageDecline = new Image("file:start-game-button.png");
	    ImageView image = new ImageView(imageDecline);
	    start.setGraphic(image);
	    start.setPadding(Insets.EMPTY); //removes padding in button
	    
	    
        Button view  = new Button();
        view.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        view.setTranslateY(100);
        DropShadow shadow1 = new DropShadow();
	    view.addEventHandler(MouseEvent.MOUSE_ENTERED, 
	        new EventHandler<MouseEvent>() {
	            @Override public void handle(MouseEvent e) {
	            	view.setEffect(shadow1);
	            }
	    });
	    view.addEventHandler(MouseEvent.MOUSE_EXITED, 
	        new EventHandler<MouseEvent>() {
	    	@Override public void handle(MouseEvent e) {
	                view.setEffect(null);
	            }
	    });
	    Image imageDecline1 = new Image("file:scoreboard-button.png");
	    ImageView image1 = new ImageView(imageDecline1);
	    view.setGraphic(image1);
	    view.setPadding(Insets.EMPTY);
        
        StackPane root = new StackPane();
        root.getChildren().add(start);
        root.getChildren().add(view);
        primaryStage.setScene(new Scene(root, 800,600));
        primaryStage.show();
    }
}
