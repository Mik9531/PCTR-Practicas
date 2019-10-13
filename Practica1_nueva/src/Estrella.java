/** 
 * @author Miguel Afán Espinosa
 * @version 1.0
 * Esta clase contiene los métodos getters y setters para una estrella, además de su constructor.
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
