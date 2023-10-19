/* Stephanie Sandoval - Caso 02
 * ID Generator Class - creates ID's for the different objects of the system
 * Uses singleton to make sure the ID's are not repeated
 */

package Packages;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IDGenerator {
    
    private static IDGenerator instance;
    private Set <Integer> set;

    private IDGenerator (){
        set = new HashSet <Integer> ();
    }

    public static synchronized IDGenerator getInstance (){
        // only allow one instance of this object
        // this, to ensure there are no repeated IDs
        if (instance == null){
            instance = new IDGenerator();
        }
        return instance;
    }

    public int getNewID (){
        Random random = new Random();
        int ID;
        do{
            // get an integer id that is not on the set
            ID = random.nextInt(10000000);
        } while (set.contains(ID));
        return ID;
    }
}