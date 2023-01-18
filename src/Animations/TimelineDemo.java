package Animations;

/**
 *
 * @author fenia
 */

import javafx.animation.*;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class TimelineDemo extends Application{

    Button btnStart, btnPauseResume;
    
    Label lblResponse;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("Timeline");
        //myStage.getIcons().add(new Image(getClass().getResourceAsStream("timeline.png")));
        
        VBox rootNode = new VBox(30);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(15));
        
        Scene myScene = new Scene(rootNode, 250, 250, Color.valueOf("#DFECED"));
        
        myStage.setScene(myScene);
        
        btnStart = new Button("Start Timeline");
        btnPauseResume = new Button("Pause/Resume");
        btnPauseResume.setDisable(true);
        
        lblResponse = new Label("Push the Button");
        
        // Creating Key valaues that affects the scale x and y
        KeyValue kvScaleX = new KeyValue(btnStart.scaleXProperty(), 1.5);
        KeyValue kvScaleY = new KeyValue(btnStart.scaleYProperty(), 1.5);
        
        KeyValue kvRotation = new KeyValue(btnStart.rotateProperty(), 180);
        
        KeyFrame kf = new KeyFrame(Duration.seconds(2), kvScaleX, kvScaleY, kvRotation);
        
        Timeline tline = new Timeline(kf);
        tline.setCycleCount(4);
        tline.setAutoReverse(true);
        tline.getKeyFrames().add(kf);
        
        btnStart.setOnAction((event) -> {
            if (tline.getStatus() == Animation.Status.STOPPED) {
                lblResponse.setText("Animation started");
                
                btnPauseResume.setDisable(false);
                
                tline.play();
            }else
                lblResponse.setText("Animation already running");
        });
        
        btnPauseResume.setOnAction((event) -> {
            if (tline.getStatus() == Animation.Status.RUNNING) {
                lblResponse.setText("Animation paused");
                lblResponse.setTextFill(Color.RED);
                
                tline.pause();
            }else if (tline.getStatus() == Animation.Status.PAUSED) {
                lblResponse.setText("Animation Resumed");
                lblResponse.setTextFill(Color.GREEN);
                
                tline.play();
            }
        });
        
        tline.setOnFinished((event) -> {
           lblResponse.setText("Timeline animation finished");
           
           btnPauseResume.setDisable(true);
           
           lblResponse.setTextFill(Color.GREEN);
        });
        
        rootNode.getChildren().addAll(btnStart, btnPauseResume, lblResponse);
        
        myStage.show();
    }
}
