package Controllers;

import Packages.PackageManager;
import Packages.PackagePreview;
import Packages.PackagePreviewMaker;
import Screens.FTSAlert;

import java.time.LocalDate;
import java.util.ArrayList;

import Packages.Package;

public class UpdateController {

    private PackageManager packageManager;
    private PackagePreviewMaker packagePreviewMaker;
    private Package clientPackage;

    public UpdateController (int packageID){
        this.packageManager = new PackageManager();
        this.clientPackage = packageManager.getObject(packageID);
        this.packagePreviewMaker = new PackagePreviewMaker(clientPackage);
    }

    public boolean packageExists (){
        return !(this.clientPackage == null);
    }

    public String returnPackagePreview (){
        return this.clientPackage.toString();
    }

    public ArrayList <PackagePreview> getPreview (){
        return this.packagePreviewMaker.getPreview();
    }

    public void sendInfo (String location, String company, String status, LocalDate date, ArrayList<String> description){
        String message = "The package was updated";
        packageManager.updateObject(date, location, company, status, description, clientPackage.getPackageID());
        FTSAlert.getInstance().showAlert(message);
    }
}