
import java.util.LinkedList;
import java.util.ArrayList;
import javafx.util.Pair; 
public class UnaTablaDeHash
{

   private Persona[] tabla;


   public UnaTablaDeHash(){
      tabla = new Persona[10];
   }

 

   
   private int funcionHash(String k){
       return ((int) k.charAt(0)) % 10;
   }

 

  
   public int get(String k){
    
      return tabla[funcionHash(k)].numero;
   }

 

   
   public void put(String k, int v){
      
      tabla[funcionHash(k)].numero=v;
   }
}