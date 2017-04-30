/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productor.consumidor;

//Consumidor = si hay tarta le restamos 1 a la variable tarta
//consumidor= si no hay tarta, despierto al cocinero y me duermo
//cocinero = me duermo esperando a que mellamen
//cocinero= si me llaman produzco 1o porciones de tarta y me duermo
public class principal implements Runnable{
    
    private boolean consumidor;
    private static int tarta=0;
    private static Object lock= new Object();
    
    public principal(boolean consumidor){
        this.consumidor=consumidor;
    }
    
    @Override
    public void run(){
        while(true){
            if(consumidor){
                consumiendo();
            }
            else{
                cocinando();
            }
        }
        
    }
    
    private void cocinando(){
        synchronized(lock){
            if(tarta==0){
                tarta=10;
                System.out.println("Soy el cocinero y quedan: "+tarta+" porciones");
                lock.notifyAll();
            }
            try{
                lock.wait();//el cocinero se va a dormir
            }catch(Exception e){}
        }
    }
    
    private void consumiendo(){
        synchronized(lock){
            if(tarta>0){
                tarta--;
                System.out.println("Quedan "+tarta+" porciones de la tarta");
                try{
                    Thread.sleep(1000); //dormimos la ejecucion del programa en 1 segundo
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            else{
                lock.notifyAll(); //despertamos a todos los hilos porq no podemos despetar a un hilo en concreto
                try{
                    lock.wait();
                }catch (Exception e){}
            }
        }
    }


    public static void main(String[] args) {
        int numHilos=11; //10 clientes y 1 cocinero
        Thread[] hilos = new Thread[numHilos];
        
        for (int i=0; i<hilos.length; i++){
            Runnable runnable = null;
            if(i != 0){
                runnable = new principal(true);
            }
            else{
                runnable = new principal(false);
            }
            hilos[i] = new Thread(runnable);
            hilos[i].start();
        
        }
        for(int i =0; i<hilos.length;i++){
            try{
                hilos[i].join();
            }catch(Exception e){}
        }
        

    }
    
}
