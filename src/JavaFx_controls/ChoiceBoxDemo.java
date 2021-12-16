package JavaFx_controls;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.collections.*;

public class ChoiceBoxDemo extends Application{
    
    ChoiceBox<String> chcLang;
    Label response;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("Choice Box");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 15);
        rootNode.setPadding(new Insets(10));
        rootNode.setAlignment(Pos.CENTER);
        
        Scene myScene = new Scene(rootNode, 350, 200, Color.AQUAMARINE);
        
        myStage.setScene(myScene);
        
        ObservableList languanges = FXCollections.observableArrayList("Python", "Java", "javaScrip", "C#", "C++", "Kotlin", "Go");
        
        chcLang = new ChoiceBox<>(languanges);
        
        response = new Label("Choose your preferred Languange");
        
        SingleSelectionModel<String> singSelModel = chcLang.getSelectionModel();
        
        chcLang.setValue("Java");
        
        singSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            response.setText("Your preferred languange " + newValue);
        });
        
        rootNode.getChildren().addAll(chcLang, response);
        
        myStage.show();
    }
}
