import java.util.*;

/**
 * Navegabilidad del menu operador de numeros complejos
 * 
 * @version 1.0
 * @author Juan Enrique Aicardo García
 * @see Complejos.java
 */
public class usaComplejos {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int op;
		double r1, r2, i1, i2, m;
		Complejos r, a, b;

		System.out.println("Selecciona la operacion: ");
		System.out.println("1) Suma");
		System.out.println("2) Resta");
		System.out.println("3) Modulo");
		System.out.println("4) Multiplicacion");
		System.out.println("5) Division");
		op = sc.nextInt();

		r = new Complejos(0, 0);

		switch (op) {
		case 1:
			System.out.println();

			System.out.println("Los numeros complejos siguen un formato a+bi.");

			System.out.print("Introduza la parte real del primer complejo: ");
			r1 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria del primer complejo: ");
			i1 = sc.nextDouble();
			a = new Complejos(r1, i1);

			System.out.print("Introduza la parte real del segundo complejo: ");
			r2 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria del segundo complejo: ");
			i2 = sc.nextDouble();
			b = new Complejos(r2, i2);

			r.suma(a, b);
			System.out.println();
			System.out.print("El resultado es: ");
			r.Imprime();
			break;

		case 2:
			System.out.println();

			System.out.println("Los numeros complejos siguen un formato a+bi.");

			System.out.print("Introduza la parte real del primer complejo: ");
			r1 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria del primer complejo: ");
			i1 = sc.nextDouble();
			a = new Complejos(r1, i1);

			System.out.print("Introduza la parte real del segundo complejo: ");
			r2 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria del segundo complejo: ");
			i2 = sc.nextDouble();
			b = new Complejos(r2, i2);

			r.resta(a, b);
			System.out.println();
			System.out.print("El resultado es: ");
			r.Imprime();
			break;

		case 3:
			System.out.println();

			System.out.println("Los numeros complejos siguen un formato a+bi.");

			System.out.print("Introduza la parte real del complejo: ");
			r1 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria complejo: ");
			i1 = sc.nextDouble();
			a = new Complejos(r1, i1);

			m = a.mod();
			System.out.println();
			System.out.println("El resultado es: " + m);
			break;

		case 4:
			System.out.println();

			System.out.println("Los numeros complejos siguen un formato a+bi.");

			System.out.print("Introduza la parte real del primer complejo: ");
			r1 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria del primer complejo: ");
			i1 = sc.nextDouble();
			a = new Complejos(r1, i1);

			System.out.print("Introduza la parte real del segundo complejo: ");
			r2 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria del segundo complejo: ");
			i2 = sc.nextDouble();
			b = new Complejos(r2, i2);

			r.mul(a, b);
			System.out.println();
			System.out.print("El resultado es: ");
			r.Imprime();
			break;

		case 5:
			System.out.println();

			System.out.println("Los numeros complejos siguen un formato a+bi.");

			System.out.print("Introduza la parte real del primer complejo: ");
			r1 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria del primer complejo: ");
			i1 = sc.nextDouble();
			a = new Complejos(r1, i1);

			System.out.print("Introduza la parte real del segundo complejo: ");
			r2 = sc.nextDouble();
			System.out.print("Introduza la parte imaginaria del segundo complejo: ");
			i2 = sc.nextDouble();
			b = new Complejos(r2, i2);

			r.div(a, b);
			System.out.println();
			System.out.print("El resultado es: ");
			r.Imprime();
			break;

		default:
			System.out.println();
			System.out.println("Opcion incorrecta, finalizando ejecucion");
			break;
		}
	}
}
