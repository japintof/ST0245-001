
import java.util.ArrayList;


public abstract class Graph {
	protected int size;

	
	public Graph(int vertices) {
		size = vertices;
	}

	/**
	* Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
	* y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
	* @param source desde donde se hara el arco
	* @param destination hacia donde va el arco
	* @param weight el peso de la longitud entre source y destination
	*/
	public abstract void addArc(int source, int destination, int weight);

	
	public abstract ArrayList<Integer> getSuccessors(int vertex);

	
		
	public abstract int getWeight(int source, int destination);


	
	public int size() {
		return size;
	}
}