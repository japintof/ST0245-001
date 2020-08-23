public class ADN

 {


 public static int cadenaADN(String c1, String c2){


 return cadenaAuxADN(c1, c2, c1.length(), c2.length());

 }

 private static int cadenaAuxADN(String c1, String c2, int ci, int cii){



 if((ci*cii)==0){


 return 0;

 }else if(c1.charAt(ci-1)==c2.charAt(cii-1)){


 return 1+cadenaAuxADN(c1,c2,ci-1,cii-1);


 }else{


 return cadenaAuxADN(c1,c2,ci-1,cii-1);

 }


 }

 }