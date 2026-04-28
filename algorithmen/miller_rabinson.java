import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;




public class miller_rabinson {

    public static long powm(long b,long e,long m){
        long result = 1;
        b%=m;
        while (e!=0) {
            if((e&1)==1) result= (result*b)%m;
            b= (b*b)%m;
            e>>=1;
        }

        return result;
    }

    public static boolean composit(long p,long a, long d, int s){
        if (sivesmall(p, 100)) return true;
        long t = powm(a, d, p);
        if(t==1||t==p-1) return false;
        for (int i = 1; i < s; i++) {
            t= (t*t)%p;
            if(t==p-1) return false;
        }
        return true;
    }

    public static boolean sivesmall(long p, int limit){
        boolean isprime[] = new boolean[limit+1];
        Arrays.fill(isprime,true);
        for (int i = 2; i*i <= limit; i++) {
            if (isprime[i]) {
                if(p%i==0) return true;
               for (int j = 2; j*i <= limit; j++) {
                isprime[j*i]=false;
            }  
            }
        }
        return false;
    }

    public static boolean MillerRabinson(long p,int sertenty){
        int s = 0;
        long d = p-1;
        while ((p&1)==0) {
            d>>=1;
            ++s;
        }
        for (int i = 0; i < sertenty; i++) {
            long a = 2+ ThreadLocalRandom.current().nextLong(p-3);
            if (composit(p, a, d, s)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int s = 10;
        long p = (long)1e9+7;
        System.err.println("die zahl: "+p+((MillerRabinson(p, s)?" prime mit fehlerwahrscheinlichkeit: "+Math.pow(2,-2*s):"nicht prim")));
    }


}