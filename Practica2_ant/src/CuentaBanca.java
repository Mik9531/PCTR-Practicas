/** 
 * @author Miguel Af�n Espinosa
 * @version 1.0
 * Clase  que modela una Cuenta corriente.
*/

public class CuentaBanca //Nombre de la clase
{
  private int Codigo_Cuenta;      //Codigo Cuenta Cliente
  private double Saldo_Cuenta;   //Saldo Actual

  public CuentaBanca (){} //constructor nulo
  
  public CuentaBanca (int id, double disponible){ //constructor  
	  this.Codigo_Cuenta=id;
	  this.Saldo_Cuenta=disponible;
  }
  
  public double  Saldo() {return this.Saldo_Cuenta;}
  
  public int Codigo () {return this.Codigo_Cuenta;}

  public void Deposito (double Cantidad){ 
	  if (Saldo_Cuenta>0)
		  Saldo_Cuenta=Saldo_Cuenta+Cantidad;
  }
  
  public boolean Reintegro (double Cantidad){
	  if((Cantidad <=0)||(Cantidad>Saldo_Cuenta))
		  return false;
	  else{
		  Saldo_Cuenta=Saldo_Cuenta-Cantidad;
		  return true;          
        }
  }
  

}


