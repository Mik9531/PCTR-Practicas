
/**
 * @author Miguel Afán Espinosa
 */

import java.util.concurrent.*;

public class UsamonitorImpresion implements Runnable {
	private static boolean[] libre = new boolean[3];
	private static int impresoras, n;
	public monitorImpresion m = new monitorImpresion(libre, impresoras, n);

	UsamonitorImpresion(monitorImpresion m) {
		this.m = m;
	} // Constructor

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			libre[i] = true;
		}
		impresoras = 3;
		n = 0;
		int nNuc = Runtime.getRuntime().availableProcessors(); // Calculamos el numero de nucleos disponibles
		float Cb = (float) 0.5; // Introducimos el coeficiente de bloqueo
		int tamPool = (int) (nNuc / (1 - Cb)); // Aplicamos Subramanian
		ThreadPoolExecutor ejecutor = new ThreadPoolExecutor( // Ejecutor de tamaño variable
				tamPool, tamPool, 0L, // Tamaño minimo, maximo y latencia
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		for (int i = 0; i < tamPool; i++) { // Acotamos cada hilo mediante el uso del "tamaño de ventana"
			ejecutor.execute(new UsamonitorImpresion(new monitorImpresion(libre, impresoras, n)));
		}
	}

	public void run() {
		while (true) {
			try {
				m.pedir_imp();
				System.out.println("Pidiendo impresora");
				Thread.sleep(1000);
				m.dejar_imp();
				System.out.println("Dejando impresora");
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
