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

public class ListViewDemoMulSelections extends Application{
    
    ListView<String> listVProgLang;
    
    Label response;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("List View");
        myStage.setMinHeight(220);
        myStage.setMaxHeight(240);
        myStage.setMinWidth(400);
        myStage.setMaxWidth(420);
        
        FlowPane rootNode = new FlowPane(Orientation.HORIZONTAL, 10, 0);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(10));
        
        Scene myScene = new Scene(rootNode, 400, 220, Color.rgb(182, 233, 248));

        myStage.setScene(myScene);
        
        response = new Label("Select your preffered languange");
        
        ObservableList<String> ProgLangTypes = FXCollections.observableArrayList("Python", "Java", "javaScrip", "C#", "C++", "Kotlin", "Go");
        
        listVProgLang = new ListView<>(ProgLangTypes);

        listVProgLang.setPrefSize(130, 150);
        
        MultipleSelectionModel<String> listVSelModel = listVProgLang.getSelectionModel();
        listVSelModel.setSelectionMode(SelectionMode.MULTIPLE);
        
        listVSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            
            String selItem = "";
            
            for (String item : listVSelModel.getSelectedItems()) {
                selItem += "\n\t\t" + item; 
            }
            
            response.setText("All your preffered languange " + selItem);
        });
        
        rootNode.getChildren().addAll(listVProgLang, response);
        
        myStage.show();
    }
}
