
package pFilosofos;


public class Silla {
    private int sLibre=4;
    
    public synchronized void gSilla(int i ){
        try{
            while(sLibre==0){
                wait();
            }
        }catch(Exception ex){}
        System.out.println("Filósofo "+i+ " coge una silla");
        sLibre--;
    }
    
    public synchronized void sSilla(int i ){
        System.out.println("Filósofo "+i+ " suelta una silla");
        sLibre++;
        notify();
    }

}
