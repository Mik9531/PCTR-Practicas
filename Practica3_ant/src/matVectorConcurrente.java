/**
* Programa que multiplica una matriz por un vector mediante hilos
* @author Miguel Afán Espinosa
*/

import java.util.*;

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
		System.out.println("Vector para realizar el producto"); 
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
	public static void Manual(int[][] matriz, int nc, int nf){ 
		for (int f=0; f<nf; f++){
			for (int c=0; c<nc; c++){
				matriz[f][c]=x.nextInt();
			}
		}
	}
	public static int[] Producto(int[][] matriz, int[] vector, int nc, int nf){ 
		int[] vacio = new int[nc];
		for (int fila=0; fila<nf; fila++){
			for (int columna=0; columna<nc; columna++){
				Thread hilo = new Thread(new Hilo(matriz,vector,vacio,columna,fila));
				hilo.start();
				try {hilo.join();}
				catch (InterruptedException e){
				e.printStackTrace();}
			}
		}
		return vacio;
	}
	public static void Mostrar(int[] matriz){  
		int j;
			for (j = 0; j<matriz.length; j++) {
				System.out.print ("|" + matriz[j] + "|\n");
			}
	}
	public static void Aleatorio(int[][] matriz, int nc, int nf){ 
		for (int f=0; f<nf; f++){
			for (int c=0; c<nc; c++){
				matriz[f][c]=r.nextInt();
			}
		}
	}
}
