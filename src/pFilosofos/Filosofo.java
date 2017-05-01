
package pFilosofos;


public class Filosofo extends Thread {
    private int id;
    private Tenedor izq,der;
    public Filosofo(int id, Tenedor izq, Tenedor der){
        this.id=id;
        this.izq=izq;
        this.der=der;
    }
    
    public void run(){
        while(true){
            try{
                izq.gTenedor(id);
                der.gTenedor(id);
                //comer
                der.sTenedor(id);
                izq.sTenedor(id);
            }catch(Exception ex){}
            
        }
    }

}
