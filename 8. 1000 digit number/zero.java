class zero{
  public static void main(String s[]){
    long subst=11;
    zero z=new zero();
    
    System.out.println(z.containsZero(subst));
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
}