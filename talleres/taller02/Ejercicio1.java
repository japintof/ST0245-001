

public class Ejercicio1
{
    
    public static int gcd(int p, int q){ 
    if (q == 0){
        return p;
    }else{
        return gcd(q, p % q);
    }
   }   
}
