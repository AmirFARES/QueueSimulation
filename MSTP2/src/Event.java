public class Event
{
    protected int type;
    protected double instant;
    
    public Event(int type, double instant) {
        this.type = type;
        this.instant = instant;
    }
    public int getType() {
        return type;
    }
    public double getTime() {
        return instant;
    }
}