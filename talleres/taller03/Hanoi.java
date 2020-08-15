

public class Hanoi
{
   
    public static void hanoi(int topN){
    hanoi(topN, "Torre1", "Torre2", "Torre3");
  }

 

  public static void hanoi(int topN, String a  , String b , String c  ){
    
    if (topN == 1){
        System.out.println(a + "->" + c);
    }
    else{ 
        hanoi(topN-1, a, c, b);
        hanoi(1, a , b, c);
        hanoi(topN-1, b, a, c);
    }
  }
}
