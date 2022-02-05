package JavaFx_controls_Part2;

/**
 *
 * @author fenia
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.geometry.*;
//import javafx.beans.property.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.collections.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableViewDemo extends Application{
    
    Label response;
    
    TableView<ProjectEntry> tblProject;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) throws Exception {
        
        myStage.setTitle("Table View");
        myStage.getIcons().add(new Image(getClass().getResourceAsStream("table.png")));
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 20);
        rootNode.setPadding(new Insets(10));
        rootNode.setAlignment(Pos.CENTER);
        
        Scene myScene = new Scene(rootNode, 500, 350, Color.AQUAMARINE);
        myStage.setScene(myScene);
        
        response = new Label("");
        
        ObservableList<ProjectEntry> projEntries = FXCollections.observableArrayList(
                new ProjectEntry("Fenias", "Active", 3432423),
                new ProjectEntry("Gledse", "Active", 3432423),
                new ProjectEntry("Safura", "Active", 3432423),
                new ProjectEntry("Funasse", "Active", 3432423),
                new ProjectEntry("A.B", "Active", 3432423),
                new ProjectEntry("Fenias", "Active", 3432423),
                new ProjectEntry("Fenias", "Active", 3432423)
        );
        
        tblProject = new TableView<>(projEntries);
        tblProject.setPrefSize(300, 250);
        
        TableColumn<ProjectEntry, String> progName = new TableColumn<>("Programmer");
        progName.setCellValueFactory(new PropertyValueFactory<>("programmer"));
        tblProject.getColumns().add(progName);
        
        TableColumn<ProjectEntry, String> status = new TableColumn<>("Status");
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        tblProject.getColumns().add(status);
        
        TableColumn<ProjectEntry, Integer> size = new TableColumn<>("Size");
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        tblProject.getColumns().add(size);
        
        TableView.TableViewSelectionModel<ProjectEntry> ssmTblV = tblProject.getSelectionModel();
        
        ssmTblV.selectedIndexProperty().addListener((ov, t, t1) -> {
            response.setText("The Selected row is " + t1);
        });
        
        rootNode.getChildren().addAll(tblProject, response);
        
        myStage.show();
    }
    
}
