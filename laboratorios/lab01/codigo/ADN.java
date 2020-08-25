
import java.lang.Math;
public class ADN
{
   
    public static int cadenaADN(String c1, String c2){
    
        return cadenaAuxADN(c1, c2, c1.length(), c2.length());
    }
    private static int cadenaAuxADN(String c1, String c2, int ci, int cii){
    
        
        if((ci*cii)==0){
        
            return 0;
        }else if(c1.charAt(ci)==c2.charAt(cii)){
        
             return 1+cadenaAuxADN(c1,c2,ci-1,cii-1);
             
        }else{
        
            return Math.max(cadenaAuxADN(c1,c2,ci-1,cii), cadenaAuxADN(c1,c2,ci,cii-1));
        }
        
    }
}
/**
 * 
 *Title:IcsDNA
 *Author: Isabella Quintero, Sofia Vega
 *Date: 2020
 *Code Version: 1.0
 *Avalidability:https://github.com/mauriciotoro/ST0245-Eafit/blob/master/laboratorios/lab01/spoiler/java/Laboratory1.java
*/
