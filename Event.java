package com.jorge.project.ipaybills;

public class Event {
    private String name;
    private int maxPeople;

    public Event(String name, int maxPeople){
        this.name = name;
        this.maxPeople = maxPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", maxPeople=" + maxPeople +
                '}';
    }
}
