/**
 * @author Miguel Af�n Espinosa
 * @version 1.0 Clase que crea y usa los cajeros de forma paralela.
 */

public class redCajeros {

	public static void main(String[] args) throws InterruptedException {

		Runnable[] caja1 = new cajero[1000];
		Runnable[] caja2 = new cajero[1000];
		Thread[] hilos1 = new Thread[1000];
		Thread[] hilos2 = new Thread[1000];

		for (int i = 0; i < 1000; i++) {

			caja1[i] = new cajero(true, 100000);
			caja2[i] = new cajero(false, 100000);

		}

		for (int i = 0; i < 1000; i++) {

			hilos1[i] = new Thread(caja1[i]);
			hilos2[i] = new Thread(caja2[i]);

		}

		for (int i = 0; i < 1000; i++) {

			hilos1[i].start();
			hilos2[i].start();
			hilos1[i].join();
			hilos2[i].join();

		}

		cajero.show();
	}

}
