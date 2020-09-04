

public class Array

    {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[];

    
    public Array() {
	elements = new int[DEFAULT_CAPACITY];
	size = 0;
    }


    
    public int size() {
        return size;
    }

    
     public void add(int e) {       
        if (size == elements.length) { 
            int[] otroArreglo = new int[elements.length*2];
            for (int i = 0; i < elements.length; i++) // O(n)
                otroArreglo[i] = elements[i];
            elements = otroArreglo;
        }
       
        elements[size] = e;
        size++;
    }   


    
    public int get(int i) throws Exception{
        
        for (int index = 0; index < elements.length; index++)
            if (index == i)
                return elements[index];
        return elements[i];
    }


    
     public void add(int index, int e) throws Exception {
        if (index > size || index < 0)   // O(1)
            throw new Exception("index: " + index); // O(1)
                       
        int[] copyArray; // O(1)
       
        if (size == elements.length) // O(1)
            copyArray = new int[elements.length*2]; // O(1)
        else
            copyArray = new int[elements.length]; // O(1)
       
        for(int i = 0; i < index; i++){ // O(n)
            copyArray[i] = elements[i]; // O(n)
        }
        copyArray[index] = e; // O(1)
        for(int i = index; i < copyArray.length; i++){ // O(n)
            copyArray[i+1] = elements[i]; // O(n)
        }
        size++; // O(1)
        elements = copyArray; // O(1)
    }                        // T(n) = O(n) !!
    
    public void del(int index) throws Exception{
        
        if (index > size || index < 0)   // O(1)
            throw new Exception("index: " + index); // O(1)

                for (int j = index; j < elements.length - 1; j++) {
                    elements[j] = elements[j+1];// O(n)
                }

        size--;
       
    }// T(n) = O(n) !!
}
// No sería viable con millones de datos por su complejidad lineal
