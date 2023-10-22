package Screens;

import javafx.scene.control.Alert;

public class FTSAlert extends Alert{
    
    private static FTSAlert instance;

    private FTSAlert (){
        super(AlertType.INFORMATION);
    }

    public static synchronized FTSAlert getInstance (){
        if (instance == null){
            instance = new FTSAlert();
        }
        return instance;
    }

    public void showAlert (String message){
        this.setContentText(message);
        this.showAndWait();
    }
}