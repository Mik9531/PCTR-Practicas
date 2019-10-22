import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); // se prepara el cronometro
		d.setTime(inicCronom); // se activa el cronometro

		double[] vector1 = new double[1000000];
		double[] vector2 = new double[1000000];
		double prodEscalar = 0;

		for (int i = 0; i < vector1.length; i++) {

			vector1[i] = (Math.random() * 1000);
			vector2[i] = (Math.random() * 1000);
			prodEscalar += vector1[i] * vector2[i];

		}

		System.out.println("El productor escalar de ambos vectores es: " + prodEscalar);

		System.out.println("");
		long finCronom = System.currentTimeMillis(); // se para el cronometro
		d.setTime(finCronom);
		System.out.println("Acabando trabajo tras " + (finCronom - inicCronom) + " milisegundos");
	}
}
