package Layouts;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class StackPaneDemo extends Application{

    Label lblLeu, lblMiguel;
    
    TextField txtCenter;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("StackPane");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("stack.png")));
        
        lblLeu = new Label("Eu sou Leu");
        lblMiguel = new Label("Eu sou Miguel");
        
        txtCenter = new TextField();
        txtCenter.setMaxWidth(150);
        txtCenter.setPromptText("Digite algo aqui");
        
        StackPane rootNode = new StackPane();
        StackPane.setAlignment(lblLeu, Pos.TOP_CENTER);
        StackPane.setAlignment(lblMiguel, Pos.BOTTOM_CENTER);
        
        rootNode.getChildren().addAll(lblLeu, lblMiguel, txtCenter);
        
        Scene myScene = new Scene(rootNode, 300, 200);

        myStage.setScene(myScene);
        myStage.show();
    }
    
}
