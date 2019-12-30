
/**
 * @author Miguel Afán Espinosa
 */

import java.util.concurrent.CyclicBarrier;

public class triatlonBarreras
        implements Runnable {

    private static int indice = -1;
    private final int numCorredor;
    private final static double v[] = new double[100];
    private final CyclicBarrier c1, c2, c3;
    

    /** Constructor de triatlonBarreras
    *@param c1 Representa la primera meta del triatlon
    *@param c2 Representa la segunda meta del triatlon
    *@param c3 Representa la tercera meta del triatlon
    */
    public triatlonBarreras(CyclicBarrier c1, CyclicBarrier c2, CyclicBarrier c3){
        indice++;
        numCorredor=indice;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    

    public static void ganador(double[] v){
        double tiempo=v[0];
        int ind = 0;
        
        for(int i=0; i<99; i++){
            if(v[i]>tiempo){
                tiempo = v[i];
                ind = i;
            } 
        }
        
        System.out.println("El ganador es el atleta numero: "+ind+" con un tiempo de: "+tiempo);
    }
    


    public void run(){
        
        double aux = Math.random()*200;
        
        try{
        Thread.currentThread().sleep((long)aux);
        }catch(Exception s1){System.out.println("ERROR EN EL TIEMPO");}
        
        v[numCorredor] = aux;
        try{
        c1.await();
        }catch(Exception e1){System.out.println("ERROR");};
        
        aux = Math.random()*200;
        
        try{
        Thread.currentThread().sleep((long)aux);
        }catch(Exception s1){System.out.println("ERROR EN EL TIEMPO");}
        
        v[numCorredor]+=aux;
        try{
            c2.await();
        }catch(Exception e2){System.out.println("ERROR");}
        
        
        aux = Math.random()*200;
        
        try{
        Thread.currentThread().sleep((long)aux);
        }catch(Exception s1){System.out.println("ERROR EN EL TIEMPO");}

        v[numCorredor]+=aux;
        try{
            c3.await();
        }catch(Exception e3){System.out.println("ERROR");}   

    }
        
    

    public static void main(String[] args) throws Exception{
        
        CyclicBarrier c1 = new CyclicBarrier(100);
        CyclicBarrier c2 = new CyclicBarrier(100);
        CyclicBarrier c3 = new CyclicBarrier(100);
        
        Thread[] hilos = new Thread[100];
        
        for(int i=0; i<100; i++){
            hilos[i] = new Thread(new triatlonBarreras(c1, c2, c3));
        }
            
        for(int i=0; i<100; i++){
            hilos[i].start();
        }
        for(int i=0; i<100; i++){
            hilos[i].join();
        }
        
        ganador(v);             
    }    
}
