/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect_And_Transforms;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.transform.*;
import javafx.geometry.*;
import javafx.scene.image.*;

public class Transforms_2D extends Application{

    Rotate rotate;
    Shear shear;
    Scale scale;
    Translate translate;
    
    // Rotate Slider 
    Slider sldAngle = sliders(0, 60, 30, 4, 5, 5);
    Slider sldPivotX = sliders(0, 10, 0.5, 4, 5, 0.2);
    Slider sldPivotY = sliders(0, 10, 0.5, 4, 5, 0.2);
    
    // Scale Slider 
    Slider sldScaleFactorX = sliders(0, 2, 0.5, 4, 0.5, 0.2);
    Slider sldScaleFactorY = sliders(0, 2, 0.5, 4, 0.5, 0.2);
    
    // Shear Slider
    Slider sldShearFactorX = sliders(0, 2, 0.5, 4, 0.5, 0.2);
    Slider sldShearFactorY = sliders(0, 2, 0.5, 4, 0.5, 0.2);
    
    // Translate slider
    Slider sldDistanceX = sliders(0, 50, 0, 4, 5, 5);
    Slider sldDistanceY = sliders(0, 50, 0, 4, 5, 5);
    
    Button btnRotate;
    Button btnShear;
    Button btnScale;
    Button btnTranslate;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("Transforms 2D");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("variation.png")));
        
        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setHgap(30);
        rootNode.setVgap(20);
        //rootNode.setGridLinesVisible(true);
        
        Scene myScene = new Scene(rootNode, 800, 400, Color.AQUA);
        
        btnRotate = new Button("Rotate", new ImageView(new Image(getClass().getResourceAsStream("rotate.png"))));
        btnScale = new Button("Scale");
        btnShear = new Button("Shear");
        btnTranslate = new Button("Translate");
        
        GridPane.setMargin(btnRotate, new Insets(0, 0, 25, 0));
        GridPane.setMargin(btnShear, new Insets(0, 0, 25, 0));
        GridPane.setMargin(btnTranslate, new Insets(0, 0, 25, 0));
        GridPane.setMargin(btnScale, new Insets(0, 0, 25, 0));
        
        //Scale
        scale = new Scale(0.5, 0.5);
        
        // Shear
        shear = new Shear(0.3, 0.3);
        
        // Translate
        translate = new Translate(50, 50);
        
        // Rotate
        rotate = new Rotate(35, 0.5, 0.5);
        
        btnRotate.getTransforms().add(rotate);
        btnScale.getTransforms().add(scale);
        btnShear.getTransforms().add(shear);
        btnTranslate.getTransforms().add(translate);
        
        // Rotate Grid
        rootNode.add(btnRotate, 0, 0);
        rootNode.add(sldAngle, 0, 1);
        rootNode.add(sldPivotX, 0, 2);
        rootNode.add(sldPivotY, 0, 3);
        
        // Scale Grid
        rootNode.add(btnScale, 1, 0);
        rootNode.add(sldScaleFactorX, 1, 1);
        rootNode.add(sldScaleFactorY, 1, 2);
        
        // Shear Grid
        rootNode.add(btnShear, 2, 0);
        rootNode.add(sldShearFactorX, 2, 1);
        rootNode.add(sldShearFactorY, 2, 2);
        
        // Translate Grid
        rootNode.add(btnTranslate, 3, 0);
        rootNode.add(sldDistanceX, 3, 1);
        rootNode.add(sldDistanceY, 3, 2);
        
        actionTransforms();
        
        myStage.setScene(myScene);
        myStage.show();
    }
    
    Slider sliders(double min, double max, double current, int minorTiUnit, double majorTiUnit, double blockInc){
        Slider slider = new Slider(min, max, current);
        slider.setMajorTickUnit(majorTiUnit);
        slider.setMinorTickCount(minorTiUnit);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setBlockIncrement(blockInc);
        slider.setSnapToTicks(true);
        return slider;
    }
    
    public void actionTransforms(){
        
        sldScaleFactorX.valueProperty().addListener((observable, oldValue, newValue) -> {
            scale.setX((double)newValue);
        });
        
        sldScaleFactorY.valueProperty().addListener((observable, oldValue, newValue) -> {
            scale.setY((double)newValue);
        });
        
        sldShearFactorX.valueProperty().addListener((observable, oldValue, newValue) -> {
            shear.setX((double)newValue);
        });
        
        sldShearFactorY.valueProperty().addListener((observable, oldValue, newValue) -> {
            shear.setY((double)newValue);
        });
        
        sldDistanceX.valueProperty().addListener((observable, oldValue, newValue) -> {
            translate.setX((double)newValue);
        });
        
        sldDistanceY.valueProperty().addListener((observable, oldValue, newValue) -> {
            translate.setY((double)newValue);
        });
        
        sldAngle.valueProperty().addListener((observable, oldValue, newValue) -> {
            rotate.setAngle((double)newValue);
        });
        
        sldPivotX.valueProperty().addListener((observable, oldValue, newValue) -> {
            rotate.setPivotX((double)newValue);
        });
        
        sldPivotY.valueProperty().addListener((observable, oldValue, newValue) -> {
            rotate.setPivotY((double)newValue);
        });
    }
}
