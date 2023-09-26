package Orders;

import java.util.ArrayList;
import java.util.Date;

import Flowers.Flower;
import People.Client;
import People.Employee;

public class Order {
    private ArrayList <Flower> flowers;
    private ArrayList <Integer> amounts;
    private String arrivalPlace;
    private Date arrivalDate, dateProcessed;
    private Client client;
    private Employee employee;

    public Order (ArrayList <Flower> flowers, ArrayList <Integer> amounts, String arrivalPlace, Date arrivalDate, Date dateProcessed, Client client, Employee employee){
        this.flowers = flowers;
        this.amounts = amounts;
        this.arrivalPlace = arrivalPlace;
        this.arrivalDate = arrivalDate;
        this.dateProcessed = dateProcessed;
        this.client = client;
        this.employee = employee;
    }

    public ArrayList <Flower> getFlowers (){
        return this.flowers;
    }

    public ArrayList <Integer> getAmounts (){
        return this.amounts;
    }

    public String getArrivalPlace (){
        return this.arrivalPlace;
    }

    public Date getArrivalDate (){
        return this.arrivalDate;
    }

    public Date getDateProcessed (){
        return this.dateProcessed;
    }

    public Client getClient (){
        return this.client;
    }

    public Employee getEmployee (){
        return this.employee;
    }
}