package JavaFx_controls;

/**
 *
 * @author fenia
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.FlowPane;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;

public class ListViewDemo extends Application{
    
    ListView<String> lVProgLang;
    
    Label response;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("List View");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 20);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(10));
        
        Scene myScene = new Scene(rootNode, 500, 250, Color.rgb(182, 233, 248));
        
        myStage.setScene(myScene);
        
        response = new Label("Select your preffered languange");
        
        ObservableList<String> ProgLangTypes = FXCollections.observableArrayList("Python", "Java", "javaScrip", "C#", "C++", "Kotlin", "Go");
        
        lVProgLang = new ListView<>(ProgLangTypes);

        lVProgLang.setPrefSize(130, 150);
        
        MultipleSelectionModel<String> listVSelModel = lVProgLang.getSelectionModel();
        
        listVSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            response.setText("Your preffered languange was " + oldValue + " and now is " + newValue);
        });
        
        rootNode.getChildren().addAll(lVProgLang, response);
        
        myStage.show();
    }
}
