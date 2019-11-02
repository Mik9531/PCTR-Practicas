// Miguel Afán Espinosa
// Practica 6
// Hilo.java



public class Hilo implements Runnable{ 
	private int[][] matriz;
	private int n;
	private int h;
	private int k;

	public Hilo (int[][] matriz, int n, int h, int k){ //Constructor
		this.matriz = matriz;
		this.n = n;
		this.h = h;
		this.k = k;
	}
	public void run(){ //Operaciones realizadas por cada hilo
		if(h==0 || k==0 || h==n-1 || k==n-1){
			if(h==0 && k==n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k-1]))/8;
			if(h==0 && k==0) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k+1]))/8;
			if(h==0 && k!=0 && k!=n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k+1])-(matriz[h][k-1]))/8;
			if(k==0 && h==n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h][k+1])-(matriz[h-1][k]))/8;
			if(k==0 && h!=0 && h!=n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k+1])-(matriz[h-1][k]))/8;
			if(k==0 && h==n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h][k+1])-(matriz[h-1][k]))/8;
			if(k!=0 && h==n-1 && k!=n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h][k+1])-(matriz[h-1][k])-(matriz[h][k-1]))/8;
			if(h!=0 && k==n-1 && h!=n-1) matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h-1][k])-(matriz[h][k-1]))/8;
		}
		else matriz[h][k] = (4*(matriz[h][k])-(matriz[h+1][k])-(matriz[h][k+1])-(matriz[h-1][k])-(matriz[h][k-1]))/8;
		if(matriz[h][k]<0) matriz[h][k]=matriz[h][k]*(-1);
	}
}
