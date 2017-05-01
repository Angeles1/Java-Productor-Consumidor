
package pFilosofos;


public class Filosofo extends Thread {
    private int id;
    private Tenedor izq,der;
    private Silla s;
    public Filosofo(int id, Tenedor izq, Tenedor der, Silla s){
        this.id=id;
        this.izq=izq;
        this.der=der;
        this.s=s;
    }
    
    public void run(){
        while(true){
            try{
                s.gSilla(id);
                izq.gTenedor(id);
                der.gTenedor(id);
                //comer
                der.sTenedor(id);
                izq.sTenedor(id);
                s.sSilla(id);
            }catch(Exception ex){}
            
        }
    }

}
