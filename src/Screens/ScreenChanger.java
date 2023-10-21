package Screens;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ScreenChanger {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void loadAddScreen (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void loadUpdateScreen (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("UpdateScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void loadHistoryScreen (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HistoryScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void loadLogInScreen (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LogInScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
