import java.util.Vector;
public class listeEvents
{
    Vector<Event> events;
    public listeEvents () {
        events = new Vector<Event>();
    }
    public void addEvent(Event newEvent) {
        int insertIndex = 0;
        while (insertIndex < events.size() ) {
            Event e = (Event) events.elementAt(insertIndex);
            if (e.getTime() > newEvent.getTime())
                break;
            insertIndex++;
        }
        events.insertElementAt(newEvent, insertIndex);
    }
    public Event getFirst() {
        Event e = this.events.firstElement();
        events.remove(0);
        return e;
    }
}
