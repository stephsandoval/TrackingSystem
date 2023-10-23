package Events;

import java.util.ArrayList;

public class EventPreviewMaker {
 
    private ArrayList <Event> events;
    private ArrayList <EventPreview> preview;

    public EventPreviewMaker (ArrayList <Event> events){
        this.events = events;
        this.preview = new ArrayList<>();
        createPreview();
    }

    private void createPreview (){
        for (Event event : events){
            addEvent(event);
        }
    }

    private void addEvent (Event event){
        ArrayList <String> descriptions = event.getDescription();
        for (String description : descriptions){
            preview.add(new EventPreview(event.getDate().toString(), event.getCompany(), event.getLocation(), event.getStatus(), description));
        }
    }

    public ArrayList <EventPreview> getPreview (){
        return this.preview;
    }
}