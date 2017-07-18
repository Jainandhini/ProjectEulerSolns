import java.io.*;

class AmicableNumbers{
  
  long sumOfAmicableNumbers;
  
  public void findAmicableNumbers(int limit){
    
    for(int i=limit;i>1;i--){
      long sumOfFactors=calcSumFactors(i);
      long amicableSum=calcSumFactors(sumOfFactors);
      //System.out.println("i: "+i+" sumOfFactors: "+sumOfFactors+"  amicableSum: "+amicableSum);
      if(i==amicableSum && i!=sumOfFactors ){
        System.out.println("i: "+i+" sumOfFactors: "+sumOfFactors+"  amicableSum: "+amicableSum);
        sumOfAmicableNumbers=sumOfAmicableNumbers+i;
      }
        
  }
  }
    public long calcSumFactors(long n){
      
     long sum=0;
     //System.out.println("Number: "+n);
     for(long i=1;i<=n/2;i++){
       if(n%i==0){
         //System.out.println("Factor: "+i);
         sum+=i;}
     }
     return sum;
    }
  public long calcSumAmicableNumbers(){
    
    return sumOfAmicableNumbers;
  }
  public static void main(String args[]){
    AmicableNumbers an=new AmicableNumbers();
    an.findAmicableNumbers(10000);
    System.out.println("Sum: "+an.calcSumAmicableNumbers());
    
  }
}