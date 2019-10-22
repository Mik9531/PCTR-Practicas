import java.util.Date;

/**
 * @author Miguel Afán Espinosa
 * @version 1.0 Esta clase realiza el productor escalar de dos vectores de forma
 *          paralela.
 */

public class prodEscalarParalelo extends Thread {

	int idHebra, inicio, fin;
	double resultadoParcial = 0;
	static double resultadoFinal = 0;
	static double[] prodParcial = new double[10]; // tendrá la dimensión según el num de hebras.
	double[] vector1 = new double[1000000];
	double[] vector2 = new double[1000000];

	public prodEscalarParalelo() {
	};

	public prodEscalarParalelo(int idHebra, int inicio, int fin) {
		this.idHebra = idHebra;
		this.inicio = inicio;
		this.fin = fin;
	};

	public void run() {

		for (int i = inicio; i <= fin; i++) {

//			vector1[i] = 1;
			vector1[i] = Math.random() * 1000;
//			vector2[i] = 1;
			vector2[i] = Math.random() * 1000;
			resultadoParcial += vector1[i] * vector2[i];

		}

		prodParcial[idHebra] = resultadoParcial;
	}

	/**
	 * Main
	 * 
	 * @param args
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws Exception {

		Date d = new Date();
		long inicCronom = System.currentTimeMillis(); // se prepara el cronometro
		d.setTime(inicCronom); // se activa el cronometro

		prodEscalarParalelo h1 = new prodEscalarParalelo(0, 0, 99999);
		prodEscalarParalelo h2 = new prodEscalarParalelo(1, 100000, 199999);
		prodEscalarParalelo h3 = new prodEscalarParalelo(2, 200000, 299999);
		prodEscalarParalelo h4 = new prodEscalarParalelo(3, 300000, 399999);
		prodEscalarParalelo h5 = new prodEscalarParalelo(4, 400000, 499999);
		prodEscalarParalelo h6 = new prodEscalarParalelo(5, 500000, 599999);
		prodEscalarParalelo h7 = new prodEscalarParalelo(6, 600000, 699999);
		prodEscalarParalelo h8 = new prodEscalarParalelo(7, 700000, 799999);
		prodEscalarParalelo h9 = new prodEscalarParalelo(8, 800000, 899999);
		prodEscalarParalelo h10 = new prodEscalarParalelo(9, 900000, 999999);

		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		h6.start();
		h7.start();
		h8.start();
		h9.start();
		h10.start();

		h1.join();
		h2.join();
		h3.join();
		h4.join();
		h5.join();
		h6.join();
		h7.join();
		h8.join();
		h9.join();
		h10.join();

		for (int i = 0; i < prodParcial.length; i++) {
			resultadoFinal += prodParcial[i];
		}

		System.out.println("El productor escalar es: " + resultadoFinal);

		System.out.println("");

		long finCronom = System.currentTimeMillis(); // se para el cronometro
		d.setTime(finCronom);
		System.out.println("Acabando trabajo tras " + (finCronom - inicCronom) + " milisegundos");
	}

}
