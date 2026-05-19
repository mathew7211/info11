import java.util.Arrays;

public class primes {
   
  public static void main(String[] args) {
    Integer n = 500000;

    boolean isprime[] = new boolean[n+1];
    Arrays.fill(isprime,true);
    
    for (int i = 2; i*i <= n; i++) {
      if (isprime[i]) {
        for (int j = i*i; j <= n; j+=i) {
          isprime[j]=false;
        }  
      }
    }


    int count =0;
    for (int i = 2; i <= n; i++) {
      if (isprime[i]) {
        ++count;
        if(count==10001) System.out.println(i);
      }
    }

    }

}