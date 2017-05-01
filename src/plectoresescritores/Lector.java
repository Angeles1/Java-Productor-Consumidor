
package plectoresescritores;

import java.util.*;


public class Lector extends Thread {
    private static Random r = new Random();
    private GestorBDJusto gestor;
    private int id;//identificador del lector
    
    public Lector(GestorBDJusto gestor, int id){
        this.gestor=gestor;
        this.id=id;
    }
    
    public void run(){
        while(true){
            gestor.openL(id);
            try {
                Thread.sleep(r.nextInt(200));
                gestor.closeL(id);
                Thread.sleep(r.nextInt(200));
            } catch (InterruptedException ex) {}
            //leyendo BD
        }
    }

}
