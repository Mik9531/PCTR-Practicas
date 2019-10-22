import java.util.Date;

public class matVectorConcurrenteThread extends Thread {

	int inicioi, fini;
	static int suma = 0;
	public static int[][] matriz = new int[2][2];
	public static int[] columna = new int[2];
	public static int[] resultado = new int[2];

	public matVectorConcurrenteThread() {
	}

	public matVectorConcurrenteThread(int inicioi, int fini) {
		this.inicioi = inicioi;
		this.fini = fini;

	};

	public void run() {
		

		for (int i = inicioi; i < fini; i++) {
			suma = 0;
			for (int j = 0; j < matriz.length; j++) {

				suma += columna[j] * matriz[i][j];

			}

		}
		for (int i = inicioi; i < fini; i++) {
			resultado[i] = suma;
		}
		for (int i = inicioi; i < fini; i++) {
			System.out.print("|" + resultado[i] + "|\n");
		}

	}

	public static void main(String[] args) throws Exception {

		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); // se prepara el cronometro
		d.setTime(inicCronom); // se activa el cronometro

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
//				matriz[i][j] = (int) (Math.random() * 1000);
				matriz[i][j] = i + 1;

			}
		}

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.println(matriz[i][j]);
			}
		}

		for (int i = 0; i < columna.length; i++) {
//			columna[i] = (int) (Math.random() * 100);
			columna[i] = i;
		}

		for (int i = 0; i < columna.length; i++) {
			System.out.println(columna[i]);
		}

		matVectorConcurrenteThread h1 = new matVectorConcurrenteThread(0, 1);
		matVectorConcurrenteThread h2 = new matVectorConcurrenteThread(1, 2);

		h1.start();
		h2.start();
		
		h1.join();
		h2.join();
		 

		System.out.println("");
		long finCronom = System.currentTimeMillis(); // se para el cronometro
		d.setTime(finCronom);
		System.out.println("Acabando trabajo tras " + (finCronom - inicCronom) + " milisegundos");

	}
}
