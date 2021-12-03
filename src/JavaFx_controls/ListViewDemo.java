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
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;

public class ListViewDemo extends Application{
    
    ListView<String> lVProgLang;
    
    Label response;
    
    TextField txtAdd = new TextField();
    
    Button btnAdd;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("List View");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 20, 20);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(10));
        
        Scene myScene = new Scene(rootNode, 500, 250, Color.rgb(182, 233, 248));
        
        myStage.setScene(myScene);
        
        response = new Label("Select your preffered languange");
        
        btnAdd = new Button("Add Languange");
        
        ObservableList<String> ProgLangTypes = FXCollections.observableArrayList("Python", "Java", "javaScrip", "C#", "C++", "Kotlin", "Go");
        
        lVProgLang = new ListView<>(ProgLangTypes);

        lVProgLang.setPrefSize(130, 150);
        
        MultipleSelectionModel<String> listVSelModel = lVProgLang.getSelectionModel();
        
        listVSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            response.setText("Your preffered languange was \n" + oldValue + " and now is " + newValue);
        });
        
        btnAdd.setOnAction((ActionEvent event) -> {
            //lVProgLang.setItems(FXCollections.observableArrayList(txtAdd.getText()));
            lVProgLang.getItems().add(txtAdd.getText());
            txtAdd.setText("");
        });
        
        lVProgLang.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.DELETE) {
                lVProgLang.getItems().remove(listVSelModel.getSelectedItem());
            }
        });
        
        rootNode.getChildren().addAll(lVProgLang, response, txtAdd, btnAdd);
    
        myStage.show();
    }
}
