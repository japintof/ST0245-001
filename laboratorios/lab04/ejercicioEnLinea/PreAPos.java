

public class PreAPos
{
    public Nodo node;
     public void inputPre(int n){
    
        if(node==null){
        
            node= new Nodo(n);
        }else{
        
            insertAux(node, n, null);
        }
        
    }
    
    private void insertAux(Nodo nodo,int n, Nodo nodo2){
    
        if(nodo==null){
        
            if(n>= nodo2.data){
            
                nodo2.right= new Nodo(n);
            }else{
            
                nodo2.left= new Nodo(n);
            }
        }
        else if(n<nodo.data){
            insertAux(nodo.left, n, nodo);
        }else{
        
            insertAux(nodo.right, n, nodo);
        }
    }
    
    public void outputPos(){
    
        auxOutputPos(node);
    }
    private void auxOutputPos(Nodo nodo){
    
        if(nodo==null){
        
            System.out.print("");
            
        }else{
        
            auxOutputPos(nodo.left);
            auxOutputPos(nodo.right);
            System.out.println(nodo.data + ",");
        }
    }
}
