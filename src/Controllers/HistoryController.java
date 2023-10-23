package Controllers;

import Packages.PackageManager;

import java.util.ArrayList;

import Events.Event;
import Packages.Package;

public class HistoryController {
    
    private PackageManager packageManager;
    private Package clientPackage;

    public HistoryController (int packageID){
        this.packageManager = new PackageManager();
        this.clientPackage = packageManager.getObject(packageID);
    }

    public boolean packageExists (){
        return !(this.clientPackage == null);
    }

    public ArrayList <Event> getEvents (){
        return this.clientPackage.getEvents();
    } 
}