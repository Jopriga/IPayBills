package com.jorge.project.ipaybills;

public interface EventInterface {
    
    Event findByName(String name);
    Event findById(int id);
    void addEvent(Event e); //
    void removeEvent(Event e);
    int size();
}
