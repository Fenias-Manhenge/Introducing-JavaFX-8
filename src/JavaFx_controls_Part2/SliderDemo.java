package JavaFx_controls_Part2;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;

public class SliderDemo  extends Application{
    
    Slider slider;
    
    Label lblResponse;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("Slider");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 20);
        rootNode.setPadding(new Insets(10));
        rootNode.setAlignment(Pos.CENTER);
        
        Scene myScene = new Scene(rootNode, 350, 200, Color.BEIGE);
        
        myStage.setScene(myScene);
        
        slider = new Slider(0, 50, 5);
        
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setSnapToTicks(true);
        slider.setBlockIncrement(1);
        slider.setMajorTickUnit(10);
        slider.setMinorTickCount(9);
        slider.setPrefSize(300, 40);
        
        lblResponse = new Label("Current value: " + slider.getValue());
        
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            lblResponse.setText("Current value is: " + newValue);
        });
        
        rootNode.getChildren().addAll(slider, lblResponse);
        
        myStage.show();
    }
}
