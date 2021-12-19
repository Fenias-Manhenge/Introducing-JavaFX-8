package JavaFx_controls;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class RButton extends Application{

    RadioButton rbMouse;
    RadioButton rbKeyBoard;
    RadioButton rbTouchScreen;
    
    ToggleGroup tg;
    
    Label prompt;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("Radio Button");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);
        rootNode.setAlignment(Pos.CENTER_LEFT);
        rootNode.setPadding(new Insets(10));
        
        Scene myScene = new Scene(rootNode, 200, 200, Color.ANTIQUEWHITE);
        myStage.setScene(myScene);
        
        rbMouse = new RadioButton("Miguel");
        rbTouchScreen = new RadioButton("Leu");
        rbKeyBoard = new RadioButton("Junior");
        
        prompt = new Label("Who you will choose?");
        
        tg = new ToggleGroup();
        
        rbMouse.setToggleGroup(tg);
        rbTouchScreen.setToggleGroup(tg);
        rbKeyBoard.setToggleGroup(tg);
        
        rbMouse.setSelected(true);
        
        rbMouse.setOnAction((event) -> {
            prompt.setText("Primary output is Mouse!");
        });
        
        rbTouchScreen.setOnAction((event) -> {
            prompt.setText("Primary output is TouchScreen!");
        });
        
        rbKeyBoard.setOnAction((event) -> {
            prompt.setText("Primary output is KeyBoard");
        });
        
        rootNode.getChildren().addAll(rbMouse, rbTouchScreen, rbKeyBoard, prompt);
        
        myStage.show();
    }
    
}
