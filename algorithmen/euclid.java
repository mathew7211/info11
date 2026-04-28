package tools;

public class euclid {
    public static int ggt1(int a,int b){
        int t;
        while (b!=0) {
            t=b;
            b=a%b;
            a=t;
        }
        return a;
    }

    public static int ggt2(int a,int b){
        if (b==0) {
            return a;
        }
        return ggt2(b,a%b);

    }

    /*Steiners binäre ggt algorithmus */

    public static long steiner_ggt(long a,long b){
        if(a==0||b==0) return a|b;
        int shift = Long.numberOfTrailingZeros(a|b);
        a>>=shift;
        while (b!=0) {
            b>>=Long.numberOfTrailingZeros(b);
            if (a>b) {
                a^=b;
                b^=b;
                a^=b;
            }
            b-=a;
        }
        return a<<shift;
    }

    public static long powm(long b,long e,long m){
        b%=m;
        long r=1;
        while (e>0) {
            if((e&1)==0) r= (r*b)%m;
            b=(b*b)%m;
            e>>=1;
        }
        return r;
    }

    public static long extend_euclid(long a,long b){
        long old_r = a;
        long r = b;
        long old_x = 1;
        long x = 0;
        long q;
        while (r!=0) {
            q= old_r/r;
            old_r^=r;
            r^=old_r;
            old_r^=r;
            r-=q*old_r;

            old_x^=x;
            x^=old_x;
            old_x^=x;
            x-= q*old_x;
        }
        long y = (old_r-old_x*a)/b;
        System.out.println(" ggt ist "+old_r+"  bezutx ist "+ old_x+" bezuty ist "+y);
        return old_r;
    }

    public static void main(String[] args) {
    }
}