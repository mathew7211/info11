package tools;
import java.util.concurrent.ThreadLocalRandom;

public class stringprogramm {
    static int m = (int) 1e9 + 7;
    static int b = 31;
    static int lim = 10000001;
    static long[] pow = pow();

    public static long[] pow() {
        long b_pow = 1;
        long[] pow = new long[lim];
        for (int i = 0; i < lim; i++) {
            pow[i] = b_pow;
            b_pow = (b_pow * b) % m; 
        }
        return pow;
    }

    public static long[] hash(String s) {
        int n = s.length();
        long hash = 0;
        long[] prefixhash = new long[n];

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a' + 1;
            hash = (hash * b + c) % m; 
            prefixhash[i] = hash;
        }
        return prefixhash;
    }

    public static long substring(int a, int b, long[] hash, long[] pow) {
        if (a == 0) return hash[b];
        return (hash[b] + m - (hash[a - 1] * pow[b - a + 1]) % m ) % m; 
    }

    public static boolean beinhaltet(String a, String b){
        long[] prefix = hash(a);
        int l = b.length();
        long h = hash(b)[l-1];
        
        for (int i = 0; i <= a.length()-l; i++) {
            if (substring(i, i+l-1, prefix,pow)==h) {
                return true;
            }
        }
        return false;

    }


    public static String generate(int length) {
        StringBuilder sb = new StringBuilder(length);
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + rnd.nextInt(26)));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        //vereinfachter Rabin-Karp Algorithmus mit string hashing
        System.out.println(beinhaltet(generate(10000000), "hallo"));
       

 
        
        
    }
}
