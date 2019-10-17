
/** 
 * @author Miguel Afán Espinosa
 * @version 1.0
 * Emplea la clase hebra.java.
 */

import java.util.Scanner;

public class Usa_hebra {

	/**
	 * Método main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws InterruptedException {

		Scanner s = new Scanner(System.in);
		System.out.println("Introduzca el número de iteraciones: ");
		int num = s.nextInt();
		hebra hebras = new hebra();
		Thread hebra1 = new hebra(true, num);
		Thread hebra2 = new hebra(false, num);
		hebra1.start();
		hebra2.start();
		hebra1.join();
		hebra2.join();
		hebras.mostrar();

	}

}
