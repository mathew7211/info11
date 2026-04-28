package tools;
import java.util.Arrays;



public class Primzahlen {
   
    public static boolean[] isprime (int n) {

        boolean isprime[] = new boolean[n+1];
        Arrays.fill(isprime,true);
        for (int i = 2; i*i < n; i++) {
            if (isprime[i]) {
               for (int j = 2; j*i < n+1; j++) {
                isprime[j*i]=false;
            }  
            }
        }
   
        return isprime;
    }

    public static long primesbelowlong(long n) {
        int root = (int) Math.sqrt(n);
        int blocksize = 32768; 
        long count = 0;

        
        boolean[] smallp = isprime(root);
        for (int i = 2; i <= root; i++) {
            if (smallp[i]) count++;
        }

      
        boolean[] block = new boolean[blocksize];
        for (long start = root + 1; start <= n; start += blocksize) {
            Arrays.fill(block, true);
            long end = Math.min(start + blocksize - 1, n);

            for (int p = 2; (long) p * p <= end; p++) {
                if (smallp[p]) {
                    long firstMultiple = (start + p - 1) / p*p;
                    if (firstMultiple < (long) p * p) firstMultiple = (long) p*p;

                    for (long j = firstMultiple; j <= end; j += p) {
                        block[(int) (j - start)] = false;
                    }
                }
            }

            for (int i = 0; i < (end - start + 1); i++) {
                if (block[i]) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(primesbelowlong(100000000));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
   
}
