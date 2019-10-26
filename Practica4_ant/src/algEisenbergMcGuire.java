// Miguel Afán Espinosa
// Practica 5
// algEisenbergMcGuire.java



import java.util.concurrent.*;

class algEisenbergMcGuire {
    
    static final int iteraciones = 20000000;
    static volatile int enteroCompartido = 0;
    static enum pstate {IDLE, WAITING, ACTIVE};
    static pstate[] flags = new pstate[2];
    static volatile int turn = 0;
    static final int n = 2;
    static class P implements Runnable {
    	int index;
    	int turnoHilo;
    	public P(int turnoHilo){
    		this.turnoHilo = turnoHilo;
    		flags[this.turnoHilo]=pstate.IDLE;
    	}
        public void run() {
            for (int i=0; i<iteraciones; ++i) {
            	do{
            		flags[this.turnoHilo] = pstate.WAITING;
            		index = turn;
            		while (index != this.turnoHilo) {
            			if (flags[index]!=pstate.IDLE)
            				index = turn;
            			else index = (index+1)%n;
            		}
            		flags[this.turnoHilo] = pstate.ACTIVE;
            		index = 0;
            		while ((index < n) && ((index==this.turnoHilo)||(flags[index]!= pstate.ACTIVE))) {
            			index = index+1;
            		}
		} while ((index<n)&&((turn!=this.turnoHilo)||(flags[turn]!=pstate.IDLE)));
 
        	turn=this.turnoHilo;
        	++enteroCompartido;
                index = (turn+1)%n;
                while (flags[index] == pstate.IDLE) {
                	index = (index+1)%n;
                }
                turn = index;
                flags[this.turnoHilo] = pstate.IDLE;
            }
        }
    }
    public static void main(String[] args) throws Exception {
	ExecutorService ejecutor = Executors.newFixedThreadPool(n);
	for(int i=0; i<n; i++){
		ejecutor.execute(new P(i));
	}
	ejecutor.shutdown();
	while(!ejecutor.isTerminated()){}
            System.out.println("El valor del recurso compartido es " +enteroCompartido);
            System.out.printf("Deberia ser %d\n",n*iteraciones);
    }
}
