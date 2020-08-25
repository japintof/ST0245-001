
public class RellenarR
{
   
    public static int ways(int n){
    
    
        if(n<=2){ 
        return n;
       }else{
        
           return ways(n-1)+ways(n-2);
        }
        
    }
}
/**
 * 
 *Title:ways
 *Author: Isabella Quintero, Sofia Vega
 *Date: 2020
 *Code Version: 1.0
 *Avalidability:https://github.com/mauriciotoro/ST0245-Eafit/blob/master/laboratorios/lab01/spoiler/java/Laboratory1.java
*/