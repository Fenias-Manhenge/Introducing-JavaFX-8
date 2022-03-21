package Images_Icons;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;

public class ImageViewDemo extends Application{
    
    Label lblImgView, lblImage;
    
    Button btnImage;
    
    CheckBox leu, miguel, junior;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("Image View");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("imageView.png")));
        
        VBox rootNode = new VBox(10);
        rootNode.setAlignment(Pos.TOP_LEFT);
        rootNode.setPadding(new Insets(20));
        
        Scene myScene = new Scene(rootNode, 450, 700);
        myStage.setScene(myScene);
        
        
        lblImgView = new Label("Displaying with ImageView");
        ImageView img = new ImageView(new Image(getClass().getResourceAsStream("image_flow.jfif"), 300, 300, true, true));

        lblImage = new Label("Displaying with Label");
        Label lblImg = new Label("Aprendendo", imageScaling("image_abstract.jfif", 300, 300, true, true));
        lblImg.setContentDisplay(ContentDisplay.TOP);
        
        btnImage = new Button("Add image", image("image_add.png"));
        
        leu = new CheckBox("Miguel");
        miguel = new CheckBox("Leu");
        junior = new CheckBox("Junior");
        
        leu.setGraphic(imageScaling("person.png", 30, 30, true, true));
        miguel.setGraphic(imageScaling("person.png", 30, 30, true, true));
        junior.setGraphic(imageScaling("person.png", 30, 30, true, true));
        
        rootNode.getChildren().addAll(lblImgView, img, lblImage, lblImg, btnImage, leu, miguel, junior);
        
        myStage.show();
    }
    
    ImageView image(String typeImage){
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(typeImage)));
        return imageView;
    }
    
    ImageView imageScaling(String typeImage, double width, double height, boolean aspectRatio, boolean quality){
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(typeImage), width, height, aspectRatio, quality));
        return imageView;
    }
}
