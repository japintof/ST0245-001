

public class Ejercicion3
{ 
    
    
  
    private static boolean SumaGrupoAvanzado(int start, int[] nums, int target) {
	if(start >= nums.length){
	    return target == 0;
	}
        else
            return SumaGrupoAvanzado(start + 1, nums, target) || SumaGrupoAvanzado( start+1, nums, target - nums[start]);
    }

     public static void combinations(String s) {
	combinationsAux("", s);
    }
  
  private static void combinationsAux(String prefix, String s) {
	if(s.length()== 0) {
	    System.out.println(s);
	}else{
	    combinationsAux( prefix + s.charAt(0), s.substring(1));
	    combinationsAux( prefix, s.substring(1));
	}
    }
}
