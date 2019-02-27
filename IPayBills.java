package com.jorge.ipaybillsproyect.ipaybillsjava;

import java.util.ArrayList;

public class IPayBills {

    public static void main(String args[]){
        
        EventInterface events = new Events(new ArrayList<Event>());

        events.addEvent(new Event("fiesta",4));
        events.addEvent(new Event("cena",2));
        events.addEvent(new Event("compra",3));
        events.addEvent(new Event("viaje",4));
        events.removeEvent(events.findByName("fiesta"););
        events.addEvent(new Event("comida",5));
        
        for(int i=0;i<events.size();i++){
            System.out.println(events.findById(i).toString());
        }
    }
