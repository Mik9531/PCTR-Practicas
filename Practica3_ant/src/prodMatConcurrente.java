// Miguel Afán Espinosa
// Practica 4
// prodMatConcurrente.java



public class prodMatConcurrente extends Thread{ 
	private int[][] matriz1;
	private int[][] matriz2;
	private int[][] vacio;
	private int f;
	private int c;
	private int nc2;
	public prodMatConcurrente (int[][] matriz1, int[][] matriz2, int[][] vacio, int f, int c, int nc2){ 
		this.matriz1 = matriz1;
		this.matriz2 = matriz2;
		this.vacio = vacio;
		this.f = f;
		this.c = c;
		this.nc2 = nc2;
	}
	public void run(){ 
		int suma = 0;
		for (int i=0;i<nc2;i++){
			suma+=(matriz1[f][i]*matriz2[i][c]);
		}
		vacio[f][c] = suma;
	}
}
