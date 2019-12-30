/**
 * @author Miguel Afán Espinosa
 */

public class simulRedCajeros {

	public static void main(String[] args) throws InterruptedException {

		cuentaCorrienteSegura[] caja1 = new cuentaCorrienteSegura[1000];

		Thread[] hilos1 = new Thread[1000];
		Thread[] hilos2 = new Thread[1000];

		for (int i = 0; i < 1000; i++) {

			caja1[i] = new cuentaCorrienteSegura();
			caja1[i] = new cuentaCorrienteSegura();

		}

		for (int i = 0; i < 1000; i++) {

			hilos1[i] = new Thread();
			hilos2[i] = new Thread();

		}

		for (int i = 0; i < 1000; i++) {

			hilos1[i].start();
			hilos2[i].start();
			hilos1[i].join();
			hilos2[i].join();

		}


	}

}
