// Miguel Afán Espinosa
// Practica 6
// Hilo2.java


public class Hilo2 extends Thread{ 
	private int[][] matriz;
	private int[] vector;
	private int[] vacio;
	private int linf;
	private int lsup;
	private int nc;

	public Hilo2 (int[][] matriz, int[] vector, int[] vacio, int linf, int lsup, int nc){
		this.matriz = matriz;
		this.vector = vector;
		this.vacio = vacio;
		this.linf = linf;
		this.lsup = lsup;
		this.nc = nc;
	}
	public void run(){ 
		for (int i=linf;i<lsup;i++){
			for(int j=0;j<nc; j++){
				for (int k = 0; k<nc; k++){
					vacio[i]+=(vector [k]*matriz[i][j]);
				}
			
			}
		}
	}
}
