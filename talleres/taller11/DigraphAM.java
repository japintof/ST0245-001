
import java.util.ArrayList;


public class DigraphAM extends Graph {
	

	
	int[][] mat;
	public DigraphAM(int size) {
		super(size);
		mat = new int[size][size];
		
		System.out.print("");
	}

	
	public void addArc(int source, int destination, int weight) {
		mat[source][destination] = weight;
	}


	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> np= new ArrayList<>();
     	for(int i=0; i<mat.length; i++){
        	if(!(mat[vertex][i]==0 )){
         		np.add(i);
        	}
      	}	
     	return np; 
	}

	/**
	* Metodo para obtener el peso o longitud entre dos nodos
	* 
	* @param source desde donde inicia el arco
	* @param destination  donde termina el arco
	* @return un entero con dicho peso
	*/	
	public int getWeight(int source, int destination) {
		return mat[source][destination];
	}

}