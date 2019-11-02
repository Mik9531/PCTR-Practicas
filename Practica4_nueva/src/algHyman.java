
/**
 * @author Miguel Afán Espinosa
 * @version 1.0
 */

class algHyman extends Thread {

	static final int iteraciones = 10;

	static volatile int enteroCompartido = 0;

	static volatile boolean[] flag = new boolean[2];

	static volatile int turn = 0; // Los dos hilos empiezan a la vez de forma aleatoria, pero turn nos indica
									// quien
									// comienza/continúa.

	int id;

	public algHyman(int id) {
		this.id = id;
	};

	public void run() {
		
		for (int i = 0; i < iteraciones; i++) {
		
	System.out.println(id);

		while (flag[id] = true) {
			

			flag[id] = true;

			while (turn != id) {
				

				while (flag[1 - id])
					Thread.yield();

					turn = id;
			}

			++enteroCompartido;
			System.out.println(enteroCompartido);
			flag[id] = false;
			System.out.println(flag[0]);
		}
	}
	}
	

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1; ++i) {

			flag[i] = false;
		}
		
		algHyman p = new algHyman(0);
		algHyman q = new algHyman(1);
		
		p.start();
		q.start();
		
			p.join();
			q.join();

			System.out.println("El valor del recurso compartido es " + enteroCompartido);
			System.out.printf("Deberia ser %d\n", iteraciones);
		
		}
		
	}
