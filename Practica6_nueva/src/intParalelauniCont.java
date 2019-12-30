/**
 * @author Miguel Afán Espinosa
 */



import java.util.*;
import java.util.concurrent.*;

public class intParalelauniCont{
	public static Scanner leer = new Scanner (System.in);
	public static Object c = new Object(); 
	public static double n;
	public static int dentro = 0; 
	public static void main(String[] args){
		System.out.println("Introduce el numero de puntos: ");
		n = leer.nextDouble();
		int nNuc = Runtime.getRuntime().availableProcessors(); 
		float Cb = leer.nextFloat(); 
		int tamPool = (int)(nNuc/(1-Cb)); 
		int tVentana = (int)n/tamPool;
		int linf = 0;
		int lsup = tVentana;
		ThreadPoolExecutor ejecutor = new ThreadPoolExecutor( 
		tamPool, tamPool, 0L,
		TimeUnit.MILLISECONDS,
		new LinkedBlockingQueue<Runnable>());
		long inicTiempo = System.currentTimeMillis();
		for (int i=0; i<tamPool; i++){ 
		ejecutor.execute(new Hilo(linf,lsup));
		linf = lsup;
		lsup = lsup + tVentana;
		}
		ejecutor.shutdown();
		while(!ejecutor.isTerminated()){}
		long tiempoTotal = System.currentTimeMillis()-inicTiempo;
		System.out.println("Calculo finalizado en "+tiempoTotal+" milisegundos");
		double resultado = (double)dentro/n;
		System.out.println("El area de f(x) = sen(x) es: "+resultado);
	}
	public static class Hilo implements Runnable{
		private int linf;
		private int lsup;
		public Hilo(int linf, int lsup){ 
		this.linf = linf;
		this.lsup = lsup;
		}
		public void run(){ 
			synchronized(c){ 
				for (int i=linf; i<lsup; i++){
				double x=Math.random();
				double y=Math.random();
				x=Math.sin(x);
				if(x <= y) dentro++;
				}
			}
		}	
	}
}
