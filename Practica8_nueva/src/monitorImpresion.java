
/**
 * @author Miguel Afán Espinosa
 */

import java.util.concurrent.*;
import java.util.*;

public class monitorImpresion {
	private static boolean[] libre = new boolean[3];
	private static int n = 0;
	private int impresoras = 0;

	monitorImpresion(boolean[] libre, int n, int impresoras) {
		this.libre = libre;
		this.n = n;
		this.impresoras = impresoras;
	}

	public synchronized void pedir_imp() throws Exception {
		while (!(impresoras == 0))
			n++;
		while (!libre[n])
			wait();
		libre[n] = false;
		impresoras--;
		notifyAll();
	}

	public synchronized void dejar_imp() throws Exception {
		while (!(impresoras < 3))
			n--;
		while (libre[n])
			wait();
		libre[n] = true;
		impresoras++;
		notifyAll();
	}
}
