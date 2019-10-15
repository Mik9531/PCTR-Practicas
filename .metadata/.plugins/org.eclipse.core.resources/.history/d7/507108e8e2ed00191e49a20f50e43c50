/** 
 * @author Miguel Afán Espinosa
 * @version 1.0
 */

import java.util.*;

public class Usa_hebra {
	
	/** Método main 
	* @param args 
	* @throws InterruptedException 
	*/
	
	public static void main(String[] args) throws InterruptedException{
		
		Scanner s = new Scanner (System.in);
		System.out.println("Introduzca el número de iteraciones");
		int num = s.nextInt();
		hebra hilos = new hebra();
		Thread hilo1 = new hebra(true, num);
		Thread hilo2 = new hebra(false, num);
		hilo1.start();
		hilo2.start();
		hilo1.join();
		hilo2.join();
		hilos.mostrar();
		
		
	}


}
