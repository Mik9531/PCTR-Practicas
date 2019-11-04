import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class prodMatricesParalelo implements Runnable {

	int inicioi, fini;
	static int suma = 0;
	public static int[][] matriz1 = new int[10][10];
	public static int[][] matriz2 = new int[10][10];
	public static int[][] resultado = new int[10][10];

	public prodMatricesParalelo() {
	}

	public prodMatricesParalelo(int inicioi, int fini) {
		this.inicioi = inicioi;
		this.fini = fini;

	};

	public void run() {

		for (int i = inicioi; i <= fini; i++) {

			for (int j = 0; j < matriz1.length; j++) {

				suma += matriz1[i][j] * matriz2[i][j];

				resultado[i][j] = suma;

			}

		}
	}

	/**
	 * Main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws Exception {

		int nNuc = Runtime.getRuntime().availableProcessors();
		float Cb = 0;
		int tamPool = (int) (nNuc / (1 - Cb));
		 ThreadPoolExecutor ept = new ThreadPoolExecutor(
		    	    tamPool, 
		    	    tamPool,
		    	    0L,
		            TimeUnit.MILLISECONDS, 
		            new LinkedBlockingQueue<Runnable>());
		    ept.prestartAllCoreThreads();
		 
		for (int i = 0; i < matriz1.length; i++) {
			for (int j = 0; j < matriz1.length; j++) {
//				matriz[i][j] = (int) (Math.random() * 1000);
				matriz1[i][j] = 1;

			}
		}

		for (int i = 0; i < matriz2.length; i++) {
			for (int j = 0; j < matriz2.length; j++) {
//				matriz[i][j] = (int) (Math.random() * 1000);
				matriz2[i][j] = 1;

			}
		}

//		for (int i = 0; i < matriz1.length; i++) {
//			for (int j = 0; j < matriz1.length; j++) {
//				System.out.println(matriz1[i][j]);
//			}
//		}

//		for (int i = 0; i < columna.length; i++) {
//			System.out.println(columna[i]);
//		}

		Runnable runnable1 = new prodMatricesParalelo(0, 4);
		Runnable runnable2 = new prodMatricesParalelo(5, 9);
		Thread h1 = new Thread(runnable1);
		Thread h2 = new Thread(runnable2);

		new Thread(h1).start();
		new Thread(h2).start();
		try {
			h1.join();
			h2.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado.length; j++) {
				System.out.print("|" + resultado[i][j] + "|\n");
			}
		}
		System.out.println(nNuc);

	}
}
