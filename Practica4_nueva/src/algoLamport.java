
/**
 * @author Miguel Afán Espinosa
 * @version 1.0 
 */

import java.util.concurrent.*;
import java.util.*;

class algoLamport {
	static final int iteraciones = 100;
	static volatile int enteroCompartido = 0;
	int[] numero;
	boolean[] eligiendo;
	int n;
	static Scanner x = new Scanner(System.in);

	class P implements Runnable {
		int h;

		public P(int h) {
			this.h = h;
		}

		public void run() {
			for (int i = 0; i < iteraciones; ++i) {
				eligiendo[h] = true;
				numero[h] = 1 + max(numero);
				eligiendo[h] = false;
				for (int j = 0; j < n; ++j) {
					while (eligiendo[j]) {
						Thread.yield();
					}
					while (numero[j] != 0 && ((numero[j] < numero[h]) || (numero[h] == numero[j]) && (j < h))) {
						Thread.yield();
					}
				}
				++enteroCompartido;
				numero[h] = 0;
			}
		}
	}

	public static int max(int[] v) {
		int maximo = v[0];
		for (int i = 0; i < v.length; i++) {
			if (v[i] > maximo)
				maximo = v[i];
		}
		return maximo;
	}

	algoLamport() {
		System.out.println("Introduce el numero de procesos");
		n = x.nextInt();
		numero = new int[n];
		eligiendo = new boolean[n];
		for (int j = 0; j < n; j++) {
			numero[j] = 0;
			eligiendo[j] = false;
		}

		ExecutorService ejecutor = Executors.newFixedThreadPool(n);
		for (int i = 0; i < n; i++) {
			ejecutor.execute(new P(i));
		}

		ejecutor.shutdown();
		while (!ejecutor.isTerminated()) {
		}
		System.out.println("El valor del recurso compartido es " + enteroCompartido);
		System.out.printf("Deberia ser %d\n", n * iteraciones);
	}

	public static void main(String[] args) throws Exception {
		new algoLamport();
	}
}
