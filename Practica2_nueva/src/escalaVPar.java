/** 
 * @author Miguel Afán Espinosa
 * @version 1.0
 * Esta clase realiza el escalado de un vector de forma paralela y multihebrada.
*/

import java.util.Scanner;

public class escalaVPar extends Thread {

	int inicio, fin;
	static int escalar;

	public escalaVPar(int inicio, int fin) {

		this.inicio = inicio;
		this.fin = fin;

	}

	public void run() {

		int[] vector = new int[100000000];

		for (int i = inicio; i < fin; i++) {
			System.out.println(i);
			vector[i] = (int) (Math.random() * 1000);
			System.out.println("El resultado es: " + vector[i] * escalar);
		}
	}

	/**
	 * Main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws Exception {

		System.out.println("Introduzca el escalar: ");
		Scanner s = new Scanner(System.in);
		escalar = s.nextInt();

		escalaVPar h1 = new escalaVPar(0, 24999999);
		escalaVPar h2 = new escalaVPar(25000000, 49999999);
		escalaVPar h3 = new escalaVPar(50000000, 74999999);
		escalaVPar h4 = new escalaVPar(75000000, 99999999);

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
