
/**
 * 
 * @version 1.0
 * @author Juan Enrique Aicardo García
 *
 */
import java.util.*;

public class NewtonRaphson {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double aprox;
		int ite;
		do {
			System.out.println("Introduce la aproximacion para  cos(x) - x^3  [0,1] : ");
			aprox = sc.nextDouble();
		} while (0 > aprox || aprox > 1);
		System.out.println("Introduce el numero de iteraciones: ");
		ite = sc.nextInt();

		for (int i = 0; i < ite; i++) {
			aprox = aprox - ((Math.cos(aprox) - Math.pow(aprox, 3)) / (-Math.sin(aprox) - (3 * Math.pow(aprox, 2))));
			System.out.println("Iteracion numero " + (i + 1) + ": " + aprox);
		}

		do {
			System.out.println("Introduce la aproximacion para  x^2 - 5  [2,3] : ");
			aprox = sc.nextDouble();
		} while (2 > aprox || aprox > 3);
		System.out.println("Introduce el numero de iteraciones: ");
		ite = sc.nextInt();

		for (int i = 0; i < ite; i++) {
			aprox = aprox - ((Math.pow(aprox, 2) - 5) / (2 * aprox));
			System.out.println("Iteracion numero " + (i + 1) + ": " + aprox);
		}
	}
}
