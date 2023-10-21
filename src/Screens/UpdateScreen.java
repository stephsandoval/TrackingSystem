package Screens;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Json.JsonParser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateScreen extends ScreenChanger implements Initializable{
    
    @FXML
    private TextField screenPackageID, screenLocation, screenCompany, screenDescription;
    @FXML
    private ChoiceBox <String> screenStatus;
    @FXML
    private Button addDescriptionButton, finishUpdateButton, searchButton;
    @FXML
    private DatePicker screenDate;

    private JsonParser items = JsonParser.getInstance();

    private ArrayList <String> description = new ArrayList<>();
    private String location, company, status;
    private LocalDate date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        screenStatus.getItems().setAll(items.getStatus());
    }

    public void addDescription (){
        description.add(screenDescription.getText());
        screenDescription.clear();
        System.out.println(description);
    }

    public void finishUpdate (){
        location = screenLocation.getText();
        company = screenCompany.getText();
        status = screenStatus.getValue();
        date = screenDate.getValue();
    }

    public void searchID (){
        int packageID = Integer.valueOf(screenPackageID.getText());
        // send id to the controller to check
        // expects something from the controller related to whether the package exists
    }
}