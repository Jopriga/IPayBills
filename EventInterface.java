package com.jorge.project.ipaybills;
import java.util.ArrayList;

public interface EventInterface {
    
    Event find(String name);
    void addEvent(Event e); //
    void removeEvent(Event e);
    int size();
    ArrayList<Event>getEvents();
    
}
