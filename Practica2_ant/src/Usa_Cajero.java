// Miguel Afán Espinosa
// Practica 3
// Usa_Cajero.java


public class Usa_Cajero{
	
	
public static void main(String[] args)throws InterruptedException{
	Runnable [] caja1 = new Cajero[1000];
	Runnable [] caja2 = new Cajero[1000];
	Thread [] hilos1 = new Thread[1000];
	Thread [] hilos2 = new Thread[1000];
	for(int i=0;i<1000;i++){
	caja1[i]=new Cajero(true,100000);
	caja2[i]=new Cajero(false,100000);
	}
	
	for(int i=0;i<1000;i++){
		hilos1[i]=new Thread(caja1[i]);
		hilos2[i]=new Thread(caja2[i]);
	}
	
	for(int i=0;i<1000;i++){ 
		hilos1[i].start(); hilos2[i].start();
		}
	for(int i=0;i<1000;i++) {
		hilos1[i].join(); hilos2[i].join();
		}
	Cajero.show();
}
    
    
}
