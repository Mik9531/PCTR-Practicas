
/**
 * @author Miguel Afán Espinosa
 */

import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class reentrantServer
  extends Thread
{
    Socket enchufe;
    private static double total=0;
    private static int cont = 0;
    private static final Lock o = new ReentrantLock();
    public reentrantServer(Socket s)
    {enchufe = s; this.start();}

    public void run()
    {
    double iniTiempo = System.nanoTime();

    try{
        BufferedReader entrada = new BufferedReader(
                                    new InputStreamReader(
                                        enchufe.getInputStream()));
        
        
        System.out.println("El hilo "+this.getName()+" conectando cliente a página web");
        enchufe.close();
        System.out.println("El hilo "+this.getName()+"cierra su conexion...");
    } catch(Exception e) {}

    
    o.lock();
    try{
    double tiempoTotal = (System.nanoTime() - iniTiempo)/1.0e9;	
    total+=tiempoTotal;
    cont++;
    System.out.println("tiempo Total="+total+"segundos");
    System.out.println("Contador = "+cont);
    }finally{o.unlock();}
    }
    
public static void main (String[] args)
{
    int i;
    int puerto = 2001;
    int tamPool = Runtime.getRuntime().availableProcessors();
	
    ThreadPoolExecutor miPool = new ThreadPoolExecutor(tamPool, tamPool, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
       
	 try{
            ServerSocket chuff = new ServerSocket (puerto, 3000);

            while (true){
                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();
                System.out.println("Recibida solicitud de conexion...");	 
		miPool.execute(new reentrantServer(cable));
        }
      } catch (Exception e)
        {System.out.println("Error en sockets...");}
}

}

