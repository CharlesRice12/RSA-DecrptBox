public class RSA_Test{
  protected final int N = 18923;
  protected final int E = 1261;
  protected int n,e,p,q,d,a,b,c;
  
  public RSA_Test(){
   this.n = N;
   this.e = E;
   this.p=p;
   this.q=q;
   this.d=d;
   this.a=a;
   this.b=b;
   this.c =c;
  }
  
  
  public int getN(){
    return n;
  }
    public int getE(){
    return e;
  }
      public int getP(){
    return p;
  }
        public int getQ(){
    return q;
  }
     public int getD(){
    return d;
  }
       public int getA(){
    return a;
  }  
       public int getB(){
    return b;
  }   
       public int getC(){
    return c;
  }
     
     
     
 
  
 public static boolean isPrime(int k){
    if(k == 1){
      return false;
    }if(k==2){
      return true;
    }if(k%2 ==0){
      return false;
    
    }for(int i=2; i < Math.sqrt(k) +1; i++){
      if(k%i ==0)
      return false;
     
    
    }
      return true;
    
  }
  
  public void factorN(/*int n, int p, int q*/){
    p=1;
    q=1;
    int phi_n = phi(n);
    int k = (n-phi_n)-1;
    for(int i=2; i < k; i++){
      if(isPrime(i)==true && n%i == 0){
        p=i;
        q=n/p;
        break;
      }
    }
    //return p;
  }
      
      
      public int phi (int m)
      {
        int result = 1;
        for (int i=2; i < m; i++)
          if (isCoprime(m,i))
          result++;
        return result;
      }
     //helper method for extended euclidean alg 
      public int eucAlg(int a, int b){
        int q,r,temp;
        if(a<b){
          temp =a;
          a=b;
          b=temp;
        }
        q = a/b;
        r = a%b;
        while(r!=0){
          //a=qb+r
          //b=qr+r;
          a=b;
          b=r;
          q = a/b;
          r = a%b;
        }
        return b;
      }
       
      
     public int modEx(int ct, int ex, int m) {
       int r;
    if (ct < 1 || ex < 0 || m < 1)
        return -1;

    r = 1;
    while (ex > 0) {
       if ((ex % 2) == 1) {
           r = (r * ct) % m;
       }
       ct = (ct * ct) % m;
       ex = (ex / 2);
    }
    return r;
} 

       
      
      public boolean isCoprime(int a, int b){
        int x = eucAlg(a,b);
        if(x == 1)
          return true;
        else
          return false;
      }
      
       public int findD(int e, int n){
    int d=1;
    int k = phi(n);
    for(int i=1; i <e; i++){
      if(((k*i)+1) % e == 0){
        d = ((k*i)+1)/e;
       break;
      }
    }
    return d;
    }
        
        
        public void parse(int m){
          c = (int)Math.floor(m%26);
          b = (int)Math.floor(((m-c)/26)%26);
          a = (int)Math.floor((((m-c)/26)-b)/26);
        }
}
        
