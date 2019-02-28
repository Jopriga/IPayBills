package com.jorge.ipaybillsproyect.ipaybillsjava;

import java.util.ArrayList;

public class IPayBills {

    public static void main(String args[]){
        
        EventInterface events = Events.getEventList();

        events.findByName("fiesta").addPerson("jorge");
        events.findByName("fiesta").addPerson("javain");
        events.findByName("fiesta").addPerson("leo");
        events.findByName("fiesta").addPerson("luis");
        
        events.findByName("cena").addPerson("jorge");
        events.findByName("cena").addPerson("javain");
        events.findByName("cena").addPerson("leo");
        events.findByName("cena").addPerson("luis");

        events.removeEvent(events.findByName("compra"));
        
        events.findByName("cena").removePerson("leo");
        events.findByName("cena").removePerson("javain");
        
        events.findByName("fiesta").addMovement("pinocho", 20, "leo");
        events.findByName("fiesta").addMovement("vychio", 5.5f, "jorge");
        events.findByName("fiesta").addMovement("lebon", 2, "luis");
        events.findByName("fiesta").addMovement("celtica", 2.5f, "leo");
        events.findByName("fiesta").addMovement("churros", 28.5f, "javain");
        events.findByName("fiesta").addMovement("yogur", 10.5f, "luis");
        events.findByName("fiesta").addMovement("helado", 30.4f, "jorge");
      
       events.findByName("fiesta").removeMovement("helado");
        
        for(int i=0;i<events.size();i++){
            System.out.println(events.findById(i).toString());
            
            for(int j=0;j<events.findById(i).getPeople().size();j++){
            	System.out.println(events.findById(i).getPeople().findById(j).toString());
            }
            System.out.println();
        }
    }
