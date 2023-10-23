package Controllers;

import Packages.PackageManager;
import Screens.FTSAlert;

import java.time.LocalDate;
import java.util.ArrayList;

import Packages.Package;

public class UpdateController {

    private PackageManager packageManager;
    private Package clientPackage;

    public UpdateController (int packageID){
        this.packageManager = new PackageManager();
        this.clientPackage = packageManager.getObject(packageID);
    }

    public boolean packageExists (){
        return !(this.clientPackage == null);
    }

    public String returnPackagePreview (){
        return this.clientPackage.toString();
    }

    public void sendInfo (String location, String company, String status, LocalDate date, ArrayList<String> description){
        String message = "The package was updated";
        packageManager.updateObject(date, location, company, status, description, clientPackage.getPackageID());
        FTSAlert.getInstance().showAlert(message);
    }
}