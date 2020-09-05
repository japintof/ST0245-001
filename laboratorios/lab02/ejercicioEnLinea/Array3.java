

public class Array3
{
   public int maxSpan(int[] nums) {
  int max = 0;
    
    for(int i = 0; i < nums.length; i++) {
        int j = nums.length - 1;
              
        while(nums[i] != nums[j])
            j--;
                              
        int span = j - i + 1;
                                      
        if(span > max)
            max = span;
    }
                                                    
    return max;
}

public int[] fix34(int[] nums) {
   int i = 0;
    
    while(i < nums.length && nums[i] != 3)
        i++;
              
    int j = i + 1;
                  
    while(j < nums.length && nums[j] != 4)
        j++;
                            
    while(i < nums.length) {
        if(nums[i] == 3) {
            int temp = nums[i+1];
            nums[i+1] = nums[j];
            nums[j] = temp;
                                                          
            while(j < nums.length && nums[j] != 4)
                j++;
        }
        i++;
    }

    return nums;
}

public int[] squareUp(int n) {
  int[] a=new int[n*n]; 
  if(n==0){
    return a;
  }else{
     for(int i = n - 1; i < a.length; i+=n) {
        for(int j = i; j >= i - i / n; j--)
            a[j] = i - j + 1;
    }
  }
  return a;
}

 public int[] seriesUp(int n) {
  int[] a = new int[n*(n+1)/2];
  if(n==1){
      a[n-1]=n;
 }
  else{
    int pre=0;
     for(int i = 1; i <= n; i++) {
        for(int j = 0; j < i; j++) {
            a[pre + j] = j + 1;
        }
        pre= pre+i;
    }
  }
  return a;
}

public int countClumps(int[] nums) {
  int count = 0;
    int i = 0;
      
    while(i < nums.length) {
        int val = nums[i];
        i++;
        int length = 1;
        while(i < nums.length && nums[i] == val) {
            i++;
            length++;
        }
                                            
        if(length > 1)
            count++;
    }
                                                          
    return count;
}
}
/**
 * 
 *Title:codingbat
 *Author: Alfredo Mirando
 *Date: 2013
 *Code Version: 1.0
 *Avalidability:https://github.com/mirandaio/codingbat/tree/master/java/array-3
*/
