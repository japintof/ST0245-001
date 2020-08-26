

    public class ArrayMax
{
    public static int arrayMax(int[] array, int n) {
		
        int i, max, temp;
	max = array[n];
	if(n==0){
	    temp = arrayMax(array, 0 );
	    if(temp < max)
		max = temp;
	}
	return max;

    }
}
