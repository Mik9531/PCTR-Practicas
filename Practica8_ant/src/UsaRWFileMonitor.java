// Miguel Afán Espinosa
// Practica 9
// UsaRWFileMonitor.java


import java.util.*;
import java.util.concurrent.*;

public class UsaRWFileMonitor implements Runnable{
	public static Scanner x = new Scanner(System.in);
	public RWFileMonitor lef = new RWFileMonitor();
	public int i;
	
	
	UsaRWFileMonitor(int i, RWFileMonitor lef){ 	
		this.i = i;
		this.lef = lef;
	}
	public static void main(String[] args) throws Exception{
		System.out.println("Introduzca el numero de lectores y escritores");
		int nle = x.nextInt();					
		for(int j = 0; j<nle; j++){
		Thread l = new Thread(new UsaRWFileMonitor(0,new RWFileMonitor())); 
		l.start();
		Thread e = new Thread(new UsaRWFileMonitor(1,new RWFileMonitor())); 
		e.start();
		}
	}
	public void run(){ //Run
		for(;;){
			try{
				switch(i){
					case 0:	System.out.println("Leyendo el fichero");
						lef.inicia_escritura();
						lef.fin_escritura();
						break;
					case 1: System.out.println("Escribiendo en el fichero");
						lef.inicia_lectura();
						lef.fin_lectura();
						break;
				}
			}
			catch(Exception e){}
			}
	}
}
