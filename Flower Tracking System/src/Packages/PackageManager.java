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
    private Event event;

    public PackageManager (Package clientPackage){
        this.clientPackage = clientPackage;
        this.packageID = clientPackage.getPackageID();
        this.recordProcessor = new RecordProcessor();
    }

    private void createEvent (LocalDate date, String location, String company, ArrayList <String> description){
        event = new Event(date, location, company, description);
    }

    public void updateObject (LocalDate date, String location, String company, ArrayList <String> description){
        if (recordProcessor.hasRecord(packageID)){
            clientPackage = getObject(packageID);
        }
        createEvent(date, location, company, description);
        clientPackage.addEvent(event);
        recordProcessor.updateObject (clientPackage);
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

    public void setEvent (Event event){
        this.event = event;
    }
}