/**
 * @author Miguel Afán Espinosa
 */




public class usalectorEscritor extends Thread{
    private final lectorEscritor monitor;
    private final boolean lee;

    /**
     * Constructor de la clase usalectorEscritor.
     * @param monitor Monitor que tratará el recurso compartido en exclusión mutura
     * @param lee Variable que indica si hilo debe leer (true) o escribir (false) en el recurso.
     */
    public usalectorEscritor(lectorEscritor monitor, boolean lee) {
        this.monitor = monitor;
        this.lee = lee;
    }

    /**
     * Método que indicará que operación realizar según la función del hilo.
     */
    @Override
    public void run(){
            if(lee){
                monitor.iniciaLectura();
                monitor.finLectura();
            }
            else{
                monitor.iniciaEscritura();
                monitor.finEscritura();
            }
    }


    public static void main(String[] args){
        lectorEscritor monitor = new lectorEscritor();

        Thread[] hilosEscritores = new Thread[5];
        Thread[] hilosLectores = new Thread[10];

        for(int i=0; i<5; i++)
            hilosEscritores[i] = new usalectorEscritor(monitor, false);

         for(int i=0; i<10; i++)
            hilosLectores[i] = new usalectorEscritor(monitor, true);

         for(int i=0; i<10; i++){
             if(i<5)
                 hilosEscritores[i].start();
             hilosLectores[i].start();
         }

         try {
            for (int i = 0; i < 10; i++) {
                if (i < 5)
                    hilosEscritores[i].join();
                hilosLectores[i].join();
            }
         }catch(InterruptedException e){System.err.println("ERROR");}

    }


}
