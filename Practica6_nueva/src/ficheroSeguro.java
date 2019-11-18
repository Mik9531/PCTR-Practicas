// Miguel Afán Espinosa
// Practica 7
// ServidorHilosinPool.java

import java.util.*;
import java.io.RandomAccessFile;

public class ficheroSeguro{
	static boolean escribiendo=false;	
	static Object c = new Object(); 
	static RandomAccessFile f;
	public static class Hilo1 extends Thread{ 
		public void run(){
			synchronized(c){ 
				String s="Escritura del hilo 1";
				escribir(s);
				System.out.println("Hilo 1: Escribiendo en el fichero");
			}
		}
	}
	public static class Hilo2 extends Thread{ 
		public void run(){
			synchronized(c){ 
				String s="Escritura del hilo 2";
				escribir(s);
				System.out.println("Hilo 2: Escribiendo en el fichero");
			}
		}
	}
	public static class Hilo3 extends Thread{ 
		public void run(){
			synchronized(c){
				String s="Escritura del hilo 3";
				escribir(s);
				System.out.println("Hilo 3: Escribiendo en el fichero");
			}
		}
	}
	public static void escribir(String s){ 
		escribiendo=true;
		try{f = new RandomAccessFile("fichero.txt", "rw"); 
		f.writeChars(s);
		}catch(Exception e){}
		escribiendo=false;
	}

	public static void main(String[] args) throws Exception{ 
		Thread a = new Hilo1();
		Thread b = new Hilo2();
		Thread c = new Hilo3();
		a.start();
		b.start();
		c.start();
	
		try{
		a.join();
		b.join();
		c.join();
		}
		catch(InterruptedException e){}
	}
}
