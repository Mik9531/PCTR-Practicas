

public class sistemaSolar {

    public static void main(String[] args) {
        Estrella sol = new Estrella(2.5, 2.5, 2.5, 5.4);
        cuerpoplanetario tierra = new cuerpoplanetario(9.8, "gas", 2.5, 2.5, 2.5);
        satelite luna = new satelite(tierra, 4.3, "duro", 2.5, 2.5, 2.5);
    }

}