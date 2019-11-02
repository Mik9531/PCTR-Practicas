// Miguel Afán Espinosa
// Practica 6
// Hilo3.java


public class Hilo3 implements Runnable{ 
	private int[][] matriz;
	private int linf;
	private int lsup;
	private int n;

	public Hilo3 (int[][] matriz, int linf, int lsup, int n){ 
		this.matriz = matriz;
		this.linf = linf;
		this.lsup = lsup;
		this.n = n;
	}
	public void run(){ 
		for (int h = linf; h<lsup; h++){
			for (int k = 0; k<n; k++){
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
	}
}
