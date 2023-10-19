/* Stephanie Sandoval - Caso 02
 * Flower class - Holds information for each flower
 */

package Flowers;
import java.io.Serializable;

public class Flower implements Serializable {
    private String type;
    private String species;
    private float stemLength;

    public Flower (){
        this.type = "";
        this.species = "";
        this.stemLength = 0.0f;
    }

    public Flower (String type, String species, float stemLength){
        this.type = type;
        this.species = species;
        this.stemLength = stemLength;
    }

    public String getType (){
        return this.type;
    }

    public String getSpecies (){
        return this.species;
    }

    public float getStemLength (){
        return this.stemLength;
    }

    public void setType (String type){
        this.type = type;
    }

    public void setSpecies (String species){
        this.species = species;
    }

    public void setStemLength (float stemLength){
        this.stemLength = stemLength;
    }

    public String toString (){
        return "flower >> type : " + this.type + ", species : " + this.species + ", stemLength : " + stemLength;
    }

    public boolean equalTo (Object object){
        // a flower is considered equal to another if their type and species are the same
        // should the stem length be considered too?
        
        if (this == object){
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Flower flower = (Flower) object;
        return type.equals(flower.getType()) && species.equals(flower.getSpecies());
    }
}