package Lab4_3;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameCode1 extends Application {
	 
	static boolean tog = true;
	static boolean toggle = false;
	static boolean roundWon = true;
	public static int turn = 7;
	public static int score = 0;
	public static long timeStep = 0;
	public static int orderNum = 0;
	public final static double minWidth = 175;
	public final static double minHeight = 150;
	public final static int leftCol = 125;
	public final static int rightCol = 525;		
	public final static int topRow = 50;		
	public final static int midRow = 225;	
	public final static int botRow = 400;
	public static ArrayList<Integer> order = new ArrayList<Integer>();
	
	public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simon Says");
        
	    Button red = generateButton(leftCol,topRow,"-fx-base: #ff0c00;",1);
	    Button green = generateButton(leftCol,midRow,"-fx-base: #31db0a;",2);
	    Button blue = generateButton(rightCol,botRow,"-fx-base: #0007ef;",6);
	    Button yellow = generateButton(rightCol,midRow,"-fx-base: #fcf802;",5);
	    Button purple = generateButton(leftCol,botRow,"-fx-base: #4d2a72;",3);
	    Button sky = generateButton(rightCol,topRow,"-fx-base: #0ddde8;",4);
	  
			    if (roundWon) {
			    	for (int i = 0; i < turn; i++) {
						order.add((int) ((Math.random() * 6) + 1));
					}
			    	for(int i = 0; i < order.size(); i++)
			    	{
			    		System.out.print(order.get(i));
			    	}
			    	timeStep = System.nanoTime() + 500000000L;
					new AnimationTimer() {
						public void handle(long now) {
							if(now > timeStep)
							{
								timeStep = now + 500000000L;
								toggle = !toggle;
								tog = true;
							}
							if (toggle) {
								if(tog) {
									switch (order.get(orderNum)) {
									case 1:
										red.setStyle("-fx-base: #ffffff;");
										break;
									case 2:
										green.setStyle("-fx-base: #ffffff;");
										break;
									case 6:
										blue.setStyle("-fx-base: #ffffff;");
										break;
									case 5:
										yellow.setStyle("-fx-base: #ffffff;");
										break;
									case 3:
										purple.setStyle("-fx-base: #ffffff;");
										break;
									case 4:
										sky.setStyle("-fx-base: #ffffff;");
										break;
									}
									tog = false;
								}
							}
							else
							{
								if(tog) {
									switch (order.get(orderNum)) {
									case 1:
										red.setStyle("-fx-base: #ffcc00;");
										break;
									case 2:
										green.setStyle("-fx-base: #31db0a;");
										break;
									case 6:
										blue.setStyle("-fx-base: #0007ef;");
										break;
									case 5:
										yellow.setStyle("-fx-base: #fcf802;");
										break;
									case 3:
										purple.setStyle("-fx-base: #4d2a72;");
										break;
									case 4:
										sky.setStyle("-fx-base: #0ddde8;");
										break;
									}
									if(orderNum+1 == order.size())
									{
										roundWon = false;
										this.stop();
									}
									orderNum++;
									tog = false;
								}
							}
						}
					}.start();
				  }
		Pane root = new Pane();
        root.getChildren().addAll(red,green,blue,yellow,purple,sky); 
        primaryStage.setScene(new Scene(root, 800,600));
        primaryStage.show();
        
        
    }
    public static void sleep(int x) 
    {
    	try {
			Thread.sleep(x);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static Button generateButton(int xPos,int yPos,String css,int id)
    {
    	 Button button = new Button();
    	 button.setUserData(id);
    	 button.setMinHeight(minHeight);
    	 button.setMinWidth(minWidth);
    	 button.setOnAction(new EventHandler<ActionEvent>() {
    		 
             @Override
             public void handle(ActionEvent event) {
            	 System.out.println(button.getUserData());
            	 if(roundWon)
            	 {
            		 return;
            	 }
                 if(order.size() == 1 && order.get(0) == button.getUserData())
                 {
                	 order.remove(0);
                	 score++;
                	 turn++;
                	 roundWon = true;
                	 System.out.print("won");
                	 
                 }
                 else
                 {
                	 if(order.get(0) == button.getUserData())
                	 {
                		 order.remove(0);
                	 }
                	 else
                	 {
                		 System.out.print("you lost");
                	 }
                 }
                 for(int i = 0; i < order.size(); i++)
            	 {
            		 System.out.print(order.get(i));
            	 }
                 System.out.println();
             }
         });
         button.setLayoutX(xPos);
         button.setLayoutY(yPos);
         DropShadow shadow = new DropShadow();
 	    button.addEventHandler(MouseEvent.MOUSE_ENTERED, 
 	        new EventHandler<MouseEvent>() {
 	            @Override public void handle(MouseEvent e) {
 	            	button.setEffect(shadow);
 	            }
 	    });
 	    button.addEventHandler(MouseEvent.MOUSE_EXITED, 
 	        new EventHandler<MouseEvent>() {
 	    	@Override public void handle(MouseEvent e) {
 	                button.setEffect(null);
 	            }
 	    });
 	   button.setStyle(css);
 	    button.setPadding(Insets.EMPTY);
		return button;
    }
}
