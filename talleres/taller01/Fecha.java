
/**
 * La clase Fecha tiene la intención de representar el tipo abstracto fecha.
 * Aunque ya existen librerías encargadas de esta funcion:
 * @see <a href="http://www.baeldung.com/java-8-date-time-intro"> Ver documentacion tipo Time </a>
 * En este ejercicio podemos tener una compresión más profunda de su funcionamiento interno.
 * 
 * @author Mauricio Toro, Andres Paez
 * @version 1
 */

public class Fecha {
    

    /*

    varibales con atributo final indican que una variable es de tipo 
    constante, es decir, no admitirá cambios después de su declaración y asignación de valor.
    final determina que un atributo no puede ser sobreescrito o redefinido.
    Se le asigna esta característica para evitar que se sobrescriban valores.

    tener en cuenta tipado de las 3 variables!.
    */

    public long fecha=0;
    public int año;
    public int mes;
    public int dia;

    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Fecha(int año, int mes, int dia) {
        
        
        fecha = año*10000;
        fecha = fecha+(mes*100);
        fecha = fecha+dia; 
        
        this.año=año;
        this.mes=mes;
        this.dia=dia;

    }

    /**
     * Método para obtener la variable global dia.
     *
     * @return el dia
     */
    public int dia() {
        
        return dia;

    }

    /**
     * Método para obtener la variable global mes.
     *
     * @return el mes
     */
    public int mes() {

        return mes;
    }

    /**
     * Método para obtener la variable global anio.
     *
     * @return el año
     */
    public int año() {

        return año;
    }

    /**
    * @param otra representa la fecha con la cual se va a comparar.
    *
    * El método comprar se encarga de devolvernos respuesta a tres posibilidades.
    * 1: si la fecha es menor que la otra retorna -1.
    * 2: si la fecha es igual que la otra retorna 0.
    * 3: si la fecha es mayor que la otra retorna 1.
    *
    * @return -1 sí es menor; 0 sí es igual; 1 sí es mayor.
    *
    */

    public int comparar(int año2, int mes2, int dia2) {

        long fecha2;
        fecha2 = año2*10000;
        fecha2 = fecha2+(mes2*100);
        fecha2 = fecha2+dia2;
        
        int result=0;
        if(fecha<fecha2){
        
            result=-1;
        }else if(fecha2<fecha){
        
            result= 1;
        }else if(fecha==fecha2){
        
            result= 0;
        }
        return result;
    }


     /**
    * toString se encargará de convertir el tipo abstracto fecha en un tipo cadena
    * para su posterior visualización
    *
    * @return una cadena que contiene la fecha
    */
    //public String toString() {
        
        
    //}
}

