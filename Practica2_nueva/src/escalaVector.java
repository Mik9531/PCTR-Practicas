/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 * Esta clase realiza el escalado de un vector de forma secuencial.
*/


import java.util.*;

public class escalaVector {
	
		
	public static void main(String[] args)throws Exception{
		
		int [] vector = new int[100000000];
		
		System.out.println("Introduzca el escalar: ");
		Scanner s = new Scanner (System.in);
		int escalar = s.nextInt();
		
		
		for (int i = 0; i < vector.length; i++) {
			System.out.println(i);
			vector[i] = (int) (Math.random()*1000);
			System.out.println(vector[i]);
			System.out.println("El resultado es: " +vector[i]*escalar);
			
		}
	}
}
	

