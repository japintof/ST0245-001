
import java.util.*;
public class Teclado{
    public static void tecladoRoto(String texto){
        LinkedList<Character> res = new LinkedList <>();
        int aux = 0;

        for(int i=0; i<=texto.length()-1; i++){
            
            char error= texto.charAt(i);
            if(error== '['){
                aux = 0;
            }else if(error == ']'){
                aux = res.size();
            }else
                res.add(aux++, error);
        }

        StringBuilder t = new StringBuilder();
        for(char l : res)
            t.append(l);

        System.out.println(t); 
    }
}
