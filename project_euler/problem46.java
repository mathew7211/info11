package problems;
import tools.Primzahlen;

public class problem46 {
    public static void main(String[] args) {
        boolean[] isprime=Primzahlen.isprime(1000000);

        for (int i = 5; i < 1000000; i+=2) {
            if (isprime[i]) continue;
                for (int j = 0; j< i; j++) {
                if (2*j*j >i) {
                    System.out.println(i);
                    return;
                }
                
                if (isprime[i-2*j*j]) {
                    break;
                }
            }
            
        }
    }
}
