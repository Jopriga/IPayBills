package com.jorge.ipaybillsproyect.ipaybillsjava;

import java.util.ArrayList;

public class IPayBills {

    public static void main(String args[]){
        
        EventInterface events = Events.getEventList(new ArrayList<Event>());

        events.addEvent(new Event("fiesta",4,new PeopleList(new ArrayList<Person>())));
        events.addEvent(new Event("cena",2,new PeopleList(new ArrayList<Person>())));
        events.addEvent(new Event("compra",3,new PeopleList(new ArrayList<Person>())));
        events.addEvent(new Event("viaje",4,new PeopleList(new ArrayList<Person>())));
        
        events.findByName("fiesta").getPeople().addPerson(new Person("jorge"));
        events.findByName("fiesta").getPeople().addPerson(new Person("javain"));
        events.findByName("fiesta").getPeople().addPerson(new Person("leo"));
        events.findByName("fiesta").getPeople().addPerson(new Person("luis"));
        
        events.findByName("cena").getPeople().addPerson(new Person("jorge"));
        events.findByName("cena").getPeople().addPerson(new Person("javain"));
        events.findByName("cena").getPeople().addPerson(new Person("leo"));
        events.findByName("cena").getPeople().addPerson(new Person("luis"));

        events.removeEvent(events.findByName("compra"));
        events.findByName("cena").getPeople().removePerson(events.findByName("cena").getPeople().findByName("leo"));
        events.findByName("cena").getPeople().removePerson(events.findByName("cena").getPeople().findByName("javain"));

        events.addEvent(new Event("viajesss",4,new PeopleList(new ArrayList<Person>())));
        
        for(int i=0;i<events.size();i++){
            System.out.println(events.findById(i).toString());
            
            for(int j=0;j<events.findById(i).getPeople().size();j++){
            	System.out.println(events.findById(i).getPeople().findById(j).toString());
            }
            System.out.println();
        }
    }
