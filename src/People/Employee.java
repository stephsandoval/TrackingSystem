/* Stephanie Sandoval - Caso 02
 * Employee class - Holds information related to the employees of the company
 */

package People;

import Orders.Order;
import Packages.IDGenerator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import Flowers.Flower;

public class Employee implements Serializable{
    private String name;
    private int employeeID;
    private String company;
    private Order order;

    public Employee (String name, int employeeID, String company){
        this.name = name;
        this.employeeID = employeeID;
        this.company = company;
    }

    public void takeOrder (ArrayList <ArrayList <Flower>> flowers, ArrayList <ArrayList <Integer>> amounts, String arrivalPlace, LocalDate arrivalDate, LocalDate dateProcessed, String clientName){
        Client client = createClient(clientName);
        order = new Order(flowers, amounts, arrivalPlace, arrivalDate, dateProcessed, client, this);
    }

    private Client createClient (String name){
        int clientID = IDGenerator.getInstance().getNewID();
        Client client = new Client(name, clientID);
        return client;
    }

    public Order getOrder (){
        return this.order;
    }

    public String getName (){
        return this.name;
    }

    public int getEmployeeID (){
        return this.employeeID;
    }

    public String getCompany (){
        return this.company;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setEmployeeID (int employeeID){
        this.employeeID = employeeID;
    }

    public void setCompany (String company){
        this.company = company;
    }

    public String toString (){
        return "employee >> name > " + name + " | id > " + employeeID + " | company > " + company;
    }
}