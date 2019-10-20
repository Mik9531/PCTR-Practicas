

public class prodEscalarParaleloPrueba extends Thread {

	int idHebra, inicio, fin;
	double resultadoParcial = 0;
	static double resultadoFinal = 0;
	static double[] prodParcial = new double[2]; // tendrá la dimensión según el num de hebras.
	double[] vector1 = new double[4];
	double[] vector2 = new double[4];

	public prodEscalarParaleloPrueba() {
	};

	public prodEscalarParaleloPrueba(int idHebra, int inicio, int fin) {
		this.idHebra = idHebra;
		this.inicio = inicio;
		this.fin = fin;
	};

	public void run() {

		for (int i = inicio; i <= fin; i++) {

			vector1[i] = i;
			vector2[i] = i;
			resultadoParcial += vector1[i] * vector2[i];

		}

		prodParcial[idHebra] = resultadoParcial;
	}

	/**
	 * Main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws Exception {

		long startTime = System.currentTimeMillis(); // Comienzo tiempo de ejecucion

		prodEscalarParaleloPrueba h1 = new prodEscalarParaleloPrueba(0, 0, 1);
		prodEscalarParaleloPrueba h2 = new prodEscalarParaleloPrueba(1, 2, 3);

		h1.start();
		h2.start();

		h1.join();
		h2.join();

		System.out.println(prodParcial[0]);
		System.out.println(prodParcial[1]);

		for (int i = 0; i < prodParcial.length; i++) {
			resultadoFinal += prodParcial[i];
		}

		System.out.println("El resultado es: " + resultadoFinal);

		long stopTime = System.currentTimeMillis(); // Fin del tiempo de ejecucion.
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
	}

}
