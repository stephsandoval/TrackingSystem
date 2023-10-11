/* Stephanie Sandoval - Caso 02
 * Client class - Holds information related to the clients
 */

package People;

import java.io.Serializable;

public class Client implements Serializable{
    private String name;
    private int clientID;

    public Client (String name, int clientID){
        this.name = name;
        this.clientID = clientID;
    }

    public String getName (){
        return this.name;
    }

    public int getClientID (){
        return this.clientID;
    }

    public void setName (String name){
        this.name = name;
    }

    public void setClientID (int clientID){
        this.clientID = clientID;
    }

    public String toString (){
        return "client >> name > " + name + " | id > " + clientID;
    }
}