import java.util.*;

/**
 * Dado un numero de datos concreto(introducido previamente por pantalla) se
 * podra calcular su media,moda,varianza y desviacion tipica
 * 
 * @author Juan Enrique Aicardo García
 * @version 1.0
 */
public class Estadistica {
	private static Scanner sc;

	/**
	 * Se calcula la media de los elementos del vector
	 * 
	 * @param vector contiene los datos con los que vamos a operar
	 * @param n      numero de datos
	 * @return media sera el resultado de la media del conjunto de todos los datos
	 */
	public static double media(double[] vector, int n) {
		double media = 0;

		for (int i = 0; i < n; i++) {
			media += vector[i];
		}
		media = media / n;
		return media;
	}

	/**
	 * Se calcula la moda de los elementos del vector
	 * 
	 * @param vector contiene los datos con los que vamos a operar
	 * @param n      numero de datos
	 * @return moda sera el resultado de la moda del conjunto de todos los datos
	 */
	public static double moda(double[] vector, int n) {
		int cont = 0, contmax = 0;
		double moda = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (vector[i] == vector[j])
					cont++;
			} // for2
			if (cont > contmax) {
				moda = vector[i];
				contmax = cont;
				cont = 0;
			} // if
		} // for1
		return moda;
	}

	/**
	 * Se calcula la varianza de los elementos del vector
	 * 
	 * @param vector contiene los datos con los que vamos a operar
	 * @param n      numero de datos
	 * @return varianza sera el resultado de la varianza del conjunto de todos los
	 *         datos
	 */

	public static double varianza(double[] vector, int n) {
		double cont = 0, varianza = 0;
		double media = media(vector, n);

		for (int i = 0; i < n; i++) {
			cont = cont + Math.pow((vector[i] - media), 2);
			System.out.println(cont);
		}
		varianza = cont / (n - 1);
		return varianza;
	}

	/**
	 * Se calcula la desviacion tipica de los elementos del vector
	 * 
	 * @param vector contiene los datos con los que vamos a operar
	 * @param n      numero de datos
	 * @return desviacionTipica sera el resultado de la desviacion tipica del
	 *         conjunto de todos los datos
	 */

	public static double desviacionTipica(double[] vector, int n) {
		double cont = 0, desviacion = 0;
		double media = media(vector, n);

		for (int i = 0; i < n; i++) {
			cont = cont + Math.pow((vector[i] - media), 2);
			System.out.println(cont);
		}
		desviacion = Math.sqrt(cont / (n - 1));
		return desviacion;
	}

	/**
	 * Se declara el tama�o del vector y se inicializa con datos introducidos por
	 * pantalla
	 * 
	 * @param agrs array de cadenas de caracteres
	 * @return no retorna nada
	 */

	public static void main(String[] agrs) {
		int n, op;
		sc = new Scanner(System.in);

		System.out.println("Introduce el numero de datos: ");
		n = sc.nextInt();

		double[] vector;
		vector = new double[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Introduce un numero: ");
			vector[i] = sc.nextDouble();
		}

		do {
			System.out.println("Selecciona la acción que desea realizar: ");
			System.out.println("1.Media ");
			System.out.println("2.Moda ");
			System.out.println("3.Varianza ");
			System.out.println("4.Desviación Típica ");
			System.out.println("5.Salir ");
			op = sc.nextInt();

			switch (op) {
			case 1: {
				System.out.println("La media es: " + media(vector, n));
				break;
			}
			case 2: {
				System.out.println("La moda es: " + moda(vector, n));
				break;
			}
			case 3: {
				System.out.println("La varianza es: " + varianza(vector, n));
				break;
			}
			case 4: {
				System.out.println("La desviacion tipica es: " + desviacionTipica(vector, n));
				break;
			}
			default:
				break;
			}

		} while (op > 5 || op < 5);

		System.out.println("Hasta pronto!");
	}
}
