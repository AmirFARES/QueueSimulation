import java.util.Vector;
public class Queue
{
    Vector<Client> lesClients;
    public Queue() {
        lesClients = new Vector<Client>();
    }
    public  void add(Client cl){
        this.lesClients.add(cl);
    }
    public Client remove() {
        Client e = this.lesClients.firstElement();
        lesClients.remove(0);
        return e;
    }
}
