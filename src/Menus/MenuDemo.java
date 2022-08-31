package Menus;

/**
 *
 * @author fenias
 */

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.event.*;
import javafx.scene.paint.*;
import javafx.animation.*;
import javafx.scene.input.KeyCombination;
import javafx.util.Duration;

public class MenuDemo extends Application{

    Label response = new Label();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("Menu");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("Menu.png")));
        
        BorderPane rootNode = new BorderPane();
        rootNode.setStyle("-fx-background-color: #093A81");
        
        Scene myScene = new Scene(rootNode, 500, 400, Color.CADETBLUE);
        
        // creating Menu File
        Menu menuFile = new Menu("_File");
        MenuItem miNewProject = new MenuItem("New Project", new ImageView(new Image(getClass().getResourceAsStream("new_job.png"), 20, 20, true, true)));
        MenuItem miNewFile = new MenuItem("New File", new ImageView(new Image(getClass().getResourceAsStream("new_file.png"), 20, 20, true, true)));
        MenuItem miExit = new MenuItem("Exit");
        menuFile.getItems().addAll(miNewProject, miNewFile, new SeparatorMenuItem(), miExit);
        
        // creating Menu Edit
        Menu menuEdit = new Menu("_Edit");
        MenuItem miUndo = new MenuItem("Undo");
        MenuItem miRendo = new MenuItem("Rendo");
        MenuItem miCut = new MenuItem("Cut");
        MenuItem miCopy = new MenuItem("Copy");
        MenuItem miPaste = new MenuItem("Paste");
        menuEdit.getItems().addAll(miUndo, miRendo, new SeparatorMenuItem(), miCut, miCopy, miPaste);
        
        CheckMenuItem chkIHelios = new CheckMenuItem("Helios");
        CheckMenuItem chkITriton = new CheckMenuItem("Triton");
        Menu miDevices = new Menu("Devices", null, chkIHelios, chkITriton);
        Menu menuAcer = new Menu("Acer", null, miDevices);
        
        MenuBar menuBar = new MenuBar(menuFile, menuEdit, menuAcer);
        //myStage.setFullScreen(true);
        
        // creating event handlers for menu items
        EventHandler<ActionEvent> menuEvent = (ActionEvent event) -> {
            String name = ((MenuItem) event.getTarget()).getText();
            
            if (name.equals("Exit")){ 
                FadeTransition fadeStage = new FadeTransition(Duration.seconds(100), rootNode);
                fadeStage.setCycleCount(1);
                fadeStage.setToValue(1);
                fadeStage.setFromValue(0);
                fadeStage.play();
                Platform.exit();
            }
            
            response.setText(name + " selected");
            response.setTextFill(Color.WHITE);
        };
        // setting accelerators
        miNewProject.setAccelerator(KeyCombination.keyCombination(" shortcut+N"));
        miNewFile.setAccelerator(KeyCombination.keyCombination("shortcut+F"));
        miExit.setAccelerator(KeyCombination.keyCombination("shortcut+shift+E"));
        
        // Setting Mnemonics
        menuFile.setMnemonicParsing(true);
        menuEdit.setMnemonicParsing(true);
        
        // Adding actions events to menu items
        miCopy.setOnAction(menuEvent);
        miCut.setOnAction(menuEvent);
        miExit.setOnAction(menuEvent);
        miNewFile.setOnAction(menuEvent);
        miNewProject.setOnAction(menuEvent);
        miPaste.setOnAction(menuEvent);
        miRendo.setOnAction(menuEvent);
        miUndo.setOnAction(menuEvent);
        
        // Adding the menu bar in the rootNode
        rootNode.setTop(menuBar);
        rootNode.setCenter(response);
        
        myStage.setScene(myScene);
        myStage.show();
    }
}
