/**
 * @author Miguel Afán Espinosa
 */


import java.util.*;
import java.util.concurrent.*;

public class usaConductores implements Runnable{
	public static Scanner x = new Scanner(System.in);
	public static int conductores = 10;
	Conductor c1 = new Conductor();
	Conductor c2 = new Conductor();
	int linf, lsup;					
	usaConductores(int linf, int lsup){ 
		this.linf = linf;
		this.lsup = lsup;
	}
	public static void main(String[] args){
		int nt, tVentana, linf, lsup;
		int nNuc = Runtime.getRuntime().availableProcessors(); 	
		float cb = x.nextFloat();			
		nt = (int) (nNuc / 1 - cb);			
		ThreadPoolExecutor ejecutor = new ThreadPoolExecutor(	
				nt,
				nt,
				0L,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());
		tVentana = conductores / nt;
		linf = 0;
		lsup = tVentana;
		for(int i = 0; i < nt; i++){
			ejecutor.execute(new usaConductores(linf, lsup));
			linf = lsup;
			lsup = lsup + tVentana;
		}
	}
	public void run(){ 
		String n1 = new String();
		String n2 = new String();
		n1 = "Pepe";
		n2 = "Antonio";
		for(;;){
			for(int i = linf; i < lsup; i++){
				
				try{if(i%2==0){
					c1.setNombre(n1);
					c1.getNombre(n1);
					Thread.sleep(200);}
				else{
					c2.setNombre(n2);
					c2.getNombre(n2);
					Thread.sleep(200);}
				}
				catch(Exception e){}
			}
		}
	}

}
