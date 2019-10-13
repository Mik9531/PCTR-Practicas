
/**
 * 
 * @version 1.0
 * @author Juan Enrique Aicardo García
 *
 */

import java.util.*;

public class intDefinidaMonteCarlo {
	public static void main(String[] args) {

		int M; // N = impactos M = � de randoms
		double cx, cy, N = 0;
		int seleccion;

		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		System.out.println("Introduce el valor de M: ");
		M = sc.nextInt();
		do {
			System.out.println("Introduce que función quieres calcular: 1) f(x) = sin 2) f(x)= x");
			seleccion = sc.nextInt();
		} while (1 > seleccion || seleccion > 2);

		if (seleccion == 1) {
			for (int i = 0; i < M; i++) {
				cx = r.nextDouble();
				cy = r.nextDouble();

				if (Math.sin(cx) >= cy) {
					N++;
				}
			}
			System.out.println(N / M);
		}

		if (seleccion == 2) {
			for (int i = 0; i < M; i++) {
				cx = r.nextDouble();
				cy = r.nextDouble();

				if (cx >= cy) {
					N++;
				}
			}
			System.out.println(N / M);
		}
	}
}