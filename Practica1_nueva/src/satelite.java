/** 
 * @author Miguel Afán Espinosa
 * @version 1.0
 * Esta clase contiene los métodos getters y setters para un satelite, además de su constructor.
*/

public class satelite extends cuerpoplanetario{
	
	public satelite() {}
	
	public satelite(double v, double d, double m, double g, String c, cuerpoplanetario o) {
		super(v, d, m, g, c);
		orbita = o;
	}
	
	protected cuerpoplanetario orbita;
	
	cuerpoplanetario getOrbita(){return this.orbita;}
	void setOrbita(cuerpoplanetario o) {this.orbita = o;}

}
