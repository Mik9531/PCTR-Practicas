
public class hebra extends Thread {
	
	public hebra() {};
	
	static int n = 0;
	int veces;
	boolean tipo;
	
	/**Constructor parametrizado
	 * @param recibe un parametro de tipo booleano, tipo, para determinar qué hacen los hilos. true incrementa, false decrementa.
	 * @param recibe un parametro num de tipo entero usado para incrementar o decrementar
	 */
	
	public hebra (boolean tipo, int num) {
		
		this.tipo=tipo;
		this.veces=num;
		
	}
	
	public void run() {
		
		if (tipo) {
			for (int i = 0; i < veces; i++)
				n++;
		} else {
			for (int j=0; j < veces; j++)
				n--;
		}
		
	}
	
	/** 
	Método para mostrar el resultado 
	 */
	
	public void mostrar() {
		System.out.println("El número es: " +n);
	}
	
	

}
