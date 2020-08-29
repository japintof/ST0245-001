

public class SumaArreglo
{
    public static int suma(int[] a){
        int acum = 0;  //   c1 
        for (int i = 0; i < a.length; i++) //c2 + c3n
            acum = acum + a[i]; //  c4*n
        return acum; //c5
    }                // T(n) = c1 + c2 + c3n + c4n + c5 es O(n)
    
    public static void tiempo(String[] args ){
      for (int n = 10000000; n <= 200000000; n = n + 10000000) {
        long ti = System.currentTimeMillis();
        suma(new int[n]);
        long tf = System.currentTimeMillis();
        System.out.print((n/10000000)+") ");
        System.out.println(tf - ti);
     }
   }
}
