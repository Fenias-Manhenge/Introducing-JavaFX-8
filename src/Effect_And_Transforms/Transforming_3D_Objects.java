package Effect_And_Transforms;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.*;

public class Transforming_3D_Objects extends Application{

    PerspectiveCamera pCamera;
    
    Box box;
    Cylinder cylinder;
    
    Shear shear;
    Scale scale;
    Rotate hRotate;
    Rotate vRotate;
    Translate zTrans;
    
    Group_Demo gd = new Group_Demo();
    Group group;
    
    Slider slrXshear = gd.sliders(0, 5, 0, 1, 1, 0, 150);
    Slider slrYshear = gd.sliders(0, 5, 0, 1, 1, 0, 150);
    Slider slrXscale = gd.sliders(1, 3, 0, 1, 1, 0, 150);
    Slider slrYscale = gd.sliders(1, 3, 0, 1, 1, 0, 150);
    Slider slrZscale = gd.sliders(1, 3, 0, 1, 1, 0, 150);
    Slider slrZpos = gd.sliders(0, 30, 0, 2, 5, 4, 150);
    Slider slrHrotate = gd.sliders(0, 60, 0, 3, 5, 4, 280);
    Slider slrVrotate = gd.sliders(0, 60, 0, 3, 5, 4, 280);
    
    Label lblRotate = new Label("Rotate [ X, Y ]");
    Label lblScale = new Label("Scale [X, Y, Z]");
    Label lblShear = new Label("Shear [ X, Y ]");
    Label lblTranslate = new Label("Translate Z");
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("3D demo");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("3D.png")));
        
        shear = new Shear(0, 0);

        scale = new Scale(1, 1, 1);

        hRotate = new Rotate(0, Rotate.X_AXIS);
        vRotate = new Rotate(0, Rotate.Y_AXIS);

        zTrans = new Translate(0, 0, -60);
        
        actions();
        
        pCamera = new PerspectiveCamera(true);
        pCamera.getTransforms().addAll(hRotate, vRotate, zTrans, scale, shear);
        pCamera.setFarClip(120);
        pCamera.setFieldOfView(45);
        
        // creating the box
        box = gd.prepareBox();
        
        // creating the Cylinder
        cylinder = gd.prepareCylinder();
        
        // Adding transformation in the Cylinder itSelf
        cylinder.getTransforms().addAll(new Rotate(90, 0, 0), new Translate(10, 0, 0));
        
        // Creating the group that will hold the box and Cylinder
        group = new Group();
        group.getChildren().addAll(box, cylinder);
        
        // Creating the SubScene that will manage the group
        SubScene mySubScene = new SubScene(group, 340, 340, true, SceneAntialiasing.DISABLED);
        mySubScene.setFill(Color.valueOf("#708090"));
        mySubScene.setCamera(pCamera);
        
        // Rotate Grid
        GridPane rootGridRotate = gd.gridPane(0, 15);
        
        rootGridRotate.addRow(0, lblRotate);
        rootGridRotate.addRow(1, slrHrotate);
        rootGridRotate.addRow(2, slrVrotate);
        GridPane.setHalignment(lblRotate, HPos.CENTER);
        
        // Scale Grid
        GridPane rootGridScale = gd.gridPane(0, 15);
        
        rootGridScale.add(lblScale, 1, 0);
        rootGridScale.add(slrXscale, 0, 1);
        rootGridScale.add(slrYscale, 1, 1);
        rootGridScale.add(slrZscale, 2, 1);
        GridPane.setHalignment(lblScale, HPos.CENTER);
        
        // Shear Vbox
        VBox rootBoxShear = new VBox(15, lblShear, slrXshear, slrYshear);
        rootBoxShear.setAlignment(Pos.CENTER);
        
        slrXshear.setOrientation(Orientation.VERTICAL);
        slrYshear.setOrientation(Orientation.VERTICAL);
        
        // Translate Vbox
        VBox rootBoxTrans = new VBox(15, lblTranslate, slrZpos);
        rootBoxTrans.setAlignment(Pos.CENTER);
        
        slrZpos.setOrientation(Orientation.VERTICAL);
        
        // The major layout
        BorderPane rootBorder = new BorderPane(mySubScene, rootGridScale, rootBoxTrans, rootGridRotate, rootBoxShear);
        rootBorder.setPadding(new Insets(10));
        BorderPane.setMargin(mySubScene, new Insets(10));
        rootBorder.autosize();

        Scene myScene = new Scene(rootBorder, 700, 700, Color.DIMGREY);
       
        myStage.setScene(myScene);
        myStage.show();
    }
    
    public void actions(){
        
        slrHrotate.valueProperty().addListener((observable, oldValue, newValue) -> {
            hRotate.setAngle((double)newValue);
        });
        
        slrVrotate.valueProperty().addListener((observable, oldValue, newValue) -> {
            vRotate.setAngle((double)newValue);
        });
        
        slrXscale.valueProperty().addListener((observable, oldValue, newValue) -> {
            scale.setX((double)newValue);
        });
        
        slrYscale.valueProperty().addListener((observable, oldValue, newValue) -> {
            scale.setY((double)newValue);
        });
        
        slrZscale.valueProperty().addListener((observable, oldValue, newValue) -> {
            scale.setZ((double)newValue);
        });
        
        slrXshear.valueProperty().addListener((observable, oldValue, newValue) -> {
            shear.setX((double)newValue);
        });
        
        slrYshear.valueProperty().addListener((observable, oldValue, newValue) -> {
            shear.setY((double)newValue);
        });
        
        slrZpos.valueProperty().addListener((observable, oldValue, newValue) -> {
            zTrans.setZ((double)newValue - 1);
        });
    }
}
