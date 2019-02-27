package com.jorge.project.ipaybills;
import java.util.ArrayList;

public interface EventInterface {
    
    Event findByName(String name);
    Event findById(int id);
    void addEvent(Event e); //
    void removeEvent(Event e);
    int size();
    ArrayList<Event>getEvents();
    
}
