// Miguel Af�n Espinosa
// Practica 1 
// intDefinidaMonteCarlo.java

import java.util.*;
public class intDefinidaMonteCarlo {

	private static Scanner s;

	public static void main(String[] args) {
		
		s = new Scanner (System.in);
		
		int seleccion,puntos;
		
		double suma=0, resultado=0;
		
		double x,y;
		
		System.out.println("Introduzca el numero de puntos:");
		
		puntos=s.nextInt();
		
		System.out.println("Seleccione la funcion: 1.- sin (x)---2.- x");
		
		seleccion=s.nextInt();
		
		//Primera Funci�n
		
		if (seleccion==1) {
			
			for (int i=0;i<puntos;i++) {
				
				x=Math.random();
				y=Math.random();
				
				if (y<=Math.sin(x)) {
					
					suma++;
				}
				
			}

			resultado=suma/puntos;
			
			System.out.println("El resultado es: " +resultado);
			
		}
			
					
		//Segunda Funci�n
		
		if (seleccion==2) {
			
			for (int i=0;i<puntos;i++) {
				
				x=Math.random();
				y=Math.random();
				
				if (y<=x) {
					
					suma++;
				}
				
			}

			resultado=suma/puntos;
			
			System.out.println("El resultado es: " +resultado);
			
		}
		
		
		
	}

}
