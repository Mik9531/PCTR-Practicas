
/**
 * @author Miguel Afán Espinosa
 */

import java.util.concurrent.locks.*;


public class filoApiAN {
    private final int numFilos;
    private boolean control; 
    private final boolean[] tenedores;
    private int numCogidos;
    private final Lock o = new ReentrantLock();
    private final Condition noTenedor = o.newCondition();
    
    
  
    public filoApiAN(int num){
        tenedores = new boolean[num];
        for(int i=0; i<num-1; i++){
            tenedores[i] = true;
        }
        tenedores[num-1] = false; 
        control=true;
        
        numCogidos = 1;
        numFilos = num;
        
    }
    
    
  
    public void comer(int i){
      
        try{
        cogerTenedorDrcha(i);
        cogerTenedorIzq(i);
        
        }catch(Exception e){System.err.println("ERROR");}
    }
    
    
  
    public void soltarTenedores(int i){ 
        o.lock();
        try {
            tenedores[i] = true;
            tenedores[(i+1)%numFilos] = true; 
            
            numCogidos = numCogidos-2;
            
            if(i==4)
                control=false;
            
            if(numCogidos==0){
                tenedores[numFilos-1] = false;  //Con esto evitamos el interbloqueo.
                control=true;
            }
            
            noTenedor.signalAll();
            
        }finally{o.unlock();}
    }

 
    void cogerTenedorDrcha(int i) throws Exception{
        o.lock();
        try{
            if(i==4){  
                if(!control){
                    while(tenedores[i] == false)
                        noTenedor.await();       
                        }                        
            }
            else{
                while(tenedores[i] == false)
                    noTenedor.await();
            }
            
            tenedores[i] = false;
            numCogidos++;
        
        }finally{o.unlock();}       
    }
    
 
     void cogerTenedorIzq(int i) throws Exception{
       o.lock();
      
       try{
           while(tenedores[(i+1)%numFilos] == false)
               noTenedor.await();
         
           tenedores[(i+1)%numFilos] = false;
           numCogidos++;
           
       }finally{o.unlock();}   
    }

}