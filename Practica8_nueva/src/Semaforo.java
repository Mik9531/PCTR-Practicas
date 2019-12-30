/**
 * @author Miguel Af�n Espinosa
 */


public class Semaforo {
    private int S;

    /**
     * Constructor de clase, inicializa el semaforo
     * 
     * @param valor_inicial
     */
    public Semaforo(int valor_inicial) {
        S = valor_inicial;
    }

    /**
     * Metodo wait() del semaforo teorico, si el semaforo esta a 0, bloquea, si no,
     * decrementa la variable
     */
    public synchronized void esperar() {
        while (S == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        S--;
    }

    /**
     * Metodo signal() del semaforo teorico, notifica a los procesos bloqueados e
     * incrementa el semaforo
     */
    public synchronized void senalar() {
        notifyAll();
        S++;
    }

}