package Effect_And_Transforms;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.effect.*;
import javafx.scene.image.Image;

public class EffectsDemo extends Application{

    double blurVal = 1.0;
    double glowVal = 0.0;
    
    BoxBlur efBlur;
    Glow efGlow;
    
    Button btnBlur, btnGlow;
    
    Label lblReflect;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("Effects");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("visual_effects.png")));

        btnBlur = new Button("Blur");
        btnGlow = new Button("Glow");
        
        efGlow = new Glow();
        btnGlow.setEffect(efGlow);
        
        efBlur = new BoxBlur(1.0, 1.0, 1);
        btnBlur.setEffect(efBlur);
        
        lblReflect = new Label("I will be e big programer!");
        
        Reflection efReflect = new Reflection(1, 1, 1, 0.3);
        
        lblReflect.setEffect(efReflect);
        // Action events
        effectsAction();
        
        StackPane rootNode = new StackPane();
        rootNode.setPadding(new Insets(15));
        StackPane.setAlignment(btnBlur, Pos.TOP_CENTER);
        StackPane.setAlignment(btnGlow, Pos.BOTTOM_CENTER);
        
        rootNode.getChildren().addAll(btnBlur, btnGlow, lblReflect);
        
        Scene myScene = new Scene(rootNode, 250, 200);
        
        myStage.setScene(myScene);
        myStage.show();
    }
    
    public void effectsAction(){
        btnBlur.setOnAction((event) -> {
            if (blurVal == 10) {
                blurVal = 1.0;
                btnBlur.setText("Blur off");
            } else{
                blurVal++;
                btnBlur.setText("Blur on");
            }
            efBlur.setWidth(blurVal);
            efBlur.setHeight(blurVal);
        });
        
        btnGlow.setOnAction((event) -> {
            glowVal += 0.1;
             
            if (glowVal > 1.0) {
                glowVal = 0.0;
                btnGlow.setText("Glow off");
            }else
                btnGlow.setText("Glow on");
 
            efGlow.setLevel(glowVal);
        });
    }
}
