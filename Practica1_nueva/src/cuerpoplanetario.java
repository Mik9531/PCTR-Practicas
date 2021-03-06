/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 * Esta clase contiene los m�todos getters y setters para un cuerpo planetario, adem�s de su constructor.
 */


public class cuerpoplanetario extends cuerpoastrofisico {
	
	public cuerpoplanetario () {}
	
	public cuerpoplanetario(double v, double d, double m, double g, String c) {
		super(v, d, m);
		this.gravedad=g;
		this.composicion=c;
	}
	
	void setGravedad(double g) {this.gravedad=g;}
	void setComposicion(String c) {this.composicion=c;}
	double getGravedad() {return this.gravedad;}
	String getComposicion() {return this.composicion;}
	
	protected double gravedad;
	protected String composicion;

}
