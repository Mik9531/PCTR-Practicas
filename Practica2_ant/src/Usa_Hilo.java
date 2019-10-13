/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 */

import java.util.*;

public class Usa_Hilo {
	
/** M�todo main 
* @param args 
* @throws InterruptedException 
*/

public static void main(String[] args) throws InterruptedException{
	
	Scanner lector = new Scanner(System.in);
	System.out.println("Introduzca numero");
	int num = lector.nextInt();
	Hilo hilos = new Hilo();
	Thread hilo1 = new Hilo(true,num);
	Thread hilo2 = new Hilo(false,num);
	hilo1.start();
	hilo2.start();
	hilo1.join();
	hilo2.join();
	hilos.mostrar();
}
    
    
}
