public class Client
{
    protected double tempsArrivee;
    protected double dureeService;
    protected double identifiant;
    
    public Client(double tempsArrivee, double dureeService,double identifiant) {
        this.tempsArrivee = tempsArrivee;
        this.dureeService = dureeService;
        this.identifiant = identifiant;
        
    }
    public double getArrivalTime() {
        return tempsArrivee;
    }
    public double getServiceTime() {
        return dureeService;
    }
    public double getIdentifiant() {
        return identifiant;
    }
}
