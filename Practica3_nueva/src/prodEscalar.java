/**
 * @author Miguel Afán Espinosa
 * @version 1.0 Esta clase realiza el productor escalar de dos vectores reales
 *          de forma secuencial.
 */

public class prodEscalar {

	/**
	 * Main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws Exception {

		long startTime = System.currentTimeMillis(); // Comienzo tiempo de ejecucion

		double[] vector1 = new double[1000000];
		double[] vector2 = new double[1000000];
		double prodEscalar = 0;

		for (int i = 0; i < vector1.length; i++) {

			vector1[i] = (Math.random() * 1000);
			vector2[i] = (Math.random() * 1000);
			prodEscalar += vector1[i] * vector2[i];

		}

		System.out.println("El productor escalar de ambos vectores es: " + prodEscalar);

		long stopTime = System.currentTimeMillis(); // Fin del tiempo de ejecucion.
		long elapsedTime = stopTime - startTime;
		System.out.println(elapsedTime);
	}
}
