// Miguel Afán Espinosa
// Practica 9
// RWFileMonitor.java

import java.util.concurrent.*;
import java.util.*;
import java.io.*;

public class RWFileMonitor{
	public static int n = 0;
	public static Object lector = new Object();
	public static Object escritor = new Object();
	public static boolean escribiendo;
	public static File fichero = new File("datos.dat");
	public Random x = new Random();
	
	public void inicia_lectura ()throws Exception{
		synchronized(lector){
		while(escribiendo) lector.wait();
		n++;
		RandomAccessFile f = new RandomAccessFile(fichero, "r");
		while(f.getFilePointer() <= f.length())
		System.out.println(f.readInt());
              	f.close();
		lector.notifyAll();
		}
	}
	public void fin_lectura (){
		synchronized(escritor){
		n--;
		if(n==0) escritor.notifyAll();
		}
	}
	public void inicia_escritura ()throws Exception{
		synchronized(escritor){
		while((n!=0) || (escribiendo)) escritor.wait();
		RandomAccessFile f = new RandomAccessFile(fichero, "rw");
		f.writeInt(x.nextInt(51));
		f.close();
		escribiendo=false;
		}
	}
	public void fin_escritura (){
		synchronized(lector){
		escribiendo=false;
		lector.notifyAll();
		}
	}
}
