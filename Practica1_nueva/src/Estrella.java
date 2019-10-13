/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 * Esta clase contiene los m�todos getters y setters para una estrella, adem�s de su constructor.
*/

public class Estrella extends cuerpoastrofisico {
	
	public Estrella() {}
	
	public Estrella(double v, double d, double m, double e) {
		super(v, d, m);
		this.energia=e;
	}
	
	double getEnergia() {return this.energia;}
	void setEnergia(double e) {this.energia=e;}
	
	protected double energia;

}
