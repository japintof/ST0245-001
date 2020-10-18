

public class Arbolito
{
    public Nodo node;
    
    public void insertar(int n){
    
        if(node==null){
        
            node= new Nodo(n);
        }else{
        
            insertarAux(node, n, null);
        }
        
    }
    
    public boolean buscar(int n){
    
        return buscarAux(node, n);
    }
    
    public void verArbolito(){
    
        verArbolitoAux(node);
        System.out.println("Para ver el arbolito copie y pegue lo de arriba y pongalo en");
        System.out.println("http://www.webgraphviz.com/");
    }
    
    private void insertarAux(Nodo node,int n, Nodo node2){
    
        if(node==null){
        
            if(n>= node2.data){
            
                node2.rigth= new Nodo(n);
            }else{
            
                node2.left= new Nodo(n);
            }
        }
        else if(n<node.data){
            insertarAux(node.left, n, node);
        }else{
        
            insertarAux(node.rigth, n, node);
        }
    }
    
    private boolean buscarAux(Nodo node, int n){
    
        if(node==null)
        return false;
        if(node.data==n)
        return true;
        if(n>=node.data){
        
            return buscarAux(node.rigth, n);
        }else{
        
            return buscarAux(node.left, n);
        }
    }
    
    private void verArbolitoAux(Nodo n){
    
        if (n.left == null){ 
            return;
        }else{
            System.out.println("\"" + n.data + "\"" + " -> " + "\"" + n.left.data + "\"");
        }
        if (n.rigth == null){
            return;
        }else{
            System.out.println("\"" + n.data + "\"" + " -> " + "\"" + n.rigth.data + "\"");
        }
        verArbolitoAux(n.left);  
        verArbolitoAux(n.rigth);
    }
}
