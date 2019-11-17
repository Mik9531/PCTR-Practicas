// Miguel Afán Espinosa
// Practica 7
// ServidorHilosinPool.java






import java.net.*;
import java.io.*;

import java.util.*;

public class ServidorHilosinPool implements Runnable{
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
    	    int puerto = 2004; 
    	    try{ServerSocket chuff = new ServerSocket (puerto, 3000);
    	    	    while (true){
    	    	    System.out.println("Esperando solicitud de conexion...");
    	    	    Socket cable = chuff.accept();
    	    	    System.out.println("Recibida solicitud de conexion...");
    	    	    Thread hilo = new Thread(new Servidor_Hilos(cable));
    	    	}
    	    }
    	    catch (Exception e){System.out.println("Error en sockets...");}
    }
}
