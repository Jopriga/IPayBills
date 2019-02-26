import java.util.ArrayList;

public class Events implements EventInterface {
    private ArrayList<Event>events;

    public Events(ArrayList<Event> e){
        this.events = e;
    }

    public void addEvent(Event event){
        events.add(event);
    }

    public void removeEvent(Event event){
        events.remove(event);
    }

    public Event find(String event){
        int aux = 0;
        for (int i=0; i<events.size(); i++){
            if(event.equals(events.get(i).getName())){
               aux = i;
            }
        }
        return events.get(aux);
    }

    public ArrayList<Event> getEvents(){
        return events;
    }
}
