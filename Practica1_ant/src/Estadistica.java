// Miguel Af�n Espinosa
// Practica 1 
// Estadistica.java

//Entrada: Lee la longitud y un array de numeros introducidos por el usuario
//Salida: Seg�n la opci�n seleccionada por el usuario, imprime la media, moda, varianza o desviaci�n t�pica del array introducido.



import java.util.*;
public class Estadistica {

	public static void main(String[] args) {
		
		Scanner s = new Scanner (System.in);
		
		int longitud,op;
		float[] numeros;
		float suma=0;
		float media=0;
		float varianza=0;
		
		System.out.println("Introduzca la longitud de numeros a introducir: ");
		
		longitud=s.nextInt();
		
		numeros=new float[longitud+1];
		
		for (int i=1;i<=longitud;i++) {
			
			System.out.println("Introduzca el numero " +i+ ": ");
			
			numeros[i]=s.nextFloat();
			
			suma=suma + numeros[i];			
		}
		
		media=suma/longitud;
		System.out.println("1.- Media - 2.- Moda - 3.- Varianza y Desviaci�n Tipica");
		
		op=s.nextInt();
		
		switch (op) {
		
		case 1: 
			
			
			System.out.println("La media es: "+media);
			break;
			
		case 2: 
			
			
			float frec=0;
			float moda=0;
			
			for (int j=0;j<=longitud;j++) {
				if (numeros[j]>frec) {
					
					frec=numeros[j];
					moda=numeros[j];
				}
						
				
			}
			
				
			System.out.println("La moda es: " +moda);
			
			
			break;
			
		case 3: 
			
			for (int j=0;j<=longitud;j++) {
			
			
			float rango;
			rango= (float)Math.pow(numeros[j]-media,2);
			varianza=varianza+rango;
			
			}
			varianza=(varianza/longitud) - media;
			System.out.println("La varianza es: " +varianza);

			
			double desviacion=0;
			desviacion= Math.sqrt(varianza);
			System.out.println("La desviaci�n es: " +desviacion);
			break;
			
		default: System.out.println("Opci�n Incorrecta");
		
		}
	}

}
