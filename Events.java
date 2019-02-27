package com.jorge.project.ipaybills;
import java.util.ArrayList;

public class Events implements EventInterface {
    private ArrayList<Event>events;
    private static Events object;

    private Events(ArrayList<Event> e){
        this.events = e;
    }
    
    public static Event getEventList(ArrayList<Event>events){
    	 if (object == null){
 	        object = new Event(events);
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
    
    public int size(){
        return events.size();
    }    
}
