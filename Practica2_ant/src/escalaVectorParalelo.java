// Miguel Af�n Espinosa
// Practica 2 
// escalaVectorParalelo.java


import java.util.*;

import java.math.*;
public class escalaVectorParalelo extends Thread{
	private int inicio,fin;
	static double n;
	public escalaVectorParalelo (int inicio,int fin){
		this.inicio=inicio;
		this.fin=fin;
		
	}
	
	public void run(){
		double [] vector= new double[10000000];
		 
			for (int i=0;i<vector.length;i++){
				vector[i]=Math.random();
			}
			for (int i=0;i<10000000;i++)	{
			
				 System.out.println("El resultado es: "+vector[i]*n);
	}
	}
	
	/** Main
	 * @param args 
	 * @throws InterruptedException
	 */
	
	public static void main(String[] args)throws Exception{
		
		System.out.println("Introduzca el escalar: ");
	    Scanner s = new Scanner (System.in);
		n = s.nextDouble();
		
		escalaVectorParalelo h1 = new escalaVectorParalelo(0,2499999);
		escalaVectorParalelo h2 = new escalaVectorParalelo(25000000,49999999);
		escalaVectorParalelo h3 = new escalaVectorParalelo(50000000,74999999);
		escalaVectorParalelo h4 = new escalaVectorParalelo(75000000,99999999);
	  
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h1.join();
		h2.join();
		h3.join();
		h4.join();
		
		}
	
}
//Supuestos
//cores=4
//los hilos seran:
//h1=new h(0,24)
//h2=new h(25,49)...