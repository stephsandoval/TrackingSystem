package People;

import Orders.Order;

public class Client {
    private String name;
    private int clientID;
    private Order order;

    public Client (String name, int clientID, Order order){
        this.name = name;
        this.clientID = clientID;
        this.order = order;
    }

    public String getName (){
        return this.name;
    }

    public int getClientID (){
        return this.clientID;
    }

    public Order getOrder (){
        return this.order;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setClientID (int clientID){
        this.clientID = clientID;
    }

    public void setOrder (Order order){
        this.order = order;
    }

    public String toString (){
        return "Client > " + name + ", id : " + clientID + ", order " + order.toString();
    }
}