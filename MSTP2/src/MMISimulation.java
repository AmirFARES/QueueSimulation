public class MMISimulation
{
    double lambda;
    double mu;
    listeEvents liste;
    Queue q;
    double t;
    double n;

    public MMISimulation(double lambda,double mu,double n){
        this.lambda = lambda;
        this.mu = mu;
        this.n = n;
        q=new Queue();
        liste = new listeEvents();
    }
    public double expo(double taux){
        return -Math.log(Math.random())/taux;
    }
    /*public void simulate(double simLength){
    	int nb=0;
        t=0;
        Event s1 = new Event(0,0);
        listeEvents ol = new listeEvents();
        ol.addEvent(s1);
        Queue q = new Queue();
        int ci=1;
        while(nb<simLength){
            Event e = ol.getFirst();	
            t=e.getTime();
            if(e.type==0){
            	// creer l'arriver suivante
                Event en = new Event(0,t+expo(lambda));
                ol.addEvent(en);
                //
                if(q.lesClients.size()==n-1) {
                	q.addRejected(t);
                }else {
                	double ds=expo(mu);
                    Client c=new Client(t,ds,ci);
                    System.out.printf("Le client: %d est arrive a t=%.4f %n",ci,t);
                    q.add(c);
                    ci++;
                    if(q.lesClients.size()==1){
                        Event enn=new Event(1,t+ds);
                        ol.addEvent(enn);
                    }
                }
                
            }else{
        		Client ctmp=q.remove();
        		System.out.printf("Le client: %.0f commence son service a t=%.4f et la duree de son service= %.4f %n",ctmp.identifiant,t-ctmp.dureeService,ctmp.dureeService);
        		System.out.printf("Le client: %.0f a fini son service a t= %.4f %n",ctmp.identifiant,t);
        		while( (q.rejected.size()!=0) && (q.rejected.firstElement() <= t)) {
        			Double rejectedtmp = q.removeRejected();
        			System.out.printf("**************** Un client est rejecte au temps : %.4f ****************%n",rejectedtmp);
        		}
        		nb++;
        		if(q.lesClients.size()!=0) {
        			Event en = new Event(1,t+q.lesClients.firstElement().dureeService); // faute dans l'enonce c'est t+temp depart de next client 
        			//Event en = new Event(1,t+expo(mu);
        			ol.addEvent(en);
        		}
            }
        }
    }*/
    
    public void simulate(double simLength){
    	int nb=0;
        t=0;
        Event s1 = new Event(0,0);
        listeEvents ol = new listeEvents();
        ol.addEvent(s1);
        Queue q = new Queue();
        int ci=1;
        System.out.printf("  	ID	T Arr		DebServ		DurServ		tempTermine %n");
        while(nb<simLength){
            Event e = ol.getFirst();	
            t=e.getTime();
            if(e.type==0){
            	// creer l'arriver suivante
                Event en = new Event(0,t+expo(lambda));
                ol.addEvent(en);
                //
                if(q.lesClients.size()==n) {
                	q.addRejected(t);
                }else {
                	double ds=expo(mu);
                    Client c=new Client(t,ds,ci);
                    //System.out.printf("Le client: %d est arrive a t=%.4f %n",ci,t);
                    q.add(c);
                    ci++;
                    if(q.lesClients.size()==1){
                        Event enn=new Event(1,t+ds);
                        ol.addEvent(enn);
                    }
                }
                
            }else{
        		Client ctmp=q.remove();
        		//System.out.printf("Le client: %.0f commence son service a t=%.4f et la duree de son service= %.4f %n",ctmp.identifiant,t-ctmp.dureeService,ctmp.dureeService);
        		//System.out.printf("Le client: %.0f a fini son service a t= %.4f %n",ctmp.identifiant,t);
        		System.out.printf("	%.0f	%.3f		%.3f		%.3f		%.3f %n",ctmp.identifiant,ctmp.tempsArrivee,t-ctmp.dureeService,ctmp.dureeService,t);
        		while( (q.rejected.size()!=0) && (q.rejected.firstElement() <= t)) {
        			Double rejectedtmp = q.removeRejected();
        			System.out.printf("***** Un client est rejecte au temps : %.4f %n",rejectedtmp);
        		}
        		nb++;
        		if(q.lesClients.size()!=0) {
        			Event en = new Event(1,t+q.lesClients.firstElement().dureeService); // faute dans l'enonce c'est t+temp depart de next client 
        			//Event en = new Event(1,t+expo(mu);
        			ol.addEvent(en);
        		}
            }
        }
    }

    public static void main(String[] arg){
        MMISimulation s=new MMISimulation(0.5 , 0.3 , 4);
        s.simulate(60);
    }
}