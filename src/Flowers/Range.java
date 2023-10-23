/* Stephanie Sandoval - Caso 02
 * Range class - Creates a range [minimum, maximum]
 */

package Flowers;

public class Range {
    private float minimum, maximum;

    public Range (float minimum, float maximum){
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public float getMinimum (){
        return this.minimum;
    }

    public float getMaximum (){
        return this.maximum;
    }

    public void setMinimum (float minimum){
        this.minimum = minimum;
    }

    public void setMaximum (float maximum){
        this.maximum = maximum;
    }

    public String toString (){
        return "range >> [" + this.minimum + " , " + this.maximum + "]";
    }
}