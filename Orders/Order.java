/* Stephanie Sandoval - Caso 02
 * Order - Holds information for a client's order
 */

package Orders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;

import Flowers.Flower;
import People.Client;
import People.Employee;

public class Order implements Serializable{
    private ArrayList <ArrayList <Flower>> flowers;
    private ArrayList <ArrayList <Integer>> amounts;
    private String arrivalPlace;
    private LocalDate arrivalDate, dateProcessed;
    private Client client;
    private Employee employee;

    public Order (ArrayList <ArrayList <Flower>> flowers, ArrayList <ArrayList <Integer>> amounts, String arrivalPlace, LocalDate arrivalDate, LocalDate dateProcessed, Client client, Employee employee){
        this.flowers = flowers;
        this.amounts = amounts;
        this.arrivalPlace = arrivalPlace;
        this.arrivalDate = arrivalDate;
        this.dateProcessed = dateProcessed;
        this.client = client;
        this.employee = employee;
    }

    public ArrayList <ArrayList <Flower>> getFlowers (){
        return this.flowers;
    }

    public ArrayList <ArrayList <Integer>> getAmounts (){
        return this.amounts;
    }

    public String getArrivalPlace (){
        return this.arrivalPlace;
    }

    public LocalDate getArrivalDate (){
        return this.arrivalDate;
    }

    public LocalDate getDateProcessed (){
        return this.dateProcessed;
    }

    public Client getClient (){
        return this.client;
    }

    public Employee getEmployee (){
        return this.employee;
    }

    public void setFlowers (ArrayList <ArrayList <Flower>> flowers){
        this.flowers = flowers;
    }

    public void setAmounts (ArrayList <ArrayList <Integer>> amounts){
        this.amounts = amounts;
    }

    public void setArrivalPlace (String arrivalPlace){
        this.arrivalPlace = arrivalPlace;
    }

    public void setArrivalDate (LocalDate arrivalDate){
        this.arrivalDate = arrivalDate;
    }

    public void setDateProcessed (LocalDate dateProcessed){
        this.dateProcessed = dateProcessed;
    }

    public void setClient (Client client){
        this.client = client;
    }

    public void setEmployee (Employee employee){
        this.employee = employee;
    }
}