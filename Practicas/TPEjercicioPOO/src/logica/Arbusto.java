
package logica;


public class Arbusto extends Planta {
    
    private double anchoArbusto;
    private boolean esDomestico;
    private int variedadArbusto;
    private String colorHojas;
    private String sePodaOno;

    public Arbusto() {
    }

    public Arbusto(double anchoArbusto, boolean esDomestico, int variedadArbusto, String colorHojas, String sePodaOno, String nombre, double altoTallo, boolean tieneHojas, String climaIdeal) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.anchoArbusto = anchoArbusto;
        this.esDomestico = esDomestico;
        this.variedadArbusto = variedadArbusto;
        this.colorHojas = colorHojas;
        this.sePodaOno = sePodaOno;
    }

    public double getAnchoArbusto() {
        return anchoArbusto;
    }

    public void setAnchoArbusto(double anchoArbusto) {
        this.anchoArbusto = anchoArbusto;
    }

    public boolean isEsDomestico() {
        return esDomestico;
    }

    public void setEsDomestico(boolean esDomestico) {
        this.esDomestico = esDomestico;
    }

    public int getVariedadArbusto() {
        return variedadArbusto;
    }

    public void setVariedadArbusto(int variedadArbusto) {
        this.variedadArbusto = variedadArbusto;
    }

    public String getColorHojas() {
        return colorHojas;
    }

    public void setColorHojas(String colorHojas) {
        this.colorHojas = colorHojas;
    }

    public String getSePodaOno() {
        return sePodaOno;
    }

    public void setSePodaOno(String sePodaOno) {
        this.sePodaOno = sePodaOno;
    }

    @Override
    public String toString() {
        return "Arbusto{" + "anchoArbusto=" + anchoArbusto + ", esDomestico=" + esDomestico + ", variedadArbusto=" + variedadArbusto + ", colorHojas=" + colorHojas + ", sePodaOno=" + sePodaOno + '}';
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola soy un arbusto");
    }
            
            
            
}
