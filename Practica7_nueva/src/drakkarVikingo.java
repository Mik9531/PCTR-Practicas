/**
 * @author Miguel Afán Espinosa
 */



class accionVikingo{
    private int recipiente;

    /**
     * Constructor de accionVikingo
     *
     * @param r Cantidad de anguilas que contiene el recipiente.
     */
    public accionVikingo(int r){
        recipiente = r;
    }

    /**
     * Método que realiza el cocinero para rellenar el recipiente.
     */
    public synchronized void rellenar(){
         for(;;){
            while(recipiente!=0){
                try{
                    wait();
                }catch(InterruptedException e){System.err.println("ERROR");}
            }
            System.out.println("-----RELLENANDO-----");
            for(int i=0; i<20; i++){
                sleep(150);
                System.out.print("*");
            }
            System.out.println("");
            recipiente = 5;
            notifyAll();
         }
    }

    private void sleep(int i) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Método que utilizan los vikingos para comer.
     */
    public synchronized void comer(){
        while(recipiente==0){
            try{
                    wait();
                }catch(InterruptedException e){System.err.println("ERROR");}
        }
        System.out.println("El recipiente contiene "+recipiente+" anguilas");
        recipiente--;

        notifyAll();
    }
}

public class drakkarVikingo extends Thread{
   private final boolean cocinero;
   private final accionVikingo p;


   /**
    * Constructor de drakkarVikingos.
    *
    * @param p Objeto que realiza las acciones de los vikingos.
    * @param c Indica si el vikingo es (true) o no (false) cocinero.
    */
   public drakkarVikingo(accionVikingo p, boolean c){
       this.p = p;
       cocinero = c;
   }

    /**
     * Método que se ejecuta para que coman los vikingos o para que se cocine.
     */
    @Override
    public void run(){
        if(cocinero){
            p.rellenar();
        }
        else{
           for(int i=0; i<20; i++){
              p.comer();
              System.out.println("Comiendo vikingo "+getName());
           }
        }
    }


    /**
     * Método principal que llama a los vikingos a comer.
     * @param args NO SIRVE.
     */
    public static void main(String[] args){
        accionVikingo p = new accionVikingo(5);

        Thread[] vikingos = new Thread[10];
        drakkarVikingo cocinero = new drakkarVikingo(p, true);

        for(int i=0; i<10; i++)
            vikingos[i] = new drakkarVikingo(p, false);

        cocinero.start();
        for(int i=0; i<10; i++)
            vikingos[i].start();


       try{
        for(int i=0; i<10; i++)
            vikingos[i].join();
        cocinero.join();
       }catch(InterruptedException e){System.err.println("ERROR");}

       System.out.println("¡Ya hemos comido!");
    }

}
