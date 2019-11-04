/*primosParalelos.java
 *@author A.T.
*/
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class primosParalelos {

  public static void main(String[] args) throws Exception {
    long nPuntos     = 100;
    int  nTareas     = Runtime.getRuntime().availableProcessors();
    long tVentana    = nPuntos/nTareas;
    long primosTotal = 0;
    long linf        = 0;
    long lsup        = tVentana;
    
    ArrayList<Future<Long>> contParciales =
      new ArrayList<Future<Long>>();
    long inicTiempo = System.nanoTime();  
    ThreadPoolExecutor ept = new ThreadPoolExecutor(
      nTareas,
      nTareas,
      0L,
      TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue<Runnable>());
    for(int i=0; i<nTareas; i++){
      contParciales.add(ept.submit(
      	 new tareaPrimos(linf, lsup)));
      linf=lsup+1;
      lsup+=tVentana;
    }  
    for(Future<Long> iterador:contParciales)
      try{
      	  primosTotal +=  iterador.get(); 
      }catch (CancellationException e){}
       catch (ExecutionException e){}
       catch (InterruptedException e){}     
    long tiempoTotal = (System.nanoTime()-inicTiempo)/(long)1.0e9;   
    ept.shutdown();
    System.out.println("Primos hallados: "+primosTotal);
    System.out.println("Calculo finalizado en "+tiempoTotal+" segundos");
 }   
}
