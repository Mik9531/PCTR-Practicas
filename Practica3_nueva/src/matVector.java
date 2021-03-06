import java.util.Date;

/**
 * @author Miguel Af�n Espinosa
 * @version 1.0 Esta clase realiza la multiplicacion de una matriz de 10^6
 *          elementos por un vector de 10^6 elementos de forma secuencial.
 */

public class matVector {

	static int suma = 0;
	public static int[][] matriz = new int[10000][10000];
	public static int[] columna = new int[10000];
	public static int[] resultado = new int[10000];

	public static void main(String[] args) {

		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); // se prepara el cronometro
		d.setTime(inicCronom); // se activa el cronometro

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = (int) (Math.random() * 1000);
			}
		}

		for (int i = 0; i < columna.length; i++) {
			columna[i] = (int) (Math.random() * 100);
		}

		for (int i = 0; i < matriz.length; i++) {

			suma = 0;

			for (int j = 0; j < matriz.length; j++) {

				suma += columna[j] * matriz[i][j];

			}

			resultado[i] = suma;

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
