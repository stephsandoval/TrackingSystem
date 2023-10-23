package Controllers;

import Packages.PackageManager;
import Packages.PackagePreview;
import Packages.PackagePreviewMaker;

import java.util.ArrayList;

import Events.Event;
import Packages.Package;

public class HistoryController {
    
    private PackageManager packageManager;
    private PackagePreviewMaker packagePreviewMaker;
    private Package clientPackage;

    public HistoryController (int packageID){
        this.packageManager = new PackageManager();
        this.clientPackage = packageManager.getObject(packageID);
        this.packagePreviewMaker = new PackagePreviewMaker(clientPackage);
    }

    public boolean packageExists (){
        return !(this.clientPackage == null);
    }

    public ArrayList <Event> getEvents (){
        return this.clientPackage.getEvents();
    }

    public ArrayList <PackagePreview> getPreview (){
        return this.packagePreviewMaker.getPreview();
    }
}