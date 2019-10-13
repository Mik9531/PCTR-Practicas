/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 * Esta clase contiene los m�todos getters y setters para un cuerpo astrofisico, adem�s de su constructor.
*/

public class cuerpoastrofisico extends sistemaSolar{
	
	public cuerpoastrofisico() {}
	void setVolumen(double v) {this.volumen=v;}
	void setDiametro(double d) {this.diametro=d;}
	void setMasa(double m) {this.masa=m;}
	double getVolumen() {return this.volumen;}
	double getDiametro() {return this.diametro;}
	double getMasa() {return this.masa;}
	
	public cuerpoastrofisico (double v, double d, double m) {
		this.volumen=v;
		this.diametro=d;
		this.masa=m;
	}
	
	protected double volumen;
	protected double diametro;
	protected double masa;
	
	
}