/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skeleton;

/**
 *
 * @author Fenias
 */

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;

public class JavaFxSkeleton extends Application{

    public static void main(String[] args) {
        
        System.out.println("Lauching JavaFx Application");
        
        //Start the JavaFx Application by calling launch().
        launch(args);
    }
    
    // override the int() method.
    @Override
    public void init(){
        System.out.println("Inside the init() method.");
    }
    
    Label response;
    
    //override the start() method.
    @Override
    public void start(Stage myStage){
        System.out.println("Inside the start() method.");
        
        //give the stage a title.
        myStage.setTitle("JavaFX Skeleton");
        
        /* create a root node. In this case a flow Layout
        is used, but several alternatives exist.
        */
        FlowPane rootnode = new FlowPane(10, 10);
        rootnode.setAlignment(Pos.CENTER);
        
        //create a label
        response = new Label("Push a button");
        
        // create two push buttons
        Button btnFirst = new Button("First");
        Button btnSecond = new Button("Second");
        
        btnFirst.setOnAction((ActionEvent event) -> {
            response.setText("First button was pressed!");
        });
        
        btnSecond.setOnAction((ActionEvent event) -> {
            response.setText("Second button was pressed!");
        });
        
        // putting the Controls into the rootNode and adding it to the scene graph
        rootnode.getChildren().addAll(btnFirst, btnSecond, response);
        
        // Create a Scene
        Scene myScene = new Scene(rootnode, 300, 100);
        
        myScene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        
        btnFirst.setId("bt");
        response.setId("rs");
        // Set the Scene on the Stage.
        myStage.setScene(myScene);
        
        // show the stage and its scene.
        myStage.show();
    }
    
    @Override
    public void stop(){
        System.out.println("Inside the stop() method.");
    }
}
