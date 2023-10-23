package Events;

public class EventPreview {
    
    private String date, company, location, status, description;

    public EventPreview (String date, String company, String location, String status, String description){
        this.date = date;
        this.company = company;
        this.location = location;
        this.status = status;
        this.description = description;
    }

    public void setDate (String date){
        this.date = date;
    }

    public void setCompany (String company){
        this.company = company;
    }

    public void setLocation (String location){
        this.location = location;
    }

    public void setStatus (String status){
        this.status = status;
    }

    public void setDescription (String description){
        this.description = description;
    }

    public String getDate (){
        return this.date;
    }

    public String getCompany (){
        return this.company;
    }

    public String getLocation (){
        return this.location;
    }

    public String getStatus (){
        return this.status;
    }

    public String getDescription (){
        return this.description;
    }
}