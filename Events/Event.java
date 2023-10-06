/* Stephanie Sandoval - Caso 02
 * Event class - Holds information related to the events a package can go through
 * This class is used to indicate what has happened to the package
 */

package Events;

import java.time.LocalDate;
import java.util.ArrayList;

public class Event {
    private LocalDate date;
    private String location;
    private String company;
    private ArrayList <String> description;

    public Event (LocalDate date, String location, String company, ArrayList <String> description){
        this.date = date;
        this.location = location;
        this.company = company;
        this.description = description;
    }

    public LocalDate getDate (){
        return this.date;
    }

    public String getLocation (){
        return this.location;
    }

    public String getCompany (){
        return this.company;
    }

    public ArrayList <String> getDescription (){
        return this.description;
    }

    public void setDate (LocalDate date){
        this.date = date;
    }

    public void setLocation (String location){
        this.location = location;
    }

    public void setCompany (String company){
        this.company = company;
    }

    public void setDescription (ArrayList <String> description){
        this.description = description;
    }

    public void addToDescription (String newItem){
        description.add(newItem);
    }

    public String toString (){
        String objectDescription = "event >> date > " + date.toString() + " | location > " + location + " | company > " + company + " | description >";
        for (String item : description){
            objectDescription += " - " + item;
        }
        return objectDescription;
    }
}