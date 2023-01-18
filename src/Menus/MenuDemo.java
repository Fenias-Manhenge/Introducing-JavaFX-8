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
import javafx.geometry.*;
import javafx.scene.input.KeyCombination;
import javafx.util.Duration;

public class MenuDemo extends Application{

    Label response = new Label();
    
    Button btnRed = new Button("Red", imView("santa_claus_bag.png", 20, 20));
    Button btnBlue = new Button("Blue", imView("blueberry.png", 20, 20));
    Button btnGreen = new Button("Green", imView("green_earth.png", 20, 20));
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("Menu");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("Menu.png")));
        
        BorderPane rootNode = new BorderPane();
        rootNode.setStyle("-fx-background-color: darkgrey");
        
        Scene myScene = new Scene(rootNode, 500, 400, Color.CADETBLUE);
        
        btnBlue.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnGreen.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        btnRed.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        
        btnBlue.setTooltip(new Tooltip("Color Blue"));
        btnRed.setTooltip(new Tooltip("Color Red"));
        btnGreen.setTooltip(new Tooltip("Color Green"));
        
        ToolBar tbColor = new ToolBar(btnBlue, btnGreen, btnRed);
        tbColor.setOrientation(Orientation.VERTICAL);
        
        // creating Menu File
        Menu menuFile = new Menu("_File");
        MenuItem miNewProject = new MenuItem("New Project", imView("new_job.png", 20, 20));
        MenuItem miNewFile = new MenuItem("New File", imView("new_file.png", 20, 20));
        MenuItem miExit = new MenuItem("Exit", imView("exit.png", 30, 30));
        menuFile.getItems().addAll(miNewProject, miNewFile, new SeparatorMenuItem(), miExit);
        
        MenuItem miLeo = new MenuItem("Leo");
        MenuItem miMig = new MenuItem("Miguel");
        MenuItem miJun = new MenuItem("Junior");
        Button btnTest = new Button("Test");
        CustomMenuItem cmi = new CustomMenuItem(btnTest, false);
        MenuButton mbBrothers = new MenuButton("Names", null, miLeo, miMig, miJun, cmi);
        
        btnTest.setOnAction((event) -> {
            
        });
        
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
        
        RadioMenuItem rmiSamsung = new RadioMenuItem("Samsung");
        RadioMenuItem rmiApple = new RadioMenuItem("Apple");
        ToggleGroup tg = new ToggleGroup();
        rmiApple.setToggleGroup(tg);
        rmiSamsung.setToggleGroup(tg);
        rmiSamsung.setSelected(true);
        Menu miRadioPhones = new Menu("Brands", null, rmiApple, rmiSamsung);
        
        MenuBar menuBar = new MenuBar(menuFile, menuEdit, menuAcer, miRadioPhones);
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
        miNewProject.setAccelerator(KeyCombination.keyCombination("shortcut+N"));
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
        miJun.setOnAction(menuEvent);
        
        // Adding the menu bar in the rootNode
        rootNode.setTop(menuBar);
        
        FlowPane rootNodeFlowpane = new FlowPane(Orientation.VERTICAL, 0, 20, response, mbBrothers);
        rootNodeFlowpane.setAlignment(Pos.CENTER);
        rootNode.setCenter(rootNodeFlowpane);
        
        // Adding the ToolBar on the rootNode
        rootNode.setLeft(tbColor);
        
        //passing the scene to Stage
        myStage.setScene(myScene);
        // showing the window
        myStage.show();
    }
    
    // shorthand metod for ImageView
    ImageView imView(String name, int width, int hight){
        ImageView img = new ImageView(new Image(getClass().getResourceAsStream(name), width, hight, true, true));
        return img;
    }
    
    void events(){
        
    }
}
