import java.io.*;
import java.math.BigInteger;
import java.util.*;
class ThousandDigit{
  BigInteger theNumber;
  Long the13digit;
  TreeMap<Long,Long> products;
  int firstIndex,lastIndex;
  Long product13;
  int lastIndexOfZero=-1;
  ThousandDigit(BigInteger b){
    theNumber=b;
   // the13digit=0;
    products=new TreeMap<Long,Long>();
    firstIndex=0;lastIndex=13;
    //product13=1;
  }
  
  public static void main(String args[]){
    BigInteger b=new BigInteger("7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
    int noOfDigit = 1;
    //long n=b.longValue();
    //while((n=n/10) != 0) ++noOfDigit;
    System.out.println("Number: "+b+"\nSize of the number: "+b.toString().length());
    ThousandDigit td=new ThousandDigit(b);
   System.out.println("Largest product: "+ td.findLargestProduct());
  }
  
  Long productOf13(long n){
    long product=1;
    while((n=n/10) != 0)
    {
      product*=n%10;
      n=n/10;
    }
    return product;
  }
  boolean containsZero(long n){
    if(n == 0)
        return true;
    
    while(n> 0)
    {
      if(n%10==0)
        return true;
      n=n/10;
    }
    
    return false;
  }
//  int indexOfZero(long n){
//    int i=-1;
//    
//    return i;
//  }
  long findLargestProduct(){
    /*while lastIndex of substring < size of number
     *    get 13 digit substring
     *    if any of the digits are 0, move the firstIndex to indexOf(0)+1 and lastIndex incremented by 13
     *    calculate the product and save it to the TreeMap
     * End while
     * 
     */
    int counter=0;
    
    while(lastIndex<theNumber.toString().length()){
      System.out.println("firstIndex | lastIndex | MaxIndex: "+firstIndex+" || "+lastIndex+" || "+theNumber.toString().length());
      String subst=theNumber.toString().substring(firstIndex,lastIndex);
      the13digit=Long.parseLong(subst);
      System.out.println("13 digit: "+the13digit+" contains Zero? "+containsZero(the13digit));
      System.out.println("Counter: "+ ++counter);
      
      if(containsZero(the13digit)){
            System.out.println("Index of Zero: " + subst.lastIndexOf("0"));
//            if(subst.lastIndexOf("0")!=-1)
//            firstIndex=subst.lastIndexOf("0")+1;
//            else
//            firstIndex++;
            firstIndex=firstIndex+subst.lastIndexOf("0");
            lastIndex=firstIndex+13+1;
      }
      else{
        product13=productOf13(the13digit);
        products.put(the13digit,product13);
        System.out.println("*** product of 13: "+product13+" *** firstIndex|lastIndex : "+firstIndex+"|"+lastIndex);
        System.out.println("The treemap: "+products);
        firstIndex++;
        lastIndex++;
      
      }
    }
    System.out.println("Calculated largest product............");
    long largestProduct=1;
    for(Map.Entry<Long,Long> l:products.entrySet()){
      if(l.getValue()>largestProduct){
        
        largestProduct=l.getValue();
        System.out.println("Largest product changed to : "+largestProduct);
      }
    }    
    return largestProduct;
    }

    public int compareTo(ThousandDigit o) {
        return this.product13.compareTo(o.product13);
}
}