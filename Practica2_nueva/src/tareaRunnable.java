/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
*/

public class tareaRunnable implements Runnable {

	public tareaRunnable () {};
	
	static int n = 0;
	int veces;
	boolean tipo;
	
	int getN () {return n;}
	
	public tareaRunnable (boolean tipo, int veces) {
		
		this.tipo=tipo;
		this.veces=veces;
		
	}
	
	public void run() {
		
		if (tipo) {
			for (int i = 0; i < veces; i++) {
				
				n++;
			}

		} else {
			for (int j=0; j < veces; j++) 
				n--;
			}
		
	}
	

	
	
}
