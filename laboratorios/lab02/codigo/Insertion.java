 public class Insertion
{
    

    public static void insertionSort(int[] a){
        cicloVerdeDeGeegForGeeks(a);
    }

    private static void cicloVerdeDeGeegForGeeks(int[] a){
        for(int i = 0; i < a.length; i++ )
            cicloRojoDeGeekForGeeks(a, i);
    }

    private static void cicloRojoDeGeekForGeeks(int[] a, int indiceRojo){
       for(int j = indiceRojo; j > 0 ; j--)
            bailecito(a, j, j-1);
    }
    
     private static void intercambiar(int[] a, int izquierda, int derecha){
        int aux = a[izquierda];
        a[izquierda] = a[derecha];        
        a[derecha] = aux;
    }

    private static void bailecito(int[] a, int izquierda, int derecha){
        if (a[derecha] < a[izquierda])
            intercambiar(a, izquierda, derecha);
    }
    
    public static void tiempo(String[] args){
        
         for (int n = 20000; n >= 1000; n = n - 1000) {
        
             long ti = System.currentTimeMillis();
        
             insertionSort(new int[n]);
        
             long tf = System.currentTimeMillis();
        
             System.out.println(tf - ti);
        } 
    }
}
