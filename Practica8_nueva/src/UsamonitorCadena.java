/**
 * @author Miguel Afán Espinosa
 */

public class UsamonitorCadena implements Runnable {
	public monitorCadena monitor = new monitorCadena(100);
	monitorCadena buffer_1 = new monitorCadena(100);
	monitorCadena buffer_2 = new monitorCadena(100);
	int i = 0;

	UsamonitorCadena(int i, monitorCadena monitor, monitorCadena buffer_1, monitorCadena buffer_2) {
		this.monitor = monitor;
		this.buffer_1 = buffer_1;
		this.buffer_2 = buffer_2;
		this.i = i;
	}

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			Thread hilo1 = new Thread(
					new UsamonitorCadena(0, new monitorCadena(100), new monitorCadena(100), new monitorCadena(100)));
			Thread hilo2 = new Thread(
					new UsamonitorCadena(1, new monitorCadena(100), new monitorCadena(100), new monitorCadena(100)));
			Thread hilo3 = new Thread(
					new UsamonitorCadena(2, new monitorCadena(100), new monitorCadena(100), new monitorCadena(100)));
			hilo1.start();
			hilo2.start();
			hilo3.start();
		}
	}

	public void run() {
		try {
			for (;;) {
				switch (i) {
				case 0:
					System.out.println("Entrando en la Cadena A");
					monitor.ProcesoA(buffer_1);
					Thread.sleep(1000);
				case 1:
					System.out.println("Entrando en la Cadena B");
					monitor.ProcesoB(buffer_1, buffer_2);
					Thread.sleep(1000);
				case 2:
					System.out.println("Entrando en la Cadena C");
					monitor.ProcesoC(buffer_2);
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
		}
	}
}
