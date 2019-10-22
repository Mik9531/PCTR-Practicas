import java.util.Date;

public class matVectorConcurrentePrueba implements Runnable {

	int inicioi, fini;
	int cont = 0;
	static int resultadoFinal;
	int suma = 0;
	public static int[][] matriz = new int[2][2];
	public static int[] columna = new int[2];
	public static int[] resultado = new int[2];

	public matVectorConcurrentePrueba() {
	}

	public matVectorConcurrentePrueba(int inicioi, int fini) {
		this.inicioi = inicioi;
		this.fini = fini;

	};

	public void run() {

		for (int i = inicioi; i < fini; i++) {
			int pos = i;
			for (int j = 0; j < matriz.length; j++) {

				suma += matriz[i][j] * columna[j];
//				System.out.println(suma);

			}

			resultado[pos] = suma;
			pos++;
			


		}

	}

	public static void main(String[] args) {

		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); // se prepara el cronometro
		d.setTime(inicCronom); // se activa el cronometro

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
//				matriz[i][j] = (int) (Math.random() * 1000);
				matriz[i][j] = i + 1;

			}
		}

//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz.length; j++) {
//				System.out.println(matriz[i][j]);
//			}
//		}

		for (int i = 0; i < columna.length; i++) {
//			columna[i] = (int) (Math.random() * 100);
			columna[i] = i + 1;
		}

//		for (int i = 0; i < columna.length; i++) {
//			System.out.println(columna[i]);
//		}

		Runnable runnable1 = new matVectorConcurrentePrueba(0, 1);
		Runnable runnable2 = new matVectorConcurrentePrueba(1, 2);
		
		
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
		

		

		System.out.println("");
		
		for (int k = 0; k < resultado.length; k++) {

			System.out.println("|" + resultado[k] + "|");

		}

		long finCronom = System.currentTimeMillis(); // se para el cronometro
		d.setTime(finCronom);
		System.out.println("Acabando trabajo tras " + (finCronom - inicCronom) + " milisegundos");

	}
}
