
package com.jorge.project.ipaybills.api;
import java.util.ArrayList;

public class Events implements EventInterface {
    // private "file android object" that will be initialized
    private ArrayList<Event>events;
    private static Events object;

    // Private constructor for singleton pattern
    private Events(){
        events = new ArrayList<>(); // Receive information from file stored in Android file system
    }

    public static Events getEventList(){
        if (object == null){
            object = new Events();
        }
        return object;
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public void removeEvent(Event event){
        events.remove(event);
    }

    public Event findByName(String event){
        int aux = 0;
        for (int i=0; i<events.size(); i++){
            if(event.equals(events.get(i).getName())){
                aux = i;
            }
        }
        return findById(aux);
    }

    public Event findById(int id){
        return events.get(id);
    }

    public String[] eventsToString(){
        String []eventsString = new String[events.size()];
        for(int i=0; i<events.size();i++){
            eventsString[i] = events.get(i).getName();
        }
        return eventsString;
    }

    public int size(){
        return events.size();
    }
}
