
package com.jorge.project.ipaybills.api;

public interface EventInterface {
    Event findById(int id);
    Event findByName(String name);
    void addEvent(Event e); //
    void removeEvent(Event e);
    String[] eventsToString();
    int size();
}
