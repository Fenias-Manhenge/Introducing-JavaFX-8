package JavaFx_controls_Part2;

/**
 *
 * @author fenia
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.input.KeyCode;

public class TextAreaDemo extends Application{
    
    TextArea txtInput;
    
    Label response;
    
    //Button btnString, btnReverse, btnClear, btnAnchor;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("Text Area");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(10));
        
        Scene myScene = new Scene(rootNode, 350, 250);
        
        myStage.setScene(myScene);
        
        txtInput = new TextArea();
        
        response = new Label("String: ");
        
        txtInput.setPromptText("Enter a String");
        txtInput.setPrefColumnCount(10);
        txtInput.setPrefRowCount(5);
        txtInput.setTooltip(new Tooltip("Degite qualquer coisa"));
        
        Separator separetor = new Separator(Orientation.HORIZONTAL);
        
        separetor.setHalignment(HPos.CENTER);
        separetor.setPrefSize(250, 10);
        
        txtInput.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                response.setText(txtInput.getText());
            }
        });
        
        rootNode.getChildren().addAll(txtInput, separetor, response);
        
        myStage.show();
    }
}
