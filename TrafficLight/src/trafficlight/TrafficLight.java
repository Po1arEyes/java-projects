
package trafficlight;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;



/**
 *
 * @author Christopher Ludwin
 */


public class TrafficLight extends Application {
    

@Override
public void start(Stage primaryStage) {
       //Bordering Pane
    BorderPane borderPane = new BorderPane();
    borderPane.setPrefHeight(400);
    borderPane.setPrefWidth(600);
    
    
            
    //Stackpane to hold traffic light   
        StackPane lightPane = new StackPane();
        lightPane.setPrefWidth(200);
        lightPane.setPrefWidth(150);
        lightPane.setAlignment(Pos.CENTER);
        
        //creating rectangle to house lights
        Rectangle lightRec = new Rectangle();
            lightRec.setArcWidth(5);
            lightRec.setArcHeight(5);
            lightRec.setWidth(66);
            lightRec.setHeight(159);
            lightRec.setFill(Color.DODGERBLUE);
        lightPane.getChildren().add(lightRec);
        
        //Placing the lights. initial state is off
        Circle lightCircle1 = new Circle(22);
            lightCircle1.setTranslateY(-50);
            lightCircle1.setFill(Color.web("#394650"));
        Circle lightCircle2 = new Circle(22);
            lightCircle2.setFill(Color.web("#394650"));
        Circle lightCircle3 = new Circle(22);
            lightCircle3.setTranslateY(50);
            lightCircle3.setFill(Color.web("#394650"));
            
        lightPane.getChildren().addAll(lightCircle1, lightCircle2, lightCircle3);
        
        //Create Hbox to hold the three radio buttons   
        HBox buttonBox = new HBox();
        buttonBox.setPrefHeight(100);
        buttonBox.setPrefWidth(200);
        buttonBox.setSpacing(15);
        buttonBox.setAlignment(Pos.CENTER);
        
        //Setting Toggle Group for Buttons
        ToggleGroup lightToggle = new ToggleGroup();
    
        //Radio button for each light & toggle group assignment
        RadioButton rbRed = new RadioButton("Red");
        rbRed.setSelected(false);
        rbRed.setToggleGroup(lightToggle);
        RadioButton rbYellow = new RadioButton("Yellow");
        rbYellow.setSelected(false);
        rbYellow.setToggleGroup(lightToggle);
        RadioButton rbGreen = new RadioButton("Green");
        rbGreen.setSelected(false);
        rbGreen.setToggleGroup(lightToggle);
        
        
        //placing buttons in HBox
        buttonBox.getChildren().addAll(rbRed, rbYellow, rbGreen);
        
    //ActionEvent Handler logic for buttons
    EventHandler<ActionEvent> handler = e -> {    
        if (rbRed.isSelected()) {
            lightCircle1.setFill(Color.web("#ff2121"));
            lightCircle2.setFill(Color.web("#394650"));
            lightCircle3.setFill(Color.web("#394650"));
        }
        
        else if (rbYellow.isSelected()) {
            lightCircle1.setFill(Color.web("#394650"));
            lightCircle2.setFill(Color.web("#fff021"));
            lightCircle3.setFill(Color.web("#394650"));
        }
        
        else if (rbGreen.isSelected()) {
            lightCircle1.setFill(Color.web("#394650"));
            lightCircle2.setFill(Color.web("#394650"));
            lightCircle3.setFill(Color.web("#21ff5e"));
        }
    };
    
    //Setting handlers for each button
     rbRed.setOnAction(handler);
     rbYellow.setOnAction(handler);
     rbGreen.setOnAction(handler);
    
        borderPane.setBottom(buttonBox);
        borderPane.setCenter(lightPane);
        borderPane.setAlignment(buttonBox, Pos.CENTER);
        borderPane.setAlignment(lightPane, Pos.CENTER);
        
        Scene scene = new Scene(borderPane);
        
        primaryStage.setTitle("Traffic Light");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
      
  }

}
