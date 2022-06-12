package Effect_And_Transforms;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.*;

public class Transform_2D_Shape extends Application{
    
    Rectangle rect = new Rectangle(70, 35, Color.AQUAMARINE);
    Rectangle rect1 = new Rectangle(70, 35, Color.BROWN);
    
    Circle circ = new Circle(40, Color.CORNFLOWERBLUE);
    Circle circ1 = new Circle(40, Color.DARKORCHID);
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("2D Shapes");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("shapes.png")));
        
        HBox rootNode = new HBox(20);
        rootNode.setAlignment(Pos.CENTER_LEFT);
        rootNode.setPadding(new Insets(15));
        
        Scene myScene = new Scene(rootNode, 400, 150, Color.SLATEGRAY);
        
        rect1.getTransforms().add(new Rotate(45, rect1.getWidth()/2, rect1.getHeight()/2));
        
        circ1.getTransforms().add(new Shear(0.3, 0.3));
        
        rootNode.getChildren().addAll(rect, rect1, circ, circ1);
        
        myStage.setScene(myScene);
        myStage.show();
    }
    
}
