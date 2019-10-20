// Miguel Afán Espinosa
// Practica 4
// Hilo.java

public class Hilo implements Runnable{ 
	private int[][] matriz;
	private int[] vector;
	private int[] vacio;
	private int fila;
	private int columna;
	public Hilo (int[][] matriz, int[] vector, int[] vacio, int columna, int fila){ 
		this.matriz = matriz;
		this.vector = vector;
		this.vacio = vacio;
		this.fila = fila;
		this.columna = columna;
	}
	public void run(){ 
		int suma = 0;
		for (int i=0;i<vector.length;i++){
			suma+=(matriz[fila][i]*vector[i]);
		}
		vacio[columna] = suma;
	}
}
