

public class Solicitud
{
  
    public String nombreTienda;
    public int numNeveraSoli;
    
    Solicitud(String nom, int num){
    
        nombreTienda=nom;
        numNeveraSoli=num;
    }
    
    public String getnombre(){
        
        return nombreTienda;
    }
    
    int getNumeroDePedidos(){
    
        return numNeveraSoli;
    }
}
