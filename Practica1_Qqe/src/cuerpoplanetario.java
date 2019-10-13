import java.util.*;

public class cuerpoplanetario extends cuerpoastrofisico {
    private double gravedad;
    private String composicion;

    public cuerpoplanetario() {
    }

    public cuerpoplanetario(double g, String c, double v, double m, double d) {
        super(v, m, d);
        gravedad = g;
        composicion = c;
    }

    double getgravedad() {
        return this.gravedad;
    }

    void setgravedad(double g) {
        this.gravedad = g;
    }

    String getComposicion() {
        return this.composicion;
    }

    void setComposicion(String c) {
        this.composicion = c;
    }

}