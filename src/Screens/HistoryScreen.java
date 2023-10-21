package Screens;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HistoryScreen extends ScreenChanger{
    
    @FXML
    private TextField screenPackageID;
    @FXML
    private Button searchButton;
    @FXML
    private TableView <String> historyTable;

    public void searchID (){
        int packageID = Integer.valueOf(screenPackageID.getText());
        // send id to the controller to check
        // expects something from the controller related to whether the package exists
        // if the package exists, show history in table
    }
}