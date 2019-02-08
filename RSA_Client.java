import java.io.*;
import java.util.*;

public class RSA_Client{
  
  
  public static void main(String args[]){
    int a=0,b=0,c=0;
    RSA_Test k = new RSA_Test();
    char [] arr  = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    
    
    k.factorN();
    int ct;
    int n = k.getN();
    int p = k.getP();
    int q = k.getQ();
    int d = k.findD(k.getE(), k.getN());
   try{
    PrintStream out = new PrintStream(new File("output.txt"));
    Scanner input = new Scanner(new File("cipher.txt"));
    while(input.hasNextInt()){
      ct = input.nextInt();
      parse(k,ct,d,n,arr,out);
      }
    }catch(IOException ex){
      System.out.println("There was an error");
      ex.printStackTrace();
    }
    System.out.println(d);
    k.parse(5438);
    System.out.println(k.getA()+" "+k.getB()+" "+k.getC());
    int j = k.modEx(12423,5797,18923);
    System.out.println(arr[25]);
    
  }
    
    public static void parse(RSA_Test n, int m, int d, int p,char [] k, PrintStream out){
      int pt = n.modEx(m,d,p);
      n.parse(pt);
      parse_2(k,n.getA(), n.getB(), n.getC(), out);
      
    }
    
    public static void parse_2(char [] k, int a, int b, int c, PrintStream out) {
      String m;
      char x = k[a], y = k[b], z = k[c];
      m = (x+""+y+""+z);
      out.print(m+" ");
    }
   
  }

      
      
      
      
      
      
      
      
