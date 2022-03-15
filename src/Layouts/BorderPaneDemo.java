package Layouts;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class BorderPaneDemo extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    TextField txtCenter;
    
    Slider sldRight;
    
    Button btnAlpha, Beta, Gamma;
    
    Label lblTop, lblBottom;
    
    Button btnMiguel, btnLeu, btnJunior;
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("Border Pane");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("border.png")));
        
        // Center
        txtCenter = new TextField();
        txtCenter.setMaxWidth(250);
        
        // Top
        lblTop = new Label("This label is displayed along the top");
        
        // Bottom
        lblBottom = new Label("This label is displayed along the bottom");
        
        // Right
        sldRight = new Slider(0, 100, 50);
        sldRight.setShowTickLabels(true);
        sldRight.setShowTickMarks(true);
        sldRight.setBlockIncrement(5);
        sldRight.setMinorTickCount(4);
        sldRight.setMajorTickUnit(25);
        sldRight.setOrientation(Orientation.VERTICAL);
        sldRight.setPrefWidth(40);
        txtCenter.setText(String.valueOf(sldRight.getValue()));
        
        sldRight.valueProperty().addListener((observable, oldValue, newValue) -> {
            txtCenter.setText("" + newValue);
        });
        
        // Left
        btnMiguel = new Button("Miguel");
        btnLeu = new Button("Leu");
        btnJunior = new Button("Junior");
        
        VBox rootNodeVB = new VBox(10, btnMiguel, btnLeu, btnJunior);
        rootNodeVB.setAlignment(Pos.CENTER);
        
        BorderPane rootNodeBP = new BorderPane(txtCenter, lblTop, sldRight, lblBottom, rootNodeVB);
        BorderPane.setMargin(txtCenter, new Insets(25));
        BorderPane.setMargin(sldRight, new Insets(25));
        BorderPane.setMargin(rootNodeVB, new Insets(20));
        BorderPane.setAlignment(lblBottom, Pos.CENTER);
        BorderPane.setAlignment(lblTop, Pos.CENTER); 

        Scene myScene = new Scene(rootNodeBP, 400, 400);
       
        myStage.setScene(myScene);
        myStage.show();
    }
    
}
