
public class matVectorPrueba {

	static int suma = 0;
	public static int[][] matriz = new int[3][3];
	public static int[] columna = new int[3];
	public static int[] resultado = new int[3];
	public static int[] prueba = new int[3];

	public static void main(String[] args) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = i + j + 1;
			}
		}

		for (int i = 0; i < matriz.length; i++) { // Prueba
			for (int j = 0; j < matriz.length; j++) {
				System.out.println(matriz[i][j]);
			}
		}

		for (int i = 0; i < columna.length; i++) {
			columna[i] = i + 1;
		}

		for (int i = 0; i < columna.length; i++) { // Prueba
			System.out.println(columna[i]);
		}

		for (int i = 0; i < matriz.length; i++) {

			suma = 0;

			for (int j = 0; j < matriz.length; j++) {

				suma += columna[j] * matriz[i][j];

				

			}
			
			resultado[i] = suma;

	
		}
		
		for (int i = 0; i < resultado.length; i++) { //Prueba
			System.out.print ("|" + resultado[i] + "|\n");
		}

	}

}
