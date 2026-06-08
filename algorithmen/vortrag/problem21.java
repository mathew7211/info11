import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class problem21 {

    static ArrayList<Integer>[] pfactors = pfactors(100000);
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 2; i <= 10000; i++) {
            if (i==sum(sum(i))&&i!=sum(i)) {
                sum+=i;
                System.out.println(i);
            }
        }
        System.out.println(sum);

    }

    public static ArrayList<Integer>[] pfactors(int limit){
        int[] lpf = new int[limit+1];
        Arrays.fill(lpf,0);
        ArrayList<Integer> pr = new ArrayList<Integer>();
        ArrayList<Integer>[] pfactors = new ArrayList[limit + 1];
        for (int i = 0; i <= limit; i++) {
            pfactors[i] = new ArrayList<>();
        }

        for (int i = 2; i <= limit; i++) {
            if (lpf[i]==0) {
                lpf[i]=i;
                pr.add(i);
                pfactors[i].add(i);
            }
            for (int j = 0; i*pr.get(j) <= limit; j++) {
                lpf[i*pr.get(j)] = pr.get(j);
                pfactors[i*pr.get(j)]= new ArrayList<>(pfactors[i]);
                 pfactors[i*pr.get(j)].add(pr.get(j));
                if(pr.get(j)==lpf[i]) break;
            }
            
        }
        return pfactors;

    }

    public static int sum(int n){

        ArrayList<Integer> nfactors = pfactors[n];

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < (1<<nfactors.size())-1; i++) {
                int factor = 1;
                for (int j = 0; j <nfactors.size(); j++) {
                    if ((i&(1<<j))!=0) {
                        factor*= nfactors.get(j);
                    }
                }
                s.add(factor);
            }
        int sum =0;
        for (int f : s) {
            sum+= f;
        }
        return sum;
    }
  


}