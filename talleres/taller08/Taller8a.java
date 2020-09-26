
import java.util.Stack; 
class Taller8a{
 
  public static int notacionPolacaInversa(String s){
    String simbolos = "+-*/";
    Stack<Integer> unaPila = new Stack();
    if (s.length()> 2){
   
      for (String subcadena : s.split(" ")){
      
      if (subcadena.contains(subcadena)){
         if (subcadena.equals("+")){
            unaPila.push(unaPila.pop()+unaPila.pop()); 
         }
         if (subcadena.equals("-")){
            unaPila.push(-1*unaPila.pop()+unaPila.pop()); 
         }
         if (subcadena.equals("*")){
            unaPila.push(unaPila.pop()*unaPila.pop()); 
         }
         if (subcadena.equals("/")){
            int numeroDeArriba = unaPila.pop();
            int numeroDeAbajo =  unaPila.pop();
            unaPila.push(numeroDeAbajo/numeroDeArriba); 
         }
        }
         else{
         unaPila.push(Integer.parseInt(subcadena)); 
        }
     
     }
    }
    return unaPila.pop();
  }
}