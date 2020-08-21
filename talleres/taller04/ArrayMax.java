

public class ArrayMax
{
    public static int arrayMax(int[] array, int n) {
		
        
	
	if(n==1){
	    
	    return array[0];
	   }else{
	       return Math.max(array[n-1], arrayMax(array, n-1));
            }
	}
	

    }

