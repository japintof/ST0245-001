
import java.util.*;
public class EstructuraDatos
{
    public int size;
    public ArrayList<Triplet<Node, Node, Double>> adjGraph = new ArrayList<>();
    
    public EstructuraDatos(HashMap<Long, Node> nodes, ArrayList<Triplet<Long, Long, Double>> edges){
        this.size = size();
        for(Triplet<Long, Long, Double> t : edges) {
            Triplet<Node, Node, Double> tr = new Triplet(0, 0, 0);
            adjGraph.add(tr);
        }
    }

    
    public  ArrayList<Long> getSuccessors(Long vertexID){
        ArrayList<Long> sucesores = new ArrayList<>();
        for(int i=0; i<=adjGraph.size()-1; i++){
            Triplet<Node, Node, Double> n = adjGraph.get(i);
            if(vertexID == 0){
                sucesores.add(vertexID);
            }
            
        }
        return sucesores;
    }

    
    public Double getWeight(Long sourceID, Long destinationID){
        for(int i=0; i < adjGraph.size(); i++){
            if((sourceID == null) && (destinationID == null)){
                return adjGraph.get(i).z;
            }
        }
        return -1.0;
    }

    /**
     * Metodo que tiene la intencion de retornar el tamaño del grafo
     * @return tamaño del grafo
     */
    public int size() {
        return this.size;
    }
}