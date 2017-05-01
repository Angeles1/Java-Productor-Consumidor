
package plectoresescritores;


public class GestorBDJusto {
    private int nLectores=0;
    private boolean hayEscritor=false;
    private int nEscritores=0;
    
    
    public synchronized void openL(int id){
        while(hayEscritor || nEscritores>0){
            try{
                wait();
            }catch(Exception exc){}
        }
        nLectores++;
        System.out.println("Lector "+id+" entra en la BD");
    }
    
    public synchronized void closeL(int id){
        System.out.println("Lector "+id+" sale de la BD");
        nLectores--;
        if(nLectores == 0) notifyAll();
    }
    
    public synchronized void openE(int id){
        nEscritores++;
        while(hayEscritor || nLectores > 0){
            try{
                wait();
            }catch(Exception ex){}
        }
        hayEscritor = true;
        System.out.println("Escritor "+id+" entra en la BD");
    }
    
    public synchronized void closeE(int id){
        nEscritores--;
        System.out.println("Escritor "+id+" sale de la BD");
        hayEscritor=false;
        notifyAll();
    }
}
