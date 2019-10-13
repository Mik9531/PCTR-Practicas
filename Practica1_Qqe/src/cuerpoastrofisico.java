import java.util.*;

public class cuerpoastrofisico extends sistemaSolar {
    protected double volumen;
    protected double masa;
    protected double diametro;

    public cuerpoastrofisico() {
    }

    public cuerpoastrofisico(double v, double m, double d) {
        this.volumen = v;
        this.masa = m;
        this.diametro = d;
    }

    double getVolumen() {
        return this.volumen;
    }

    void setVolumen(double v) {
        this.volumen = v;
    }

    double getMasa() {
        return this.masa;
    }

    void setMasa(double m) {
        this.masa = m;
    }

    double getDiametro() {
        return this.diametro;
    }

    void setDiametro(double d) {
        this.diametro = d;
    }

}