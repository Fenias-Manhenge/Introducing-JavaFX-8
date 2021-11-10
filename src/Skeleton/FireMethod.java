package Skeleton;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

public class FireMethod extends Application{
    
    private Button btnFire;
    private CheckBox cbAc, cbPc;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        myStage.setTitle("Fire Method");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);
        
        rootNode.setAlignment(Pos.CENTER_LEFT);
        
        rootNode.setPadding(new Insets(0, 0, 0, 10));
        
        Scene myScece = new Scene(rootNode, 300, 100);
        
        myStage.setScene(myScece);
        
        cbAc = new CheckBox("Ar Condicionado");
        cbPc = new CheckBox("Computer");
        
        btnFire = new Button("Select all");
        
        actions();
        
        rootNode.getChildren().addAll(cbAc, cbPc, btnFire);
        
        myStage.show();
    }
    
    public void actions(){
        if(btnFire.getText().equalsIgnoreCase("Select all")){
            btnFire.setOnAction((event) -> {
                cbAc.fire();
                cbPc.fire();
                btnFire.setText("Unselect all");
            });
            
        }
            
            /*if(btnFire.getText().startsWith("Se")){
                btnFire.setOnAction((event) -> {
                    cbAc.fire();
                    cbPc.fire();
                    //btnFire.setText(btnFire.getText());
                });
            }*/
        
    }
}
