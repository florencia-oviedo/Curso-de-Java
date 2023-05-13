
package conversiones;


public class Conversiones {
    public static void main(String[] args) {
        
        //Casting cambiar de tipo de dato a otro
        double num = 1.67;
        
        //cambio a int
        int numint = (int)num;
        
        //cambio a long
        long numLong = (long)numint;
        
        System.out.println("double:" + num);
        System.out.println("double:" + numint);//quita la parte con coma y queda la parte entera no redondea ni abajo ni arriba
        System.out.println("double:" + numLong);
        
        //Otro caso, de String castear a primitivos, conversion de tipos
        String cantidad = "15";
        String precio = "150.27";
        //String es una clase y tiene metodos para convertir a otros tipos de datos
        int cantEntero = Integer.parseInt(cantidad);//parseo , conversion
        double precioD = Double.parseDouble(precio);
        System.out.println("Calculo = " + cantEntero*precioD);
        
        //El proceso contrario de double/int a String
        int edad = 29;
        double estatura = 1.57;
        //String tiene un metodo valueOf
        String edadString = String.valueOf(edad);
        String estaturaString = String.valueOf(estatura);
        
        System.out.println("estaturaString = " + estaturaString + " edad: "+edadString);
        
        
        
    }
}
