
package Animations;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.scene.transform.*;
import javafx.scene.paint.Color;

public class Transition extends Application{
    
    Label response;
    
    Button btnRotate;
    Button btnScale;
    Button btnTranslate;
    Button btnRun;
    Button btnParTrans;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("Transitions");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("rotate.png")));
        
        VBox rootNode = new VBox(40);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(10));
        
        Scene myScene = new Scene(rootNode, 400, 300);
        
        myStage.setScene(myScene);
        
        response = new Label("Push the start button", new ImageView(
                new Image(getClass().getResourceAsStream("response.png"), 30, 30, true, true)));
        response.setContentDisplay(ContentDisplay.RIGHT);
        
        btnRotate = new Button("Rotate");
        btnScale = new Button("Scale");
        btnTranslate = new Button("Translate");
        
        HBox rootNodeButton = new HBox(30, btnRotate, btnScale, btnTranslate);
        rootNodeButton.setAlignment(Pos.CENTER);
        
        btnParTrans = new Button("Pause/Resume(Sequencial Transition)");
        
        btnParTrans.setDisable(true);
        
        RotateTransition myRotate = new RotateTransition(Duration.seconds(2), btnRotate);
        myRotate.setAutoReverse(true);
        myRotate.setCycleCount(2);
        myRotate.setByAngle(360);
        //btnRun.setRotate(45);
        //myRotate.setAxis(Rotate.Y_AXIS);
        
        ScaleTransition myScale = new ScaleTransition(Duration.seconds(2), btnScale);
        myScale.setAutoReverse(true);
        myScale.setCycleCount(2);
        myScale.setByX(1);
        myScale.setByY(1);
        
        TranslateTransition myTranslate = new TranslateTransition(Duration.seconds(2), btnTranslate);
        myTranslate.setAutoReverse(true);
        myTranslate.setCycleCount(2);
        myTranslate.setByX(50);
        
        SequentialTransition SequeTrans = new SequentialTransition(myRotate, myScale, myTranslate);
        
        btnScale.setOnAction((event) -> {
            if (SequeTrans.getStatus() == Animation.Status.STOPPED) {
                response.setText("Scaling");
                
                btnParTrans.setDisable(false);
                
                SequeTrans.play();
            }else
                response.setText("Running in progress");
        });
        
        btnTranslate.setOnAction((event) -> {
            if (SequeTrans.getStatus() == Animation.Status.STOPPED) {
                response.setText("Translating");
                
                btnParTrans.setDisable(false);
                
                SequeTrans.play();
            }else
                response.setText("Running in progress");
        });
        
        btnRotate.setOnAction((event) -> {
            if (SequeTrans.getStatus() == Animation.Status.STOPPED) {
                response.setText("Rotating");
                
                btnParTrans.setDisable(false);
                
                SequeTrans.play();
            }else
                response.setText("Rotation already in progress");
        });
        
        btnParTrans.setOnAction((event) -> {
            if (SequeTrans.getStatus() == Animation.Status.RUNNING) {
                response.setText("Paused");
                
                SequeTrans.pause();
            }else if (SequeTrans.getStatus() == Animation.Status.PAUSED) {
                response.setText("Resumed");
                
                SequeTrans.play();
            }
        });
        
        SequeTrans.setOnFinished((event) -> {
            btnParTrans.setDisable(true);
            response.setText("Sequencial Transition Finished");
        });
        
        myRotate.setOnFinished((event) -> {
           response.setText("Rotation Finished");
           response.setTextFill(Color.GREEN);
        });
        
        myScale.setOnFinished((event) -> {
           response.setText("Scale Finished");
           response.setTextFill(Color.GREEN);
        });
        
        myTranslate.setOnFinished((event) -> {
           response.setText("Translate Finished");
           response.setTextFill(Color.GREEN);
        });
        
        rootNode.getChildren().addAll(rootNodeButton, btnParTrans, response);
        
        myStage.show();
    }
}
