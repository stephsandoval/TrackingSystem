/* Stephanie Sandoval - Caso 02
 * Employee class - Holds information related to the employees of the company
 */

package People;

import Orders.Order;

public class Employee {
    private String name;
    private int employeeID;
    private String company;
    private Order order;

    public Employee (String name, int employeeID, String company){
        this.name = name;
        this.employeeID = employeeID;
        this.company = company;
    }

    public void takeOrder (){

        // should call the createOrder here
        // but first the employee needs to get the information from the user
        // since that implementation is not the same for console and for GUI
        // this part will be delayed until there's more about the GUI

        // also, depending on how the information comes from the GUI
        // this method might be recalled to createOrder
        // and the other would be removed

        // createOrder(...)

        // new note: when the employee takes the order, it should ask for an arraylist of an arraylist of flowers
        // same for the amounts of every flower (arraylist of an arraylist of integers)
        // reason: a bouquet may contain more than one flower type, and a client may ask for more than one bouquet

        // when taking the order and creating the client's id, refer to the IDGenerator of the Package class
        // this way, the ID will not be repeated
    }

    /*
    private Flower takeFlowers (Scanner scan){
        Flower flower;
        String type, species;
        float stemLength;

        System.out.println("*** FLOWER ***");
        System.out.print("Please enter the type of the flower > ");
        type = scan.nextLine();
        System.out.print("Please enter the species of the flower > ");
        species = scan.nextLine();
        System.out.print("Please enter the desired stem length > ");
        stemLength = scan.nextFloat();

        flower = new Flower(type, species, stemLength);

        return flower;
    }

    private void createOrder (ArrayList <Flower> flowers, ArrayList <Integer> amounts, String arrivalPlace, Date arrivalDate, Date dateProcessed, Client client){
        order = new Order(flowers, amounts, arrivalPlace, arrivalDate, dateProcessed, client, this);
    }
*/

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
        return "employee > " + name + ", id : " + employeeID + ", company : " + company;
    }
}