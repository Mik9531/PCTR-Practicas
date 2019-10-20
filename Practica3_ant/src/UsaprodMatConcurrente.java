// Miguel Afán Espinosa
// Practica 4
// usaprodMatConcurrente.java



import java.util.*;

public class UsaprodMatConcurrente{ 
	public static int[][] matriz;
	public static Scanner x = new Scanner(System.in);
	public static Random r = new Random();
	public static void main(String[] args){ 
		int nf1,nc1,nf2,nc2,i,op = 0;
		System.out.println("Numero de filas de la matriz 1"); 
		nf1 = x.nextInt();
		System.out.println("Numero de columnas de la matriz 1");
		nc1 = x.nextInt();
		System.out.println("Numero de filas de la matriz 2");
		nf2 = x.nextInt();
		System.out.println("Numero de columnas de la matriz 2");
		nc2 = x.nextInt();
		int[][] matriz1 = new int[nf1][nc1];
		int[][] matriz2 = new int[nf2][nc2];
		int[][] mfinal = new int[nf1][nc2];
		while(op!=4){ 
			System.out.println("            MENU");
			System.out.println("---------------------------");
			System.out.println("1. Rellenar manualmente");
			System.out.println("2. Rellenar aleatoriamente");
			System.out.println("3. Mostrar resultado");
			System.out.println("4. Salir");
			System.out.println("---------------------------");
			System.out.println("Introduzca accion a realizar");
			op=x.nextInt();
			switch(op){
				case 1:	mfinal=Manual(matriz1,matriz2,nc2,nf1,nc1,nf2);
					break;
				case 2:	mfinal=Aleatorio(matriz1,matriz2,nc2,nf1,nc1,nf2);
					break;
				case 3:Mostrar(mfinal);
					break;
			}
		}
	}
	public static int[][] Manual(int[][] matriz1, int[][] matriz2, int nc2, int nf1, int nc1, int nf2){
		int suma;
		int[][] vacio = new int[nf1][nc2];
		for (int i=0; i<nf1; i++){
			for (int j=0; j<nc1; j++){
				matriz1[i][j] = x.nextInt();
			}
		}
		for (int h=0; h<nf2; h++){
			for (int a=0; a<nc2; a++){
				matriz2[h][a] = x.nextInt();
			}
		}
		
		for (int f=0; f<nf1; f++){ 
			for (int c=0; c<nc2; c++){
				prodMatConcurrente hilo = new prodMatConcurrente(matriz1,matriz2,vacio,f,c,nc2);
				hilo.start();
				try {hilo.join();}
				catch (InterruptedException e){
				e.printStackTrace();}
			}
		}
		
		return vacio;
	}
	public static void Mostrar(int[][] matriz){ 
		for (int i=0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j=0; j < matriz[i].length; j++) {
				System.out.print(" "+matriz[i][j]+" ");
			}
			System.out.println("|");
		}
	}
	public static int[][] Aleatorio(int[][] matriz1, int[][] matriz2, int nc2, int nf1, int nc1, int nf2){ //Metodo que rellena las matrices aleatoriamente y las multiplica
		int suma;
		int[][] vacio = new int[nf1][nc2];
		for (int i=0; i<nf1; i++){
			for (int j=0; j<nc1; j++){
				matriz1[i][j] = r.nextInt();
			}
		}
		for (int h=0; h<nf2; h++){
			for (int a=0; a<nc2; a++){
				matriz2[h][a] = r.nextInt();
			}
		}
		
		for (int f=0; f<nf1; f++){ 
			for (int c=0; c<nc2; c++){
				prodMatConcurrente hilo = new prodMatConcurrente(matriz1,matriz2,vacio,f,c,nc2);
				hilo.start();
				try {hilo.join();}
				catch (InterruptedException e){
				e.printStackTrace();}
			}
		}
	
		return vacio;
	}
}
