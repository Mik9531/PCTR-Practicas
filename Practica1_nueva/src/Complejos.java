/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 * Esta clase contiene los m�todos de suma, resta, divisi�n, multiplicaci�n y m�dulo que, generalmente, la obtenemos preguntando al usuario cual
 * es su parte real y compleja del primer n�mero y el segundo para posteriormente realizar las dichas operaciones.
*/

import java.util.Scanner;

public class Complejos {
	
	private Scanner s;



	public void Datos(double[] numcomplejo){
		s = new Scanner(System.in);
		
		for(int i=0;i<numcomplejo.length;i++){
			if(i%2==0){
				
				System.out.println("Introduzca la parte real: ");
				numcomplejo[i]= s.nextDouble();
			}else{
				System.out.println("Introduzca la parte imaginaria: ");
				numcomplejo[i] = s.nextDouble();
			}
		}
	}

	
	public double[] Suma(double[] numcomplejo){
		double[]resultado = new double[2];
		for(int i=0; i<numcomplejo.length;i++){
			if(i%2==0){
				resultado[0] = resultado[0] + numcomplejo[i];
				}else{
					resultado[1] = resultado[1] + numcomplejo[i];
				}
			
		}
		return resultado;
	}
	
	
	public double[] resta(double numcomplejos[]){
		double[] resultado1 = new double [2];
		resultado1[0] = numcomplejos[0];
		resultado1[1] = numcomplejos[1];
		
		for(int i= 2; i<numcomplejos.length; i++){
			
			if(i%2==0){
				
				resultado1[0] = resultado1[0]-numcomplejos[i];
			}else{
				
				resultado1[1] = resultado1[1]-numcomplejos[i];
			}
		}
		return resultado1;
	}

	
	
	public double[] Modulo(double[] numcomplejos){
	double[] resultado2 = new double[4];
	double[] modulo = new double[2];
	
	for(int i=0; i<numcomplejos.length;i++){
		resultado2[i] = numcomplejos[i];
	}
	
	modulo[0] = Math.sqrt((Math.pow(resultado2[0], 2))+(Math.pow(resultado2[1], 2)));
	modulo[1] = Math.sqrt((Math.pow(resultado2[2], 2))+(Math.pow(resultado2[3], 2)));
	
	return modulo;
}

	
	
	public double[] Multiplicacion(double[] numcomplejos){
	
	double[] resultado3 = new double[2];
	int i = -1;
	
	resultado3[0] = (numcomplejos[0]*numcomplejos[2])+(numcomplejos[1]*numcomplejos[3]);
	resultado3[1] = (numcomplejos[0]*numcomplejos[3])+((numcomplejos[1]*numcomplejos[2])*i);
	
	return resultado3;
}

	
	
	public double[] Division(double[] numcomplejos){
	
	double[] resultado4 = new double[4];
	
	double auxiliar = (numcomplejos[2]*numcomplejos[2]) + (numcomplejos[3]*numcomplejos[3]);
	resultado4[0] = (numcomplejos[0]*numcomplejos[2]+numcomplejos[1]*numcomplejos[3]);
	resultado4[1] = (numcomplejos[1]*numcomplejos[2]-numcomplejos[0]*numcomplejos[3]);
	resultado4[3] = auxiliar;
	
	return resultado4;
}
}
