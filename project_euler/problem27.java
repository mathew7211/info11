package problems;
import tools.Primzahlen;
public class problem27 {
    public static void main(String[] args) {
        int a;
        int b;
        int finala=0;
        int finalb = 0;
        int maxcount =0;
        boolean[] isprime = Primzahlen.isprime(100000);
        for (int i = -1000; i < 1000; i++) {
            for (int j = 1000; j*j > 1000; j--) {
                if (isprime[j]) {
                    a = i;
                    b= j;
                    int count = 0;
                    for (int n = 0; n < b; n++) {
                        if (n*n+a*n+b<=0||!isprime[n*n+a*n+b]) {
                            break;
                        }
                        ++count;
                    }
                    if (count>maxcount) {
                        maxcount=count;
                        finala=a;
                        finalb=b;
                    }

                }
            }
        }
        System.out.println(finala+"   "+finalb+"   "+finala*finalb+" mit  "+maxcount+" zahlen");

    }
}
