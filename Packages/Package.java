/* Stephanie Sandoval - Caso 02
 * Package class - Holds information of the packages generated
 */

package Packages;

import java.time.LocalDate;
import java.util.ArrayList;

import Events.Event;
import Flowers.Bouquet;

public class Package {
    private LocalDate dateProcessed, arrivalDate;
    private int clientID, employeeID, packageID;
    private ArrayList <Bouquet> bouquets;
    private String arrivalPlace, status, location;
    private ArrayList <String> notes;
    private float price;
    private ArrayList <Event> events;
    private boolean complete;

    public Package (LocalDate dateProcessed, LocalDate arrivalDate, int clientID, int employeeID, ArrayList <Bouquet> bouquets, String arrivalPlace, String status, String location, float price, boolean complete){
        this.dateProcessed = dateProcessed;
        this.arrivalDate = arrivalDate;
        this.clientID = clientID;
        this.employeeID = employeeID;
        this.bouquets = bouquets;
        this.arrivalPlace = arrivalPlace;
        this.status = status;
        this.location = location;
        this.price = price;
        this.complete = complete;
        this.notes = new ArrayList<>();
        this.events = new ArrayList<>();
        generatePackageID();
    }

    private void generatePackageID (){
        this.packageID = IDGenerator.getInstance().getNewID();
    }

    public LocalDate getDateProcessed (){
        return this.dateProcessed;
    }

    public LocalDate getArrivalDate (){
        return this.arrivalDate;
    }

    public int getClientID (){
        return this.clientID;
    }

    public int getEmployeeID (){
        return this.employeeID;
    }

    public int getPackageID (){
        return this.packageID;
    }

    public ArrayList <Bouquet> getBouquets (){
        return this.bouquets;
    }

    public String getArrivalPlace (){
        return this.arrivalPlace;
    }

    public String getStatus (){
        return this.status;
    }

    public String getLocation (){
        return this.location;
    }

    public float getPrice (){
        return this.price;
    }

    public boolean isComplete (){
        return this.complete;
    }

    public ArrayList <String> getNotes (){
        return this.notes;
    }

    public ArrayList <Event> getEvents (){
        return this.events;
    }

    public void setDateProcessed (LocalDate dateProcessed){
        this.dateProcessed = dateProcessed;
    }

    public void setArrivalDate (LocalDate arrivalDate){
        this.arrivalDate = arrivalDate;
    }

    public void setClientID (int clientID){
        this.clientID = clientID;
    }

    public void setEmployeeID (int employeeID){
        this.employeeID = employeeID;
    }

    public void setPackageID (int packageID){
        this.packageID = packageID;
    }

    public void setBouquets (ArrayList <Bouquet> bouquets){
        this.bouquets = bouquets;
    }

    public void setArrivalPlace (String arrivalPlace){
        this.arrivalPlace = arrivalPlace;
    }

    public void setStatus (String status){
        this.status = status;
    }

    public void setLocation (String location){
        this.location = location;
    }

    public void setNotes (ArrayList <String> notes){
        this.notes = notes;
    }

    public void setPrice (float price){
        this.price = price;
    }

    public void setComplete (boolean complete){
        this.complete = complete;
    }

    public void setEvents (ArrayList <Event> events){
        this.events = events;
    }


    public void addNote (String note){
        this.notes.add(note);
    }

    public void addEvent (Event event){
        this.events.add(event);
    }

    public String toString (){
        String objectDescription = "package >>> ";
        objectDescription += "\n arrival date > " + arrivalDate.toString() + "\n date processed > " + dateProcessed.toString();
        objectDescription += "\n clientID > " + clientID + "\n employeeID > " + employeeID + "\n packageID > " + packageID + "\n bouquets >> ";
        for (Bouquet bouquet : bouquets){
            objectDescription += bouquet.toString() + " | ";
        }
        objectDescription += "\n arrival place > " + arrivalPlace + "\n status > " + status + "\n location > " + location;
        objectDescription += "\n price > $" + price + "\n complete > " + complete + "\n notes > ";
        for (String note : notes){
            objectDescription += note + " | ";
        }
        objectDescription += "\n events >> ";
        for (Event event : events){
            objectDescription += event.toString() + " | ";
        }
        return objectDescription;
    }
}