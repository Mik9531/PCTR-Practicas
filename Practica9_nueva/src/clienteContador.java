
/**
 * @author Miguel Afán Espinosa
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class clienteContador
{
    public static void main(String[] args) 
	throws Exception
    {
   
        
	int puerto = 2001;

	for(int vueltas=0; vueltas<3; vueltas++){ 
	        	int i = (int)(Math.random()*10);
			try{
            			System.out.println("Realizando conexion a página web...");
            			Socket cable = new Socket("localhost", 2001);
            			System.out.println("Realizada conexion mediante "+cable);
            			PrintWriter salida= new PrintWriter(
                                			    new BufferedWriter(
                                			        new OutputStreamWriter(
            			cable.getOutputStream())));
            			salida.println(i);
            			salida.flush();
            			System.out.println("Cerrando conexion...");
            			cable.close();

            		}
                	catch (Exception e)
        		{System.out.println("Error en sockets...");}
		
	}

    }
}

