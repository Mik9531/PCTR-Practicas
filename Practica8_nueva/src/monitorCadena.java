
/**
 * @author Miguel Afán Espinosa
 */

import java.util.*;

public class monitorCadena {
	private int num = 0;
	private int[] buffer = null;
	private int putIn = 0, takeOut = 0;
	private int cont = 0;
	private Random r = new Random();

	public monitorCadena(int num) {
		this.num = num;
		buffer = new int[num];
	}

	public synchronized void insertar(int valor) {
		while (cont == num)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		buffer[putIn] = valor;
		putIn = (putIn + 1) % num;
		cont++;
		notifyAll();
	}

	public synchronized int extraer() {
		int valor;
		while (cont == 0)
			try {
				wait();
			} catch (InterruptedException e) {
			}
		valor = buffer[takeOut];
		takeOut = (takeOut + 1) % num;
		cont--;
		notifyAll();
		return valor;
	}

	public synchronized void ProcesoA(monitorCadena buffer_1) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				buffer_1.insertar(r.nextInt(20));
			}
		}

	}

	public synchronized void ProcesoB(monitorCadena buffer_1, monitorCadena buffer_2) {
		int[][] valor = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				valor[j][i] = buffer_1.extraer();
			}
		}
		for (int h = 0; h < 10; h++) {
			for (int k = 0; k < 10; k++) {
				buffer_2.insertar(valor[h][k]);
			}
		}
	}

	public synchronized void ProcesoC(monitorCadena buffer_2) {
		int res = 1;
		for (int i = 0; i < 10; i++) {
			res = res * buffer_2.extraer();
		}
		System.out.println(res);
	}

}
