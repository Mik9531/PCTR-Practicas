// Miguel Afán Espinosa
// Practica 7
// clienteMultiple.java

import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class clienteMultiple{
	public static void main (String[] args){
       int n = 100;
       ExecutorService ejecutor = Executors.newFixedThreadPool(n); 
       long inicTiempo = System.currentTimeMillis(); 
	for(int j=0; j<n; j++){
		ejecutor.execute(new Hilo(j));
	}
	ejecutor.shutdown();
	while(!ejecutor.isTerminated()){}
	long tiempoTotal = System.currentTimeMillis()-inicTiempo;
    	System.out.println("Calculo finalizado en "+tiempoTotal+" milisegundos");
    }
    public static class Hilo implements Runnable{
    	   public static int i = (int)(Math.random()*10);
    	   public Hilo(int i){ 
    	Hilo.i = i;
    	    }
    	    public void run(){ 
    	    	    try{System.out.println("Realizando conexion...");
    	    	    	   Socket cable = new Socket("localhost", 2004);
    	    	    	   System.out.println("Realizada conexion a "+cable);
    	    	    	   PrintWriter salida= new PrintWriter(
                                 new BufferedWriter(
                                     new OutputStreamWriter(
                                      	     cable.getOutputStream())));
                            salida.println(i);
                            salida.flush();
                            System.out.println("Cerrando conexion...");
                            cable.close();
			}catch (Exception e){System.out.println("Error en sockets...");}
	    }
    }
}

