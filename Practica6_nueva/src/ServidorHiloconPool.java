/**
 * @author Miguel Afán Espinosa
 */






import java.net.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServidorHiloconPool implements Runnable{
    Socket enchufe;
    public void Servidor_Hilos(Socket s){enchufe = s;}
    public static Scanner x = new Scanner(System.in);

    public void run(){ //Run
    	    try{
    	    	    BufferedReader entrada = new BufferedReader(
                                    new InputStreamReader(
                                        enchufe.getInputStream()));
                    String datos = entrada.readLine();
                    int j;
                    int i = Integer.valueOf(datos).intValue();
                    for(j=1; j<=20; j++){
                    	System.out.println("El hilo "+Thread.currentThread().getName()+" escribiendo el dato "+i);
                    	Thread.sleep(1000);}
                    	enchufe.close();
                    	System.out.println("El hilo "+Thread.currentThread().getName()+"cierra su conexion...");
    		} catch(Exception e) {System.out.println("Error...");}
    }

    public static void main (String[] args){
    	    int i;
    	    int puerto = 2003;
    	    int nNuc = Runtime.getRuntime().availableProcessors(); 
    	    float Cb = x.nextFloat(); 
    	    int tamPool = (int)(nNuc/(1-Cb)); 
    	    try{ThreadPoolExecutor ejecutor = new ThreadPoolExecutor( 
		tamPool, tamPool, 0L, //Tamaño minimo, maximo y latencia
		TimeUnit.MILLISECONDS,
		new LinkedBlockingQueue<Runnable>());
	        ServerSocket chuff = new ServerSocket (puerto, 3000);
    	    	    while (true){
    	    	    	    System.out.println("Esperando solicitud de conexion...");
    	    	    	    Socket cable = chuff.accept();
    	    	    	    System.out.println("Recibida solicitud de conexion...");
    	    	    	    ejecutor.execute(new Servidor_Hilos(cable));
    	    	    }
    	    	}
    	    catch (Exception e){System.out.println("Error en sockets...");}
    }

}

