

import java.util.*;

public class matVector{ //Inicializamos las variables globales
	public static int[][] matriz;
	public static Scanner x = new Scanner(System.in);
	public static Random r = new Random();
	
	public static void main(String[] args){ //Inicializamos las variables del metodo main
		int nf,nc,i,op = 0;
		long comienzo,fin;
		System.out.println("Numero de filas"); //Pedimos el numero de filas y columnas de la matriz
		nf = x.nextInt();
		System.out.println("Numero de columnas");
		nc = x.nextInt();
		int[] vector = new int[nc]; //Vector inicial
		int[] vfinal = new int[nc]; //Vector final
		System.out.println("Vector para realizar el producto"); //Rellenamos el vector manualmente
		for (i = 0; i<nc; i++){
			vector[i] = r.nextInt(2);}
		matriz = new int[nf][nc];
		while(op!=4){ //Menu de opciones
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
				case 1:	Manual(matriz,nc,nf); 
					//comienzo = System.currentTimeMillis();
					vfinal=Producto(matriz,vector,nc,nf);
					//fin = System.currentTimeMillis();
					//System.out.println("El tiempo de ejecucion es "+(fin - comienzo)+" milisegundos");
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
	public static void Manual(int[][] matriz, int nc, int nf){ //Metodo que rellena la matriz manualmente
		for (int i = 0; i<nf; i++) {
			for (int j = 0; j<nc; j++){
				matriz[i][j]=x.nextInt();
			}
		}
	}
	public static int[] Producto(int[][] matriz, int[] vector, int nc, int nf){ //Metodo que multiplica la matriz por el vector
		int i,j,k,suma = 0;
		int[] vacio = new int[nc];
		for (i = 0; i<nf; i++) {
			for (j = 0; j<nc; j++){
				suma = 0;
				for (k = 0; k<nc; k++){
					suma=suma+(vector[k]*matriz[i][j]);
				}
				vacio[j] = suma;
			}
		}
		return vacio;
	}
	public static void Mostrar(int[] matriz){ //Metodo que muestra el vector resultante por pantalla
		int j;
			for (j = 0; j<matriz.length; j++) {
				System.out.print ("|" + matriz[j] + "|\n");
			}
	}
	public static void Aleatorio(int[][] matriz, int nc, int nf){ //Metodo que rellena la matriz aleatoriamente
		for (int i = 0; i<nf; i++) {
			for (int j = 0; j<nc; j++){
				matriz[i][j]=r.nextInt();
			}
		}
	}
}
