
public class Array2
{
    
public boolean has77(int[] nums) {
  return has77Aux(nums, nums.length);
}
private boolean has77Aux(int[] a, int n){
  if(n<=2)
  return false;
  if(a[0]==7 && (a[1]==7||a[2]==7))
  return true;
  if(a[n-1]==7){
    if(a[n-2]==7 || a[n-3]==7){
      return true;
    }else if(n-1!=0){
      return has77Aux(a,n-1);
   
    }else{
      return false;
    }
  }else{
    return has77Aux(a,n-1);
  }
}

public boolean twoTwo(int[] nums) {
  return twoAux(nums, nums.length);
}
private boolean twoAux(int[] a, int n){
  if(n==0)
  return true;
  if(a[0]==2 && n==1)
  return false;
  if(a[n-1]==2){
    if(a[n-2]==2){
      return true;
    }else{
      return false;
    }
  }else{
    return twoAux(a, n-1);
  }
}

public boolean has22(int[] a) {
  return has22Aux(a,a.length);
}
private boolean has22Aux(int[] a, int i){
  if(i<=1)
  return false;
  if((a[i-1])==2 && (a[i-2])==2){
   return true;
  }else{
    return has22Aux(a,i-1);
  }
}

public boolean only14(int[] nums) {
  return only14Aux(nums, nums.length);
}
private boolean only14Aux(int[] nums, int i){
  if(i==0){
    return true;
  }else if((nums[i-1]!=4)&&(nums[i-1]!=1)){
    return false;
  }else{
     return true && only14Aux(nums,i-1);
    
  }
 
}

public boolean lucky13(int[] nums) {
  return lucky13Aux(nums, nums.length);
}
private boolean lucky13Aux(int[] nums, int i){
  if(i==0){
    return true;
  }else if(nums[i-1]==3||nums[i-1]==1){
    return false;
  }else{
     return lucky13Aux(nums,i-1);
   
  }
}
}
