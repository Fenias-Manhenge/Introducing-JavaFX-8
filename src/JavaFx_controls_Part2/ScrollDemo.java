package JavaFx_controls_Part2;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.collections.*;
import javafx.scene.input.*;

public class ScrollDemo extends Application{

    Label content;
    ScrollPane scrollCon;
    Button btnResetValues;
    Separator separator;
    
    public static void main(String[] args) {
        launch(args);
    }
            
    @Override
    public void start(Stage myStage){
        myStage.setTitle("ScrollPane");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);
        rootNode.setPadding(new Insets(10));
        rootNode.setAlignment(Pos.CENTER);
        
        Scene myScene = new Scene(rootNode, 400, 350);
        myScene.setFill(Color.CADETBLUE);
        
        myStage.setScene(myScene);
        
        content = new Label("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
                                    +"\n kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
                                    +"\n kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
                                    +"\n kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
                                    +"\n kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
                                    +"\n kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
                                    +"\n kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
                                    +"\n kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"
                                );
        
        scrollCon = new ScrollPane(content);
        scrollCon.setPrefViewportWidth(200);
        scrollCon.setPrefViewportHeight(200);
        scrollCon.setPannable(true);
        
        separator = new Separator(Orientation.HORIZONTAL);
        separator.setPrefSize(100, 10);
        separator.setHalignment(HPos.LEFT);
        
        btnResetValues = new Button("Reset Scroll");
        
        btnResetValues.setOnAction((event) -> {
              scrollCon.setHvalue(0);
              scrollCon.setVvalue(0);
        });
        
        rootNode.getChildren().addAll(scrollCon, separator, btnResetValues);
        
        myStage.show();
    }
    
}
