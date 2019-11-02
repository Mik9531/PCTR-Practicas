import java.util.Date;

public class matVectorConcurrente implements Runnable {

	int inicioi, fini;
	static int suma = 0;
	public static int[][] matriz = new int[10000][10000];
	public static int[] columna = new int[10000];
	public static int[] resultado = new int[10000];

	public matVectorConcurrente() {
	}

	public matVectorConcurrente(int inicioi, int fini) {
		this.inicioi = inicioi;
		this.fini = fini;

	};

	public void run() {

		for (int i = inicioi; i < fini; i++) {
			suma = 0;
			for (int j = 0; j < matriz.length; j++) {

				suma += columna[j] * matriz[i][j];

			}

			resultado[i] = suma;

		}

	}

	/**
	 * Main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws Exception {

		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); // se prepara el cronometro
		d.setTime(inicCronom); // se activa el cronometro

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = (int) (Math.random() * 1000);
//				matriz[i][j] = 1;

			}
		}

//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz.length; j++) {
//				System.out.println(matriz[i][j]);
//			}
//		}

		for (int i = 0; i < columna.length; i++) {
			columna[i] = (int) (Math.random() * 100);
//			columna[i] = 1;
		}

//		for (int i = 0; i < columna.length; i++) {
//			System.out.println(columna[i]);
//		}

		Runnable runnable1 = new matVectorConcurrente(0, 4999);
		Runnable runnable2 = new matVectorConcurrente(5000, 9999);
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
			System.out.print("|" + resultado[i] + "|\n");
		}

		System.out.println("");

		long finCronom = System.currentTimeMillis(); // se para el cronometro
		d.setTime(finCronom);
		System.out.println("Acabando trabajo tras " + (finCronom - inicCronom) + " milisegundos");

	}
}
