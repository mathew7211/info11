package problems;

public class problem942 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int q = 74207281;
        int mod = 1000000007;
        boolean[] qr = new boolean[q]; 
        for (boolean b : qr) {
            b=false;
        }
        int half = (q-1)/2;

        int sq = 1;
        int d = 3;

        for (int i = 1; i <= half; i++) {
            qr[sq]=true;
            sq+=d;
            if(sq>q) sq-=q;
            d+=2;
        }

        int G = 0;
        int pow2 = 2;
        for (int i = 1; i < q; i++) {
            if (qr[i]) {
                G+=pow2;
                if(G>=mod) G-=mod;
            }else{
                G-=pow2;
                if(G<0) G+=mod;
            }

            pow2<<=1;
            if(pow2>=mod) pow2-=mod;

        }

        if(q%8==1){
            System.out.println((powm(2,q,mod)-1-G));
        }else{
            System.out.println(G);
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start+"  ms");


    }
    

    public static long powm(long base, int exp, int mod) {
        long result = 1;
    
        while (exp>0) {
            if ((exp & 1)==1) result = (result*base)%mod;
            base = (base*base)%mod;
            exp>>=1;
        }
        return result;
    }
}