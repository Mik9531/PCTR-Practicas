// Miguel Af�n Espinosa
// Practica 2 
// UsaComplejos.java

//Este programa muestra un men� en el que se le pedir� al usuario una de las distintas opciones mostradas
//Una vez seleccionada la opci�n, se realizar�, segun el switch, uno de los metodos de la clase Complejos


import java.util.*;


public class usaComplejos {

	private static Scanner s;

	public static void main (String[] args){
		double[] numeros = new double[4];
		double[] modulo = new double[2];

		int op;
		double[] resultado = new double[2];
		double[] resultadomodulo = new double[1];
		Complejos C = new Complejos();
		s = new Scanner(System.in);
		
		do{
			System.out.println("MENU 0.Salir 1.Suma 2.Resta 3.Multiplicacion 4.Division 5.Modulo");
			System.out.println("Seleccione la opcion que desea realizar: ");
			op = s.nextInt();
			
			switch(op){
			case 1:
				C.Datos(numeros);
				resultado = C.Suma(numeros);
				System.out.println("La Suma del complejo es: "+resultado[0]+" "+resultado[1]+"i");
				break;
			
			case 2:
				C.Datos(numeros);
				resultado = C.resta(numeros);
				System.out.println("La resta es: "+resultado[0]+" "+resultado[1]+"i ");
				break;
			
			case 3:
				C.Datos(numeros);
				resultado = C.Multiplicacion(numeros);
				System.out.println("La multiplicacion es: "+resultado[0]+" "+(resultado[1])+"i");
				break;
			
			case 4:
				C.Datos(numeros);
				resultado = C.Division(numeros);
				System.out.println("La division es: "+resultado[0]/resultado[3]+"+"+resultado[1]/resultado[3]+"i");
				break;
			case 5:
				C.Datos(modulo);
				resultadomodulo = C.Modulo(modulo);
				System.out.println("El modulo es: "+ resultadomodulo[0]);
				break;
			}
		
		}while (op!=0);
	}
	
}
