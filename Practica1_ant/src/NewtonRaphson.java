// Miguel Af�n Espinosa
// Practica 1 
// Cesar.java


import java.util.*;

public class NewtonRaphson {

	public static void main(String[] args) {
		
		double inicial, iteraciones;
		double num=0;
		Scanner s= new Scanner (System.in);
		
		System.out.println("Introduzca la aproximaci�n inicial:");
		
		inicial=s.nextInt();
		
		System.out.println("Introduzca el numero de iteraciones:");
		
		iteraciones=s.nextInt();
		
		//Primera Funci�n
		
		if (inicial<=1 && inicial>=0) { 
			
			
			for (int x=0;x<iteraciones;x++) {
				
				if (x==0) {
					
					System.out.println(inicial);
					
				} 
				
				 if (x==1)
				{
					num=inicial-((Math.cos(inicial)-Math.pow(inicial, 3))/(-Math.sin(inicial)-3*(Math.pow(inicial, 2))));
					System.out.println(num);
				}
				
				 if (x>1) {
					
					 num=num-((Math.cos(num)-Math.pow(num, 3))/(-Math.sin(num)-3*(Math.pow(num, 2))));
					System.out.println(num);
					
				}
				
				
			}	
			
		}
				
		//Segunda Funci�n
		
		if (inicial<=3 && inicial>=2) {
		
			for (int x=0;x<iteraciones;x++) {
			
				if (x==0) {
					
					System.out.println(inicial);
					
				} 
				
				 if (x==1)
				{
					num=inicial-((Math.pow(inicial, 2)-5)/(2*inicial));
					System.out.println(num);
				}
				
				 if (x>1) {
					
					num=num-((Math.pow(num, 2)-5)/(2*num));
					System.out.println(num);
					
				}
			
			
		}
		
		}
		

	}

}
