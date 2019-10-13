/** 
 * @author Miguel Afán Espinosa
 * @version 1.0
 * Esta clase crea objetos como sol, tierra o luna, aplicando métodos implementados en sus clases correspondientes.
*/

public class sistemaSolar {
	
    public static void main(String[] args) {
    	
    	Estrella sol = new Estrella (9, 16, 20, 300);
    	System.out.println(sol.energia);
    	
    	cuerpoplanetario tierra = new cuerpoplanetario(30,40,50,9.8,"Sólido");
    	String com = tierra.getComposicion();
    	System.out.println(com);
    	
    	satelite luna = new satelite (8,15,14,6.5,"Sólido",tierra);
    	luna.setComposicion("Rocoso");
    	System.out.println(luna.composicion);

    }

}
