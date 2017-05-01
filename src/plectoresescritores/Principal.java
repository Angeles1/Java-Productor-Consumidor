
package plectoresescritores;

public class Principal {

    public static void main(String[] args) {
        GestorBDJusto gestor= new GestorBDJusto();
        Escritor[] esc = new Escritor[2];
        Lector[] lector = new Lector[10];
        
        for(int i =0; i<esc.length;i++){
            esc[i] = new Escritor(gestor,i);
        }
        for(int i =0; i<lector.length;i++){
            lector[i] = new Lector(gestor,i);
        }
        
        for(int i =0; i<esc.length;i++){
            esc[i].start();
        }
        for(int i =0; i<lector.length;i++){
            lector[i].start();
        }
        
        try{
            for(int i =0; i<esc.length;i++){
            esc[i].join();
        }
        for(int i =0; i<lector.length;i++){
            lector[i].join();
        }
        }catch(Exception ex){}
    }
    
}
