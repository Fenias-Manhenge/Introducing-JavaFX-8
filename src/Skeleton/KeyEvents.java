package Skeleton;

/**
 *
 * @author fenia
 */

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class KeyEvents extends Application{
    
    TextField test;
    Label typed, pressed, location, clickMouse;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("Key-Typed");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);
        rootNode.setAlignment(Pos.CENTER_LEFT);
        rootNode.setPadding(new Insets(10, 0, 10, 10));
        
        Scene myScene = new Scene(rootNode, 300, 300, Color.CHOCOLATE);
        myStage.setScene(myScene);
        
        test = new TextField();
        typed = new Label("Type something...");
        pressed = new Label("Press something...");
        location = new Label("Move the mouse on the scene, to show the Cordenates (X, Y)");
        clickMouse = new Label("Use the mouse...");

        test.setOnKeyTyped((KeyEvent ae) -> {
            typed.setText("You typed: " + ae.getCharacter().toUpperCase());
        }); 
        
        myScene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case SHIFT: pressed.setText("You pressed Shift!"); break;
                case ALT: pressed.setText("You pressed ALT!"); break;
            }       
        });
        
        myScene.setOnMouseMoved((MouseEvent e) -> {
            location.setText("Cordenates X(" + e.getSceneX() + "); " + "Y(" + e.getSceneY() + ")");
            
            if(e.getSceneX() > 299 && e.getSceneY() > 299)
                location = new Label("Move the mouse on the scene, to show the Cordenates (X, Y)");
            
        });
        
        myScene.setOnMouseClicked((MouseEvent e) -> {
            String count = "time";
            int click = e.getClickCount();
            
            if (click > 1)
                count = "times";
            
            switch(e.getButton()){
                case PRIMARY: clickMouse.setText("Primary button clicked " + click + " " + count); break;
                case MIDDLE: clickMouse.setText("Middle button clicked " + click + " " + count); break;
                case SECONDARY: clickMouse.setText("Secondary button clicked " + click + " " + count); break;
            }
        });
        
        myScene.addEventFilter(MouseEvent.MOUSE_MOVED, (MouseEvent event) -> {

        });
        
        rootNode.getChildren().addAll(test, typed, pressed, location, clickMouse);
        
        myStage.show();
    }
}
