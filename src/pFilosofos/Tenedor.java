
package pFilosofos;


public class Tenedor extends Thread{
    private int id;
    private boolean libre=true;
    
    public Tenedor(int id){
        this.id=id;
    }
    public synchronized void gTenedor(int i){
        try{
            while(!libre){
                wait();                
            }
        }catch(Exception ex){}
        System.out.println("Filósofo "+i+ " coge tenedor "+id);
    }
    
    public synchronized void sTenedor(int i){
        libre=true;
        System.out.println("Filósofo "+i+ " suelta el tenedor "+id);
        notify();
    }

}
