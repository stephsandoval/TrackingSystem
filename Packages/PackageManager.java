/* Stephanie Sandoval - Caso 02
 * Package Manager Class - In charge of updating a package
 * Based on what's happening to the package, he updates the information
 * Helped by the Record Processor
 */

package Packages;

import java.time.LocalDate;
import java.util.ArrayList;

import Events.Event;

public class PackageManager {
    private int packageID;
    private Package clientPackage;
    //private RecordProcessor recordProcessor;
    private Event event;

    public PackageManager (int packageID){
        this.packageID = packageID;
    }

    private void createEvent (LocalDate date, String location, String company, ArrayList <String> description){
        event = new Event(date, location, company, description);
    }

    public void updateObject (LocalDate date, String location, String company, ArrayList <String> description){
        createEvent(date, location, company, description);
        // recordProcessor.getObject (something)
        // recordProcessor.updateObject (something)
    }

    public int getPackageID (){
        return this.packageID;
    }

    public Package getPackage (){
        return this.clientPackage;
    }

    /* the processor will probably work as some "static" method to reference it just one time
    public RecordProcessor getProcessor (){
        return this.recordProcessor
    }
    */

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