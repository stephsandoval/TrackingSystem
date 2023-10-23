package Packages;


public class PackagePreview {
 
    private String item;
    private String content;

    public PackagePreview (String item, String content){
        this.item = item;
        this.content = content;
    }

    public String getItem (){
        return this.item;
    }

    public String getContent (){
        return this.content;
    }
}