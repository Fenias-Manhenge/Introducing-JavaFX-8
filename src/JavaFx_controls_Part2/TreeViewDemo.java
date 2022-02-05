package JavaFx_controls_Part2;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.image.*;

public class TreeViewDemo extends Application{
    
    TreeView<String> tvFamily;
    
    Button btnExpand;
    
    Label lblResponse;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void start(Stage myStage){
        
        myStage.setTitle("TreeView");
        myStage.setResizable(true);
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("Tree.png")));
                
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);
        rootNode.setPadding(new Insets(20));
        rootNode.setAlignment(Pos.TOP_CENTER);
        
        Scene myScene = new Scene(rootNode, 400, 600, Color.ALICEBLUE);
        myScene.getStylesheets().add(getClass().getResource("/JavaFx_controls_Part2/TreeView.css").toExternalForm());
        myStage.setScene(myScene);
        
        lblResponse = new Label("No selection");
        
        // TreeItems of Brothers
        TreeItem<String> tiPais = new TreeItem<>("Fenias/Maria");
        
        TreeItem<String> tiErcilia = new TreeItem<>("Ercilia");
        TreeItem<String> tiGo = new TreeItem<>("Go");
        TreeItem<String> tiBetinho = new TreeItem<>("Betinho");
        TreeItem<String> tiPedrito = new TreeItem<>("Pedrito");
        TreeItem<String> tiRosinha = new TreeItem<>("Rosinha");
        TreeItem<String> tiJunior = new TreeItem<>("Junior");
        TreeItem<String> tiLeu = new TreeItem<>("Leu");
        TreeItem<String> tiMiguel = new TreeItem<>("Miguel");
        tiPais.getChildren().addAll(tiErcilia, tiGo, tiBetinho, tiPedrito, tiRosinha, tiJunior, tiLeu, tiMiguel);
        
        // TreeItems Ercilia
        TreeItem<String> tiCochi = new TreeItem<>("Cochi");
        TreeItem<String> tiGenito = new TreeItem<>("Genito");
        tiErcilia.getChildren().addAll(tiCochi, tiGenito);
        
        // TreeItems Go
        TreeItem<String> tiMaria = new TreeItem<>("Maria");
        TreeItem<String> tiMica = new TreeItem<>("Mica Wanga");
        tiGo.getChildren().addAll(new TreeItem<>("Maria"), new TreeItem<>("Mica Wanga"));
        
        // TreeItems Betinho
        TreeItem<String> tiCleisia = new TreeItem<>("Cleisia");
        TreeItem<String> tiLaiza = new TreeItem<>("Laiza");
        tiBetinho.getChildren().addAll(tiCleisia, tiLaiza);
        
        // TreeItem Pedrito
        TreeItem<String> tiAri = new TreeItem<>("Ariane");
        TreeItem<String> tiAyla = new TreeItem<>("Ayla");
        tiPedrito.getChildren().addAll(tiAri, tiAyla);
        
        // TreeItem Rosinha
        TreeItem<String> tiAyler = new TreeItem<>("Ayler");
        tiRosinha.getChildren().add(tiAyler);
        
        tvFamily = new TreeView<>(tiPais);
        
        lblResponse = new Label("Select a Item");
        
        MultipleSelectionModel<TreeItem<String>> tvSelModel = tvFamily.getSelectionModel();
        
        tvSelModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // constract the entire path to the selected item
                String path = newValue.getValue();
                
                TreeItem<String> tiPath = newValue.getParent();
                
                while (tiPath != null) {                    
                    path = tiPath.getValue() + " -> " + path;
                    tiPath = tiPath.getParent();
                }
                
                lblResponse.setText("Selection is " + newValue.getValue() + "\nComplete path is " + path);
            }
        });
        
        btnExpand = new Button("Expand/Collapse");
        btnExpand.setId("btnExpand");
        
        btnExpand.setOnAction((event) -> {
            TreeItem<String> tmp = tvFamily.getSelectionModel().getSelectedItem();
            
            if (tmp.isExpanded()) {
                tmp.setExpanded(false);
            }else 
                tmp.setExpanded(true);
        });
        
        Separator separator = new Separator(Orientation.HORIZONTAL);
        separator.autosize();
        
        rootNode.getChildren().addAll(tvFamily, lblResponse, separator, btnExpand);
        
        myStage.show();
    }
}
