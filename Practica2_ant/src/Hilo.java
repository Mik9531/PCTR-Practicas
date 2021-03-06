/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 */

public class Hilo extends Thread {
	
	public Hilo(){}
	
	boolean tipo;
	int veces;
	static int n=0;

	/**Constructor parametrizado
	 * @param recibe un parametro de tipo booleano, tipo, para determinar qu� hacen los hilos. true incrementa, false decrementa
	 * @param recibe un parametro num de tipo entero usado para incrementar o decrementar
	 */

	public Hilo(boolean tipo, int num) {
	
		this.tipo=tipo;
		this.veces=num;
    
	}
 
	public void run(){
	
		if(tipo){
    	
			for(int i=0;i<veces;i++) 
    	  		n++;
    }
		else{
    	
			for(int i=0;i<veces;i++)
				n--;
    	
    	}
	}
    
	/** 
	M�todo para mostrar el resultado 
	 */
 
	public void mostrar(){
		System.out.println("El numero es: " +n);
	}

}
