
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;


public class DigraphAL extends Graph {
	private ArrayList<LinkedList<Pair<Integer,Integer>>> nodo;


	/**
	* Constructor para el grafo dirigido
	* @param vertices el numero de vertices que tendra el grafo dirigido
	*
	*/
	public DigraphAL(int size) {
		super(size);
		nodo = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            nodo.add(new LinkedList<>());
        }
		
	}

	
	public void addArc(int source, int destination, int weight) {
		 nodo.get(source).add(new Pair<>(destination,weight));
	}

	
	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> n = new ArrayList<>();

        nodo.get(vertex).forEach(i -> n.add(i.getKey()));

        return n;
	}

		
	public int getWeight(int source, int destination) {
		int result = 0;
        for (Pair<Integer, Integer> integerIntegerPair : nodo.get(source)) {
            if (integerIntegerPair.getKey() == destination) result = integerIntegerPair.getValue();
        }
        return result;
	}

}