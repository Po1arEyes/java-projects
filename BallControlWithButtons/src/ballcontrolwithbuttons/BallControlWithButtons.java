/*
 * Christopher Ludwin
 */
package ballcontrolwithbuttons;

//import the usual javafx packages, some are not used at the momement.
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;


public class BallControlWithButtons extends Application {
  private CirclePane circlePane = new CirclePane();
  
  
class CirclePane extends Pane {
  public final double radius = 20;
  public double x = radius, y = radius;
  final double dx = 10, dy = 10;
  private Circle circle = new Circle(x, y, radius);
  
//Constructor for CirclePane
 public CirclePane() {
  getChildren().add(circle);  
  circle.setStroke(Color.BLACK);
  circle.setFill(Color.WHITE);  
  circle.setCenterX(100);
  circle.setCenterY(70);
 }
    //Move the ball on the condition it doesn't go offscreen
    public void moveLeft() {
      if (circle.getCenterX() > radius) {
        x -= dx;
        circle.setCenterX(x);
      } 
    }
    
    public void moveRight() {
      if (circle.getCenterX() < (getWidth() - radius)) {
        x += dx;
        circle.setCenterX(x);
      }
    }
    
    public void moveUp() {
      if (circle.getCenterY() > radius) {
        y -= dy; 
        circle.setCenterY(y);
      }
    }
    
    public void moveDown() {
      if (circle.getCenterY() < (getHeight() - 1.5*radius)) {
        y += dy; 
        circle.setCenterY(y);
      }
    }
}

 @Override // Override the start method in the Application class
 public void start(Stage primaryStage) {
    
    // Create an HBox and add the control buttons
    HBox hBox = new HBox();
    hBox.setSpacing(3);
    hBox.setAlignment(Pos.CENTER);
    Button btLeft = new Button("Left");
    Button btRight = new Button("Right");
    Button btUp = new Button("Up");
    Button btDown = new Button("Down");
    hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);
 

    //Create BorderPane layout and place buttons and pane containing ball
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(circlePane);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.CENTER);
 

    // Creating and Registering control event handlers using lamba expressions
    btLeft.setOnMouseClicked(e -> circlePane.moveLeft());
    btRight.setOnMouseClicked(e -> circlePane.moveRight());
    btUp.setOnMouseClicked(e -> circlePane.moveUp());
    btDown.setOnMouseClicked(e -> circlePane.moveDown());
 
 
 

    // Create a scene and place it in the stage 
    Scene scene = new Scene(borderPane, 200, 150);
    primaryStage.setTitle("Move the ball"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  
 }

public static void main(String[] args) {
        launch(args);
}
    
}

