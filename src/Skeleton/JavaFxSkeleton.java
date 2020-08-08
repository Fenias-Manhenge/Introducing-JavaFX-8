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
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

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
    
    //override the start() method.
    @Override
    public void start(Stage myStage){
        System.out.println("Inside the start() method.");
        
        //give the stage a title.
        myStage.setTitle("JavaFX Skeleton");
        
    }
}
