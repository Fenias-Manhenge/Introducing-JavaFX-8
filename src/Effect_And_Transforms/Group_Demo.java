package Effect_And_Transforms;

/**
 *
 * @author fenia
 */

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.transform.*;

public class Group_Demo{
    
    public Box prepareBox(){
        Box box1 =new Box(10, 20, 30);
        box1.setMaterial(new PhongMaterial(Color.AQUA));
        return box1;
    }
    
    public Cylinder prepareCylinder(){
        Cylinder cylinder1 = new Cylinder(5, 20);
        cylinder1.setMaterial(new PhongMaterial(Color.CHOCOLATE));
        return cylinder1;
    }
    
    public Slider sliders(double min, double max, double start, int blockIncre, double majorTick, int minorTick, int width){
        Slider slider = new Slider(min, max, start);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(majorTick);
        slider.setMinorTickCount(minorTick);
        slider.setSnapToTicks(true);
        slider.setBlockIncrement(blockIncre);
        slider.setPrefWidth(width);
        return slider;
    }
    
    public GridPane gridPane(int hGap, int vGap){
        GridPane rootGrid= new GridPane();
        rootGrid.setVgap(15);
        rootGrid.setHgap(hGap);
        rootGrid.setPadding(new Insets(10));
        rootGrid.setAlignment(Pos.CENTER);
        return rootGrid;
    }
    
    public void actions(){
        
        Transforming_3D_Objects t3o = new Transforming_3D_Objects();
    
        t3o.slrHrotate.valueProperty().addListener((observable, oldValue, newValue) -> {
            t3o.hRotate.setAngle((double)newValue);
        });
        
        t3o.slrVrotate.valueProperty().addListener((observable, oldValue, newValue) -> {
            t3o.vRotate.setAngle((double)newValue);
        });
        
        t3o.slrXscale.valueProperty().addListener((observable, oldValue, newValue) -> {
            t3o.scale.setX((double)newValue);
        });
        
        t3o.slrYscale.valueProperty().addListener((observable, oldValue, newValue) -> {
            t3o.scale.setY((double)newValue);
        });
        
        t3o.slrZscale.valueProperty().addListener((observable, oldValue, newValue) -> {
            t3o.scale.setZ((double)newValue);
        });
        
        t3o.slrXshear.valueProperty().addListener((observable, oldValue, newValue) -> {
            t3o.shear.setX((double)newValue);
        });
        
        t3o.slrYshear.valueProperty().addListener((observable, oldValue, newValue) -> {
            t3o.shear.setY((double)newValue);
        });
        
        t3o.slrZpos.valueProperty().addListener((observable, oldValue, newValue) -> {
            t3o.zTrans.setZ((double)newValue);
        });
    }
}
