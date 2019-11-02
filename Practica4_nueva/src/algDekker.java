/**
 * @author Miguel Afán Espinosa
 * @version 1.0
 */

class algDekker {

	static final int iteraciones = 100;

	static volatile int enteroCompartido = 0;

	static volatile boolean[] flag = new boolean[3];

	static volatile int turn = 0; // Los tres hilos empiezan a la vez de forma aleatoria, pero turn nos indica quien
									// comienza/continúa.

	class P extends Thread {

		boolean no_enter = false;

		public void run() {

			for (int i = 0; i < iteraciones; ++i) {

				for (int j = 0; j < 3; ++j)

					if (j != 0 && flag[j] == true) {

						System.out.println("No es el turno de P");
						no_enter = true; // Tiene el turno otro hilo que no es el mio
						break;
					}

				while (no_enter || turn != 0) { //Si es nuestro turno y podemos entrar, saltamos el while

					if (turn != 0) {

						flag[0] = false;

						while (turn != 0) {

							Thread.yield(); // Espera a que sea su turno
							
						}

						flag[0] = true; //
					}

					no_enter = false;

					for (int j = 0; j < 3; ++j)

						if (j != 0 && flag[j] == true) {

							no_enter = true;
							break;

						}
				}

				++enteroCompartido; // Como es turno 0, hacemos esta suma

				System.out.println(enteroCompartido);

				turn = (0 + 1) % 3; // Le pasamos el turno al siguiente hilo

				flag[0] = false; // ya no me toca a mi

			}

		}

	}

	class Q extends Thread {

		boolean no_enter = false;

		public void run() {

			for (int i = 0; i < iteraciones; ++i) {

				for (int j = 0; j < 3; ++j)
					if (j != 1 && flag[j] == true) {

						System.out.println("No es el turno de Q");
						no_enter = true;
						break;
					}

				while (no_enter || turn != 1) {

					if (turn != 1) {

						flag[1] = false;

						while (turn != 1) {

							Thread.yield();

						}

						flag[1] = true;
					}

					no_enter = false;
					for (int j = 0; j < 3; ++j)

						if (j != 1 && flag[j] == true) {

							no_enter = true;
							break;

						}
				}

				--enteroCompartido;
				System.out.println(enteroCompartido);

				turn = (1 + 1) % 3;
				flag[1] = false;
			}
		}
	}

	class R extends Thread {

		boolean no_enter = false;

		public void run() {
			for (int i = 0; i < iteraciones; ++i) {

				for (int j = 0; j < 3; ++j)

					if (j != 2 && flag[j] == true) {

						System.out.println("No es el turno de R");
						no_enter = true;
						break;

					}

				while (no_enter || turn != 2) {

					if (turn != 2) {

						flag[2] = false;

						while (turn != 2) {

							Thread.yield();

						}

						flag[2] = true;

					}

					no_enter = false;

					for (int j = 0; j < 3; ++j)

						if (j != 2 && flag[j] == true) {

							no_enter = true;
							break;

						}
				}

				++enteroCompartido;
				System.out.println(enteroCompartido);
				System.out.println("");

				turn = (2 + 1) % 3;
				flag[2] = false;

			}
		}
	}

	algDekker() {

		for (int i = 0; i < 3; ++i) {

			flag[i] = false;
		}

		Thread p = new P();
		Thread q = new Q();
		Thread r = new R();

		p.start();
		q.start();
		r.start();

		try {
			p.join();
			q.join();
			r.join();
			System.out.println("El valor del recurso compartido es " + enteroCompartido);
			System.out.printf("Deberia ser %d\n", iteraciones);
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		new algDekker();
	}
}