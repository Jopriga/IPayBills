package com.jorge.project.ipaybills.api;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * This class represents the actions to perform for saving the state of the app, managing files
 * in the internal memory of the device.
 * @author Jopriga
 * @version 19/04/2019
 * @see com.jorge.project.ipaybills.MainActivity
 * @see com.jorge.project.ipaybills.NewEventActivity
 * @see com.jorge.project.ipaybills.RemovePersonActivity
 *
 */

public class FileSystem {

    private static String FILE = "events.txt";
    private static FileSystem object;
    private Events events;

    private FileSystem(Events e){
        this.events = e;
    }

    public static FileSystem getFileSystem(Events e) {
        if (object == null) {
            object = new FileSystem(e);
        }
        return object;
    }

    public void addEventToFile(String event, Context context){
        try{
            FileOutputStream fos = context.openFileOutput(FILE, Context.MODE_APPEND);
            String text = event+ "\n";
            fos.write(text.getBytes());
            fos.close();

        } catch (Exception e){
            Log.e("File system", e.getMessage(), e);
        }

        this.createNewFileForEvent(event,context);
    }

    private void createNewFileForEvent(String event, Context context){
        try{
            FileOutputStream fos = context.openFileOutput(event, Context.MODE_APPEND);
            String text = "";
            fos.write(text.getBytes());
            fos.close();
        } catch (Exception e){
            Log.e("File system", e.getMessage(), e);
        }
    }

    private String getEventInformation(Event event){
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<event.getPeople().size();i++){
            builder.append(event.getPeople().findById(i).getName()).append(" ")
                    .append(event.getPeople().findById(i).getPaid()).append("\n");
        }

        for(int j=0; j<event.getMovements().size();j++){
                builder.append("Movement").append(" ").append(event.getMovements().findById(j).getPerson().getName())
                        .append(" ").append(event.getMovements().findById(j).getName())
                        .append(" ").append(event.getMovements().findById(j).getMoney()).append("\n");
        }

        for(int k=0; k<event.getPayments().size();k++){
                builder.append("Payment").append(" ").append(event.getPayments().find(k).getFrom().getName())
                        .append(" ").append(event.getPayments().find(k).getMoney()).append(" ")
                        .append(event.getPayments().find(k).getTo().getName()).append("\n");

        }
        return builder.toString();
    }

    // Escribe en fichero
    public void updateEventInformation(String event, Context context){

        this.emptyFile(context, event);
        String eventInfo = this.getEventInformation(events.findByName(event));

        try{
            FileOutputStream fos = context.openFileOutput(event, Context.MODE_APPEND);
            fos.write(eventInfo.getBytes());
            fos.close();
        } catch (Exception e){
            Log.e("File system", e.getMessage(), e);
        }
    }


    private void setEventInfoIntoApi(String event, Context context, ArrayList<String> people,
                                     ArrayList<String> movements, ArrayList<String> payments){
        // Dado un evento, busca el fichero que contiene su info para ir insertandola en las
        // estructuras de las api
        try{
            FileInputStream fis = context.openFileInput(event);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            do{
                line = reader.readLine();
                if(line!=null){
                    if(line.startsWith("Movement")){
                        movements.add(line);
                    }
                    else if(line.startsWith("Payment")){
                        payments.add(line);
                    }
                    else people.add(line);
                }
            }while(line!=null);
            fis.close();
        } catch(Exception e){
            Log.e("File System", e.getMessage(), e);
        }

        for(int i=0; i<people.size();i++){
             String person = people.get(i);
             String[] separated = person.split(" ");
             EventList.getEventList().findByName(event).addPerson(separated[0]);
        }

        for(int j=0; j<movements.size();j++){
            String movement = movements.get(j);
            String[] separated_2 = movement.split(" ");
            float money = Float.parseFloat(separated_2[3]);

            EventList.getEventList().findByName(event).addMovement(separated_2[2],money,separated_2[1]);
        }
        if(payments.size()!=0){
            EventList.getEventList().findByName(event).settleUp();
        }
    }


    public Events getEventsFromFile(Context context){
        try{
            FileInputStream fis = context.openFileInput(FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;
            boolean added;
            do{
                line = reader.readLine();
                added = false;
                if(line!=null) {

                    for (int i=0; i<events.size();i++){
                        if(events.findById(i).getName().equals(line)){
                            added = true;
                            break;
                        }
                    }
                    if(!added){
                        events.addEvent(new Event(line, new PeopleList(new ArrayList<Person>()),
                                new MovementList(new ArrayList<Movement>()), new PaymentList
                                (new ArrayList<Payment>())));
                        this.setEventInfoIntoApi(line, context, new ArrayList<String>(),
                                new ArrayList<String>(), new ArrayList<String>());
                    }
                }
            }while(line!=null);
            fis.close();
        }catch(Exception e){
            Log.e("File System", e.getMessage(), e);
        }
        return events;
    }

    private void emptyFile(Context context, String file){
        try{
            FileInputStream fis = context.openFileInput(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            FileOutputStream fos = context.openFileOutput(file, Context.MODE_PRIVATE);

            String line;
            do{
                line = reader.readLine();
                if(line!=null){
                    line ="";
                    fos.write(line.getBytes());
                }

            }while(line!=null);
            fis.close();
            fos.close();
        }catch(Exception e){
            Log.e("File System", e.getMessage(), e);
        }
    }

    public void removeEventFromFile(Context context){
        this.emptyFile(context, FILE);
        try{
            FileOutputStream fos = context.openFileOutput(FILE, Context.MODE_APPEND);
            String text;
            for(int i=0; i<events.size();i++){
                text = events.findById(i).getName()+ "\n";
                fos.write(text.getBytes());
            }
            fos.close();
        } catch (Exception e){
    
        Log.e("File system", e.getMessage(), e);
        }
    }
}    
