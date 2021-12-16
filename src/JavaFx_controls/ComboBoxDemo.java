package JavaFx_controls;

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

public class ComboBoxDemo extends Application{
    
    ComboBox<String> cboLanguages;
    Label response;
    Button btnShow;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("Combo Box");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 30);
        rootNode.setPadding(new Insets(10));
        rootNode.setAlignment(Pos.TOP_CENTER);
        
        Scene myScene = new Scene(rootNode, 350, 200, Color.BLUE);
        
        myStage.setScene(myScene);
        
        ObservableList<String> languages = FXCollections.observableArrayList("Java", "Python", "JavaScript", "GO", "C#", "Kotlin");
        
        cboLanguages = new ComboBox<>(languages);
        response = new Label();
        btnShow = new Button("Drop List");
        
        cboLanguages.setPrefSize(200, 40);
        cboLanguages.setValue("Java");
        cboLanguages.setEditable(true);

        /*int i = cboLanguages.getSelectionModel().getSelectedIndex();
        if(!languages.get(i).equals(cboLanguages.getValue())){
            languages.add(cboLanguages.getValue());
        }*/
        
        /*if(cboLanguages.getSelectionModel().getSelectedItem() != cboLanguages.getValue()){
            languages.add(cboLanguages.getValue());
        }*/
        
        cboLanguages.setOnAction((event) -> {
            response.setText("Your prefered languange is " + cboLanguages.getValue());
        });
        
        btnShow.setOnAction((event) -> {
            cboLanguages.show();
        });
        
        cboLanguages.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                String dif = cboLanguages.getSelectionModel().getSelectedItem();
                if(!cboLanguages.getValue().equals(dif)){
                    languages.add(cboLanguages.getValue());
                }
            }
        });
        
        rootNode.getChildren().addAll(cboLanguages, response, btnShow);
        
        myStage.show();
    }
}
