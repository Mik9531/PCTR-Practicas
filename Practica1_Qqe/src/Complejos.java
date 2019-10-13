/**
 * Clase que contiene operaciones elementales con numeros complejos
 * 
 * @version 1.0
 * @author Juan Enrique Aicardo García
 *
 */
public class Complejos {

	private double real;
	private double imag;

	// constructor nulo
	public Complejos() {
	}

	/**
	 * constructor
	 * 
	 * @param r parte real
	 * @param i parte imaginaria
	 */
	public Complejos(double r, double i) {
		real = r;
		imag = i;
	}

	/**
	 * Suma de complejos a y b
	 * 
	 * @param a
	 * @param b
	 * 
	 */
	public void suma(Complejos a, Complejos b) {
		real = a.real + b.real;
		imag = a.imag + b.imag;
	}

	/**
	 * Resta de complejos a y b
	 * 
	 * @param a
	 * @param b
	 */
	public void resta(Complejos a, Complejos b) {
		real = a.real - b.real;
		imag = a.imag - b.imag;
	}

	/**
	 * Productor de complejos a y b
	 * 
	 * @param a
	 * @param b
	 */
	public void mul(Complejos a, Complejos b) {
		real = (a.real * b.real) - (a.imag * b.imag);
		imag = (a.real * b.imag) + (a.imag * b.real);
	}

	/**
	 * Divisiond e complejos a y b
	 * 
	 * @param a
	 * @param b
	 */
	public void div(Complejos a, Complejos b) {
		real = (((a.real * b.real) + (a.imag * b.imag)) / (Math.pow(b.real, 2) + Math.pow(b.imag, 2)));
		imag = (((a.imag * b.real) - (a.real * b.imag)) / (Math.pow(b.real, 2) + Math.pow(b.imag, 2)));
	}

	/**
	 * Modulo de un complejo
	 * 
	 * @return modulo del complejo con el que se opera
	 */
	public double mod() {
		return Math.sqrt(Math.pow(real, 2) + Math.pow(imag, 2));
	}

	/**
	 * Imprime la parte real e imaginaria de un complejo
	 */
	public void Imprime() {
		System.out.println(real + " " + imag + "i");
	}

}
