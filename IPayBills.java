package com.jorge.ipaybillsproyect.ipaybillsjava;

import java.util.ArrayList;
import java.util.Scanner;

public class IPayBills {

    private static void menu(){
        System.out.println("Select an option" +"\n"+
                "1. New Event" +"\n"+
                "2. My Events" +"\n"+
                "3. Exit");
    }

    private static void processMenu(Events events){
        Scanner sc = new Scanner(System.in);
        menu();
        switch(sc.nextInt()){
            case 1:
                System.out.println("Enter the name and max number of participants: ");
                events.addEvent(new Event(sc.next(),sc.nextInt()));
                break;
            case 2:
                events.toString();
                System.out.println("Do you want to remove any event? (1:Yes, 2:No)");
                if(sc.nextInt()== 1){
                    System.out.println("Enter the name: ");
                    String nameEvent = sc.next();
                    events.removeEvent(events.find(nameEvent));
                } else{ events.toString();}
                break;
            case 3:
                System.exit(0);
                break;
             default:
                 System.out.println("Invalid option");
                 break;
        }
        sc.close();
    }

    public static void main(String args[]){
        System.out.println("Starting IPayBills...");
        Events events = new Events(new ArrayList<Event>());
        while(true){
            processMenu(events);
        }
    }
