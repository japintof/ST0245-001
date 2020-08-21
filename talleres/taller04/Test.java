

public class Test
{
      public static boolean ejercicioFibonacci(){
	       long a,b,c,d;
	       a = Fibonacci.fibonacci(4);
	       b = Fibonacci.fibonacci(8);
	       c = Fibonacci.fibonacci(12);
	       d = Fibonacci.fibonacci(16);
	       if(a==3 && b==21 && c==144 && d==987)
	    	   return true;
	       return false;
	    }

	     public static boolean ejercicioMaximos(){
	        int a,b,c,d;
	        a = ArrayMax.arrayMax(new int[] {12,324,43,2,3,43,2,3,43},8);
	        b = ArrayMax.arrayMax(new int[] {3,2,343,2,43,55,67,68,86,3,4},10);
	        c = ArrayMax.arrayMax(new int[] {56,7,6,45,8,4,34,8,7,5,34,7,78,9},13);
	        d = ArrayMax.arrayMax(new int[] {1,2,3,4,5,5},5);
	        
	        if(a!=324 || b!=343 || c!=78 || d!=5)
	            return false;
	        return true;
	    }
	    
	    public static boolean ejercicioSuma(){
	    	boolean a, b, c, d;
			a=GrupoSum.groupSum(0, new int[] {2, 4, 8}, 9);
			b=GrupoSum.groupSum(0, new int[] {2, 4, 8}, 8);
			c=GrupoSum.groupSum(0, new int[] {10, 2, 2, 5}, 9);
			d=GrupoSum.groupSum(0, new int[] {10, 2, 2, 5}, 17);
			if(!a && b && c && d)
				return true;
			return false;
		}
	    
}

