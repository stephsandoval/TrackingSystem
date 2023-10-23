package Flowers;

public class PreFlower {

    private String species;
    private String type;
    private float stemLength;
    private int amount;

    public PreFlower (String species, String type, float stemLength, int amount){
        this.species = species;
        this.type = type;
        this.stemLength = stemLength;
        this.amount = amount;
    }

    public String getSpecies (){
        return this.species;
    }

    public String getType (){
        return this.type;
    }

    public float getStemLength (){
        return this.stemLength;
    }

    public int getAmount (){
        return this.amount;
    }

    public String toString (){
        return "preflower > " + species + " | " + type + " | " + stemLength + " | " + amount;
    }
}