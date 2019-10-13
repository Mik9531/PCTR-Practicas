import java.util.*;

public class Estrella extends cuerpoastrofisico {
    protected double energia;

    public Estrella() {
    }

    public Estrella(double v, double m, double d, double e) {
        super(v, m, d);
        this.energia = e;
    }

    double getEnergia() {
        return this.energia;
    }

    void setEnergia(double e) {
        this.energia = e;
    }

}