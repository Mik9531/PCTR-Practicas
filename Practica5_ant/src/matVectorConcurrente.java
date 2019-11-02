// Miguel Afán Espinosa
// Practica 6
// matVectorConcurrente.java




import java.util.*;
import java.util.concurrent.*;

public class matVectorConcurrente{ 
	public static int[][] matriz;
	public static Scanner x = new Scanner(System.in);
	public static Random r = new Random();
	
	public static void main(String[] args){ 
		int nf,nc,i,op = 0;
		long comienzo,fin;
		System.out.println("Numero de filas"); 
		nf = x.nextInt();
		System.out.println("Numero de columnas");
		nc = x.nextInt();
		int[] vector = new int[nc];
		int[] vfinal = new int[nc];
		for (i = 0; i<nc; i++){
			vector[i] = r.nextInt(2);}
		matriz = new int[nf][nc];
		while(op!=4){ 
			System.out.println("            MENU");
			
			System.out.println("1. Rellenar manualmente");
			System.out.println("2. Rellenar aleatoriamente");
			System.out.println("3. Mostrar resultado");
			System.out.println("4. Salir");
			
			System.out.println("Introduzca accion a realizar");
			op=x.nextInt();
			switch(op){
				case 1:	Manual(matriz,nc,nf);
					
					vfinal=Producto(matriz,vector,nc,nf);
					
					break;
				case 2:	Aleatorio(matriz,nc,nf);
					comienzo = System.currentTimeMillis();
					vfinal=Producto(matriz,vector,nc,nf);
					fin = System.currentTimeMillis();
					System.out.println("El tiempo de ejecucion es "+(fin - comienzo)+" milisegundos");
					break;
				case 3:Mostrar(vfinal);
					break;
			}
		}
	}

	private static void Mostrar(int[] vfinal) {
		// TODO Auto-generated method stub
		
	}

	private static void Aleatorio(int[][] matriz2, int nc, int nf) {
		// TODO Auto-generated method stub
		
	}

	private static int[] Producto(int[][] matriz2, int[] vector, int nc, int nf) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void Manual(int[][] matriz2, int nc, int nf) {
		// TODO Auto-generated method stub
		
	}
}