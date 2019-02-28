package com.jorge.project.ipaybills;

public class Event {
    private String name;
    private int maxPeople;
    private People people;

    public Event(String name, int maxPeople, People people){
        this.name = name;
        this.maxPeople = maxPeople;
        this.setPeople(people);
    }
	
    public void addPerson(String name){
    	Person person = new Person(name);
    	people.add(person);
    }
    
    public void removePerson(String name){
    	people.remove(people.findByName(name));
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
    
    public PeopleList getPeople() {
		return people;
	}

	public void setPeople(PeopleList people) {
		this.people = people;
	}
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", maxPeople=" + maxPeople +
                '}';
    }
}
