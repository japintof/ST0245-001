
public class Recursion2
{
   public boolean groupSum6(int start, int[] nums, int target) {
  
   if(start >= nums.length)
        return target == 0;
          
    if(nums[start] == 6)
        return groupSum6(start+1, nums, target - 6);
                    
    if(groupSum6(start+1, nums, target - nums[start]))
        return true;
                              
    if(groupSum6(start+1, nums, target))
        return true;
                                        
    return false;
  
 }

 public boolean groupNoAdj(int start, int[] nums, int target) {
   if(start >= nums.length)
        return target == 0;
          
    if(groupNoAdj(start+2, nums, target - nums[start]))
        return true;
                    
    if(groupNoAdj(start+1, nums, target))
        return true;
                              
    return false;
 }
 public boolean groupSum5(int start, int[] nums, int target) {
  if(start >= nums.length)
        return target == 0;
          
    if(nums[start] % 5 == 0) {
        if(start <= nums.length - 2 && nums[start+1] == 1)
            return groupSum5(start+2, nums, target - nums[start]);
                            
        return groupSum5(start+1, nums, target - nums[start]);
    }
                                    
    if(groupSum5(start+1, nums, target - nums[start]))
        return true;
                                              
    if(groupSum5(start+1, nums, target))
        return true;
                                                        
    return false;
    
 }
 public boolean groupSumClump(int start, int[] nums, int target) {
   if(start >= nums.length)
        return target == 0;
          
    int i = start;
    int sum = 0;
    
    while(i < nums.length && nums[start] == nums[i]) {
        sum += nums[i];
        i++;
    }
                              
    if(groupSumClump(i, nums, target - sum))
        return true;
                                        
    if(groupSumClump(i, nums, target))
        return true;
                                                  
    return false;
 }
 public boolean splitOdd10(int[] nums) {
    return splitOdd10Helper(0, nums, 0, 0);
 }

 public boolean splitOdd10Helper(int start, int[] nums, int mult, int odd) {
    if(start >= nums.length)
        return mult % 10 == 0 && odd % 2 == 1;
            
    if(splitOdd10Helper(start+1, nums, mult + nums[start], odd))
        return true;
                      
    if(splitOdd10Helper(start+1, nums, mult, odd + nums[start]))
        return true;
                                
    return false;
 }
} 
/**
 * 
 *Title:codingbat
 *Author: Alfredo Mirando
 *Date: 2013
 *Code Version: 1.0
 *Avalidability:https://github.com/mirandaio/codingbat/tree/master/java/recursion-2
*/