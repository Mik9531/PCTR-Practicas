/**
 * @author Miguel Af�n Espinosa
 * @version 1.0 Clase que modela una Cuenta corriente.
 */

public class cajero implements Runnable {

	boolean op;
	double dinero = 0;

	/**
	 * Constructor
	 * 
	 * @param recibe el parametro opcion de tipo booleano para determinar si
	 *               reintegrar o depositar
	 * @param recibe el parametro dinero correspondiente al saldo que reintegremos o
	 *               depositaremos
	 */

	public cajero(boolean opcion, double dinero) {

		this.op = opcion;
		this.dinero = dinero;

	}

	static cuentaCorrienta Tarjeta = new cuentaCorrienta(123, 10000);

	public void run() {

		if (op) {
			Tarjeta.Deposito(dinero);
		} else {
			Tarjeta.Reintegro(dinero);
		}
	}

	/**
	 * Metodo para mostrar por pantalla el saldo
	 * 
	 */

	public static void show() {
		System.out.println("Saldo: " + Tarjeta.getSaldo());
	}

}