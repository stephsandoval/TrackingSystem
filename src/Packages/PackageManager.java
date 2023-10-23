/* Stephanie Sandoval - Caso 02
 * Package Manager Class - In charge of updating a package
 * Based on what's happening to the package, he updates the information
 * Helped by the Record Processor
 */

package Packages;

import java.time.LocalDate;
import java.util.ArrayList;

import Events.Event;
import Records.RecordProcessor;

public class PackageManager {
    private int packageID;
    private Package clientPackage;
    private RecordProcessor recordProcessor;

    public PackageManager (){
        this.recordProcessor = new RecordProcessor();
    }

    public void updateObject (LocalDate date, String location, String company, String status, ArrayList <String> description, int packageID){
        clientPackage = getObject(packageID);
        Event event = new Event(date, location, company, status, description);
        clientPackage.addEvent(event);
        recordProcessor.saveObject(clientPackage);
    }

    public Package getObject (int packageID){
        return recordProcessor.getObject(packageID);
    }

    public int getPackageID (){
        return this.packageID;
    }

    public Package getPackage (){
        return this.clientPackage;
    }

    public void setPackageID (int packageID){
        this.packageID = packageID;
    }

    public void setPackage (Package clientPackage){
        this.clientPackage = clientPackage;
    }
}