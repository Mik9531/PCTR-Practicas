/* Adaptado de M. Ben-Ari por Manuel Francisco */

/* Algoritmo de Dekker */
class Dekker {
    /* Iteraciones que dara cada hilo */
    static final int iteraciones = 200000000;
    /* Recurso compartido */
    static volatile int enteroCompartido = 0;
    /* Representa el deseo del hilo P de entrar en la seccion critica */
    static volatile boolean wantp = false;
    /* Representa el deseo del hilo Q de entrar en la seccion critica */  
    static volatile boolean wantq = false;
    /* Representa de quien es el turno */
    static volatile int turn = 1;

    class P extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                /* Seccion no critica */
                wantp = true;
                while (wantq) {
                    if (turn == 2) {
                        wantp = false;
                        while (turn == 2)
                            Thread.yield();
                        wantp = true;
                    }
                }
                
                /* Seccion critica */
                ++enteroCompartido;
                /* Fin Seccion critica */
                
                turn = 2;
                wantp = false;
            }
        }
    }
    
    class Q extends Thread {
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
                /* Seccion no critica */
                wantq = true;
                while (wantp) {
                    if (turn == 1) {
                        wantq = false;
                        while (turn == 1)
                            Thread.yield();
                        wantq = true;
                    }
                }
                
                /* Seccion critica */
                --enteroCompartido;
                /* Fin Seccion critica */
                
                turn = 1;
                wantq = false;
            }
        }
    }

    Dekker() {
        Thread p = new P();
        Thread q = new Q();
        p.start();
        q.start();
        
        try {
            p.join();
            q.join();
            System.out.println("El valor del recurso compartido es " + enteroCompartido);
            System.out.println("Deberia ser 0.");
        }
        catch (InterruptedException e) {}
    }

    public static void main(String[] args) {
        new Dekker();
    }
}
