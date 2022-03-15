package Layouts;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.scene.effect.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Fonts extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("Fonts");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("font.png")));
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 20);
        rootNode.setAlignment(Pos.CENTER);
        
        Scene myScene = new Scene(rootNode, 300, 300);
        
        myStage.setScene(myScene);
        myStage.show();
        
        Text x1 = new Text("Fenias Manhenge");
        Text x2 = new Text("Fenias Manhenge");
        Text x3 = new Text("Fenias Manhenge");
        
        x1.setFont(Font.font("Constantia", 20));
        x1.setFill(Color.BLACK);
        
        DropShadow dr = new DropShadow(2, 2, 2, Color.BLACK);
        
        x1.setEffect(dr);
        
        rootNode.getChildren().addAll(x1);
    }
    
}
