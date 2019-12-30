/**
 * @author Miguel Afán Espinosa
 */






public class lectorEscritor {
   private int n; 
   private boolean escribiendo;  
   private int recurso; 

   /**
    * Constructor del monitor que pone el número de lectores iniciales a 0
    * y indica que nadie está escribiendo. Además el recurso vale 10, por ejemmplo.
    */
   public lectorEscritor(){
       n=0;
       escribiendo = false;
       recurso = 10;
   }

   /**
    * Método que realiza una lectura del recurso.
    */
   public synchronized void iniciaLectura(){
       while(escribiendo){
           try{
               wait();
           }catch(InterruptedException e){System.err.println("ERROR");}
       }
       n++;
       System.out.println("***LEYENDO RECURSO***");
       try{
           Thread.currentThread().sleep(350);
          }catch(InterruptedException e){System.err.println("ERROR");}
       System.out.println("El recurso vale: "+recurso);
       notifyAll();
   }


   /**
    * Método que indica que se ha finalizado la lectura del recurso.
    */
   public synchronized void finLectura(){
       n--;
       notifyAll();
   }


   /**
    * Método que realiza una escritura en el recurso.
    */
   public synchronized void iniciaEscritura(){
       while(n!=0 || escribiendo){
           try{
               wait();
           }catch(InterruptedException e){System.err.println("ERROR");}
       }
       escribiendo=true;
       System.out.println("***ESCRIBIENDO EN EL RECUSO***");
         try{
           Thread.currentThread().sleep(350);
          }catch(InterruptedException e){System.err.println("ERROR");}
       recurso--;
   }


   /**
    * Método que indica que se ha terminado de escribir en el recurso.
    */
   public synchronized void finEscritura(){
       escribiendo=false;
       notifyAll();
   }

}
