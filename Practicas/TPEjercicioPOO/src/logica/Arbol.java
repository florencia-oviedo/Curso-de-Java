
package logica;


public class Arbol extends Planta {
    
    private int variedad;
    private String tipoTronco;
    private double radioTronco;
    private String color;
    private String tipoHoja;

    public Arbol() {
    }

    public Arbol(int variedad, String tipoTronco, double radioTronco, String color, String tipoHoja, String nombre, double altoTallo, boolean tieneHojas, String climaIdeal) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.variedad = variedad;
        this.tipoTronco = tipoTronco;
        this.radioTronco = radioTronco;
        this.color = color;
        this.tipoHoja = tipoHoja;
    }

    public int getVariedad() {
        return variedad;
    }

    public void setVariedad(int variedad) {
        this.variedad = variedad;
    }

    public String getTipoTronco() {
        return tipoTronco;
    }

    public void setTipoTronco(String tipoTronco) {
        this.tipoTronco = tipoTronco;
    }

    public double getRadioTronco() {
        return radioTronco;
    }

    public void setRadioTronco(double radioTronco) {
        this.radioTronco = radioTronco;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoHoja() {
        return tipoHoja;
    }

    public void setTipoHoja(String tipoHoja) {
        this.tipoHoja = tipoHoja;
    }

    @Override
    public String toString() {
        return "Arbol{" + "variedad=" + variedad + ", tipoTronco=" + tipoTronco + ", radioTronco=" + radioTronco + ", color=" + color + ", tipoHoja=" + tipoHoja + '}';
    }
    
    //metodo para saludar
    @Override
    public void saludar(){
        System.out.println("Hola soy un árbol");
    }
    
    
}
