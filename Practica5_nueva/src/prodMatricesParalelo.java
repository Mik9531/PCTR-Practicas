
/**
* Programa que se encarga de calcular el producto de dos matrices de forma paralela.
* @author Miguel Afán Espinosa
*/

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.*;
import java.util.*;

public class prodMatricesParalelo implements Runnable {

	private static int[][] matz1;
	private static int[][] matz2;
	private static int[][] sol;
	private int fila, end;
	private static int N;

	/**
	 * 
	 * @param hilo corresponde al número de hilos
	 */
	public prodMatricesParalelo(int hilo, int end) {

		this.fila = hilo;
		this.end = end;

	}

	/**
	 * Metodo run donde se realizara el producto de la matiz y el vector
	 */
	public void run() {

		for (int i = fila; i < end; ++i)
			for (int j = 0; j < N; ++j)
				sol[i][j] += matz1[i][j] * matz2[i][j];
	}

	private static void Filler() {
		N = 5;
		Random r = new Random();
		sol = new int[N][N];

		matz1 = new int[N][N];
		matz2 = new int[N][N];
		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				matz1[i][j] = (int) (r.nextInt() * 10 + 1);

		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				matz2[i][j] = (int) (r.nextInt() * 10 + 1);
	}

	public static void main(String[] args) throws Exception {

		Filler();
		int nTareas = Runtime.getRuntime().availableProcessors();
		int tVentana = (int) Math.ceil((matz1.length * 1.) / nTareas);
		int start = 0;
		int end = 0;
		boolean tareas = true;
		Date d = new Date();
		DateFormat dd = new SimpleDateFormat("HH:mm:ss");
		long ini = System.nanoTime();
		d.setTime(ini);
		ExecutorService exe = Executors.newFixedThreadPool(nTareas);

		for (int i = 0; i < nTareas; ++i) {
			start = i * tVentana;
			end = (i + 1) * tVentana;
			if (tareas) {
				tareas = (end < matz1.length);
				end = (tareas) ? end : matz1.length;
				exe.submit(new prodMatricesParalelo((int) start, (int) end));
			}
		}

		exe.shutdown();

		long fin = System.nanoTime();
		d.setTime(fin);
		System.out.println("Terminado : " + " tras " + (fin - ini) / 1.0E9 + " seg ");

	}
}