
// Miguel Afán Espinosa
// Practica 8
// Conductor.java



public class Conductor{
	private static String nombre,coche;
	private static int dni;
	
	public void Conductor(String nombre, String coche, int dni){ 
	this.nombre = nombre;
	this.coche = coche;
	this.dni = dni;
	}
	
	public synchronized String setNombre(String nombre){
		return nombre;
	}
	public synchronized String setCoche(String coche){
		return coche;
	}
	public synchronized int setDNI(int dni){
		return dni;
	}
	public synchronized void getNombre(String nombre){
		System.out.println("El nombre del conductor es: "+nombre);
	}
	public synchronized void getCoche(String coche){
		System.out.println("El nombre del coche es: "+coche);
	}
	public synchronized void getDNI(int dni){
		System.out.println("El numero del dni es: "+dni);
	}
}
