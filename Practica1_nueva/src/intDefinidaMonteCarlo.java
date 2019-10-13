/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 * Entrada: Introduce el numero de puntos que se emplear�n en la funci�n.
 * Salida: Seg�n la opci�n seleccionada por el usuario, imprime el resultado en funci�n a los puntos introducidos.
*/

import java.util.*;

public class intDefinidaMonteCarlo {
	
    public static void main(String[] args) {
    	
    	int  puntos = 0;
    	double aciertos=0,x, y;
    	Random r = new Random();
    	Scanner s = new Scanner (System.in);
    	System.out.println("�Cuantos puntos se emplear�n?");
    	puntos = s.nextInt();
    	System.out.println("�Qu� funci�n desea calcular?");
    	System.out.println("1.- f(x) = sin");
    	System.out.println("2.- f(x) = x");
    	int funcion = s.nextInt();
     	
    	switch (funcion) {
    	
    	case 1:
    		for (int i = 0; i < puntos; i++) {
    			x = r.nextDouble();
    			y = r.nextDouble();
    		
    			if (Math.sin(x) >= y) 
    				aciertos++;
    		}
    			System.out.println(aciertos/puntos);
    		break;
    	
    	case 2:
    		for (int i = 0; i < puntos; i++) {
    			x = r.nextDouble();
    			y = r.nextDouble();
    		
    			if (x >= y) 
    				aciertos++;
    		}
    			System.out.println(aciertos/puntos);
    		break;
    	
    	default:
    		System.out.println("Opci�n Incorrecta, vuelva a ejecutar");
    	}
    	
    }
    
}
    	

    		
    	
    	
    	
    	
    
    


