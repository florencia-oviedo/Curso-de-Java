
package logica;


public class Flor extends Planta {
    
    private String colorPetalos;
    private double cantPromPetalos;
    private String colorPistilo;
    private int variedadFlor;
    private String estacionFlorece;

    public Flor() {
    }

    public Flor(String colorPetalos, double cantPromPetalos, String colorPistilo, int variedadFlor, String estacionFlorece, String nombre, double altoTallo, boolean tieneHojas, String climaIdeal) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.colorPetalos = colorPetalos;
        this.cantPromPetalos = cantPromPetalos;
        this.colorPistilo = colorPistilo;
        this.variedadFlor = variedadFlor;
        this.estacionFlorece = estacionFlorece;
    }

    public String getColorPetalos() {
        return colorPetalos;
    }

    public void setColorPetalos(String colorPetalos) {
        this.colorPetalos = colorPetalos;
    }

    public double getCantPromPetalos() {
        return cantPromPetalos;
    }

    public void setCantPromPetalos(double cantPromPetalos) {
        this.cantPromPetalos = cantPromPetalos;
    }

    public String getColorPistilo() {
        return colorPistilo;
    }

    public void setColorPistilo(String colorPistilo) {
        this.colorPistilo = colorPistilo;
    }

    public int getVariedadFlor() {
        return variedadFlor;
    }

    public void setVariedadFlor(int variedadFlor) {
        this.variedadFlor = variedadFlor;
    }

    public String getEstacionFlorece() {
        return estacionFlorece;
    }

    public void setEstacionFlorece(String estacionFlorece) {
        this.estacionFlorece = estacionFlorece;
    }

    @Override
    public String toString() {
        return "Flor{" + "colorPetalos=" + colorPetalos + ", cantPromPetalos=" + cantPromPetalos + ", colorPistilo=" + colorPistilo + ", variedadFlor=" + variedadFlor + ", estacionFlorece=" + estacionFlorece + '}';
    }
    
    @Override
    public void saludar(){
        System.out.println("Hola soy una flor");
    }
    
    
    
    
    
}
