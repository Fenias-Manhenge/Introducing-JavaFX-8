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

public class TextFieldDemo extends Application{
    
    TextField txtInput;
    
    Label response, anchor;
    
    Button btnString, btnReverse, btnClear, btnAnchor;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage){
        
        myStage.setTitle("Text Field");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
        rootNode.setAlignment(Pos.CENTER);
        rootNode.setPadding(new Insets(10));
        
        Scene myScene = new Scene(rootNode, 450, 200);
        
        myStage.setScene(myScene);
        
        txtInput = new TextField();
        
        response = new Label("String: ");
        anchor = new Label("Anchor: ");
        
        btnString = new Button("Get String");
        btnReverse = new Button("Reverse");
        btnClear = new Button("Clear");
        btnAnchor = new Button("Anchor");
        
        MenuItem miCopy = new CheckMenuItem("Copy");
        MenuItem miPaste = new CheckMenuItem("Paste");
        MenuItem miCut = new CheckMenuItem("Cut");
        
        txtInput.setContextMenu(new ContextMenu(miCopy, miPaste, miCut));
        txtInput.setPromptText("Enter a String");
        txtInput.setPrefColumnCount(10);
        
        Separator separetor = new Separator(Orientation.HORIZONTAL);
        
        separetor.setHalignment(HPos.CENTER);
        separetor.setPrefWidth(200);
        
        txtInput.setOnAction((event) -> {
            response.setText("String: " + txtInput.getText());
        });
        
        btnString.setOnAction((event) -> {
            response.setText("String: " + txtInput.getText());
        });
        
        btnReverse.setOnAction((event) -> {
            StringBuilder sb = new StringBuilder(txtInput.getText());
            txtInput.setText(sb.reverse().toString());
        });
        
        btnClear.setOnAction((event) -> {
            txtInput.clear();
        });
        
        btnAnchor.setOnAction((event) -> {
            anchor.setText("Anchor: " + String.valueOf(txtInput.getAnchor()));
            anchor.setText("Anchor: " + String.valueOf(txtInput.getCaretPosition()));
        });
        
        rootNode.getChildren().addAll(txtInput, btnString, btnReverse, btnAnchor, btnClear, separetor, anchor, response);
        
        myStage.show();
    }
}
