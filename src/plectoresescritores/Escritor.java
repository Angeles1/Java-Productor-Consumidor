
package plectoresescritores;

import java.util.*;
public class Escritor extends Thread{
    private static Random r = new Random();
    private GestorBDJusto gestor;
    private int id;//identificador del lector
    
    public Escritor(GestorBDJusto gestor, int id){
        this.gestor=gestor;
        this.id=id;
    }
    
    public void run(){
        while(true){
            try{
                gestor.openE(id);
                Thread.sleep(r.nextInt(200));
                //escribir en BD
                gestor.closeE(id);
                Thread.sleep(r.nextInt(200));
            }catch(Exception ex){}
            
        }
    }
}
