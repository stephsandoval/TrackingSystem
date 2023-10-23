package Controllers;

import Packages.PackageManager;
import Packages.PackagePreview;
import Packages.PackagePreviewMaker;

import java.util.ArrayList;

import Events.EventPreviewMaker;
import Events.EventPreview;
import Packages.Package;

public class HistoryController {
    
    private PackageManager packageManager;
    private PackagePreviewMaker packagePreviewMaker;
    private EventPreviewMaker eventPreviewMaker;
    private Package clientPackage;

    public HistoryController (int packageID){
        this.packageManager = new PackageManager();
        this.clientPackage = packageManager.getObject(packageID);
        this.packagePreviewMaker = new PackagePreviewMaker(clientPackage);
        this.eventPreviewMaker = new EventPreviewMaker(clientPackage.getEvents());
    }

    public boolean packageExists (){
        return !(this.clientPackage == null);
    }

    public ArrayList <EventPreview> getEvents (){
        return this.eventPreviewMaker.getPreview();
    }

    public ArrayList <PackagePreview> getPreview (){
        return this.packagePreviewMaker.getPreview();
    }
}