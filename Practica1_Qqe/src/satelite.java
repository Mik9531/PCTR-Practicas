import java.util.*;

public class satelite extends cuerpoplanetario {
    protected cuerpoplanetario orbita;

    public satelite() {
    }

    public satelite(cuerpoplanetario o, double g, String c, double v, double m, double d) {
        super(g, c, v, m, d);
        orbita = o;
    }

    cuerpoplanetario getorbita() {
        return this.orbita;
    }

    void setorbita(cuerpoplanetario o) {
        this.orbita = o;
    }

}