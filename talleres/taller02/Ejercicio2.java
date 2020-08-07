

public class Ejercicio2
{
    
    public static boolean existe(int[] nums, int target){
    return existe(0, nums, target);
  }

 

  public static boolean existe(int start, int[] nums, int target){
    
     
     if (start >= nums.length) {
             if (target == 0)
                 return true;
             else
                 return false;
         }else{ 
            boolean bien = existe(start + 1,nums,target - nums[start]);
            if (bien)
                return true;
            else{
                boolean mal = existe(start + 1,nums,target);
                if (mal==false)
                     return false;
                else
                    return true;
            }
         }
  }
}
