import java.io.*;
import java.math.BigInteger;

class FactorialSum{
  //long f=1,product=1;
  BigInteger product=BigInteger.valueOf(1);
  BigInteger SUM=BigInteger.ZERO;
  public BigInteger calcFSum(long n){
    
    if(n==1){
      return BigInteger.valueOf(1);
    }
    else{
      //System.out.println("prod: "+product);
      product=BigInteger.valueOf(n).multiply(calcFSum(n-1));
    }
   // System.out.println(n +"'s prod: "+product);
    
    
    
    return product;
  }
  public void calcSum(BigInteger product){
    //System.out.println("***Inside SUM*** =>"+ product);
  BigInteger temp=BigInteger.ZERO;
   
   
    while(product.compareTo(BigInteger.ZERO)==1){
      
      //System.out.println("***Inside SUM LOOP*** =>"+ product);
      temp=product.mod(BigInteger.valueOf(10));
      SUM=SUM.add(temp);
      product= product.divide(BigInteger.valueOf(10));
       //System.out.println(" TEMP: "+temp);
    }
  System.out.println("SUM:" +SUM);  
  return;
  }
  public  static void main(String s[]) throws Exception{
    FactorialSum f=new FactorialSum();
    long n;
    BigInteger b= BigInteger.ZERO;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter number:");
    n=Long.parseLong(br.readLine());
    if(n==0)
      System.out.println(0);
    else{
      
      b=f.calcFSum(n);
      System.out.println("result: "+b);
    f.calcSum(b);
    }
  }
}
    
      
        