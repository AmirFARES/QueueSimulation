import java.util.Vector;
public class Queue
{
    Vector<Client> lesClients;
    Vector<Double> rejected;
    public Queue() {
        lesClients = new Vector<Client>();
        rejected = new Vector<Double>();
    }
    public  void add(Client cl){
        this.lesClients.add(cl);
    }
    public void addRejected(Double c) {
    	this.rejected.add(c);
    }
    public Double removeRejected() {
    	 Double r = this.rejected.firstElement();
         rejected.remove(0);
         return r;
    }
    public Client remove() {
        Client e = this.lesClients.firstElement();
        lesClients.remove(0);
        return e;
    }
}
