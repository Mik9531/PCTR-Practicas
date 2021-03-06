/**
 * @author Miguel Af�n Espinosa
 * @version 1.0 Clase que modela una Cuenta corriente.
 */

public class cuentaCorrienta {

	private int codigo;
	private double saldo;

	public cuentaCorrienta() {
	}

	public cuentaCorrienta(int id, double disponible) {
		this.codigo = id;
		this.saldo = disponible;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void Deposito(double Cantidad) {

		if (saldo > 0)
			saldo = saldo + Cantidad;
	}

	public boolean Reintegro(double Cantidad) {

		if ((Cantidad <= 0) || (Cantidad > saldo))
			return false;
		else {
			saldo = saldo - Cantidad;
			return true;
		}
	}

}
