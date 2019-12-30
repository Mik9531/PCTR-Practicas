/**
 * @author Miguel Afán Espinosa
 */


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.*;



public class RWMonitorAN {
  private final Lock o = new ReentrantLock();
  private final Condition noEscribiendo = o.newCondition();
  private final Condition noLeyendo = o.newCondition();
  volatile int readers = 0;
  volatile boolean writing = false;
  File ruta;

  
  
  public RWMonitorAN(File ruta){
     this.ruta = ruta;
  }


  void StartRead() throws InterruptedException {
      o.lock();  
      try {
       while (writing) {
            noLeyendo.await();
        }
        

        
            readers = readers + 1;

            System.out.println("Lector inicia lectura...");

            try {
                RandomAccessFile fich = new RandomAccessFile(ruta, "r");

                while (fich.getFilePointer() <= fich.length()) {
                    System.out.println(fich.readInt());
                }
                fich.close();
            } catch (IOException e) {
            }

            noLeyendo.signalAll();
        } finally {
            o.unlock();
        }
    }

  
 
  void EndRead() {
    o.lock();
    try{
    readers = readers - 1;
    if (readers == 0) noEscribiendo.signalAll();
    System.out.println("Lector finaliza lectura...");
    }finally{o.unlock();}
  }
  
  

  void StartWrite() throws InterruptedException {
    o.lock();
    try{
      while (writing || (readers != 0))
        noEscribiendo.await();
      
    
    writing = true;
    System.out.println("Escritor inicia escritura...");
    
    try{
      RandomAccessFile fich = new RandomAccessFile(ruta, "rw");
      
      int i = (int) (Math.random()*100);
      fich.writeInt(i);
      fich.close();  
    }catch(IOException e){System.err.println("ERROR/*");}
    }finally{o.unlock();}
  }
  
  
  void EndWrite() {
        o.lock();
        try {
            writing = false;
            noEscribiendo.signalAll();
            noLeyendo.signalAll();
            System.out.println("Escritor finaliza escritura...");
        } finally {
            o.unlock();
        }
    }
}
