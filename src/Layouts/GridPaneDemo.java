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

public class GridPaneDemo extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    Label lblMiguel, lblLeu, lblJunior;
    
    TextField txtMiguel, txtLeu, txtJunior;
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("GridPane");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("grid.png")));
        
        lblMiguel = new Label("Miguel");
        lblLeu = new Label("Leu");     
        lblJunior = new Label("Junior");
        
        txtMiguel = new TextField();
        txtLeu = new TextField();
        txtJunior = new TextField();
        txtJunior.setFocusTraversable(true);
        
        GridPane rootNode = new GridPane();
        
        rootNode.setVgap(15);
        rootNode.setHgap(15);
        
        rootNode.add(lblLeu, 1, 2);
        rootNode.add(lblMiguel, 1, 1);
        rootNode.add(lblJunior, 1, 3);
        
        rootNode.add(txtMiguel, 2, 1);
        rootNode.add(txtLeu, 2, 2);
        rootNode.add(txtJunior, 2, 3);
        
        Scene myScene = new Scene(rootNode, 300, 180);
        
        myStage.setScene(myScene);
        myStage.show();
    }
    
}
