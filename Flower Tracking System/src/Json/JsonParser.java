package Json;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;


public class JsonParser {
    
    private static JsonParser instance;
    private JsonArray jsonObjects;

    private JsonParser (){
        
    }

    public static synchronized JsonParser getInstance (){
        // only allow one instance of this object
        // this avoids having to read the file multiple times throught the program
        if (instance == null){
            instance = new JsonParser();
        }
        return instance;
    }
}