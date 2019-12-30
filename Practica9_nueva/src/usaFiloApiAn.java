/**
 * @author Miguel Afán Espinosa
 */

import java.util.concurrent.*;


public class usaFiloApiAn implements Runnable{
    private static int filosofos=0;
    private final int numFilo;
    private final filoApiAN monitor;
    
    


    public void run(){
        for(int i=0; i<5; i++){ 
            System.out.println("Filósofo "+numFilo+": -¡Quiero comer!");
            monitor.comer(numFilo);
            System.out.println("Filósofo " + numFilo + " comiendo...");

            try{
            Thread.currentThread().sleep(1000);}catch(Exception e){}  
                                                                    
            System.out.println("Filosofo "+numFilo+": -¡Ya he comido! Suelto mis tenedores.");
            monitor.soltarTenedores(numFilo);
           
            try{
            Thread.currentThread().sleep(1000);}catch(Exception e){}
        }

    }
    
    
  
    public usaFiloApiAn(filoApiAN monitor){
        numFilo = filosofos;
        filosofos++;
        this.monitor = monitor;        
    }
    
    
    public static void main(String[] args){
        filoApiAN monitor = new filoApiAN(5);
        
        ExecutorService ejecutor = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 5; i++) 
            ejecutor.execute(new usaFiloApiAn(monitor));
        
        ejecutor.shutdown();
        
        while (!ejecutor.isTerminated()) {
        }
        System.out.println("Ya hemos comido todos.");
    }
            


    }
    

