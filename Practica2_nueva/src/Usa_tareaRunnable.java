/** 
 * @author Miguel Afán Espinosa
 * @version 1.0
 * Usa la clase tareaRunnable.java (crece y decrece segun el número de iteraciones).
 */

import java.util.*;

public class Usa_tareaRunnable {
	
	/** Método main 
	* @param args 
	* @throws InterruptedException 
	*/
	
	public static void main(String[] args) throws InterruptedException{
		
		Scanner s = new Scanner (System.in);
		System.out.println("Introduzca el numero de iteraciones: ");
		int num = s.nextInt();
		tareaRunnable hebras = new tareaRunnable();
		tareaRunnable hebra1 = new tareaRunnable (true, num);
		tareaRunnable hebra2 = new tareaRunnable (false, num);
		new Thread(hebra1).start();
		new Thread(hebra2).start();
		
		
		
		System.out.println("El numero es: " +hebras.getN());
		
	}

}
