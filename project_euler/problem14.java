package problems;

public class problem14 {
    public static int cllatz(int n){
      return (n % 2 == 0) ? n / 2 : 3 * n + 1;
    }

    public static void main(String[] args) {
        int maxl=0;
        int maxn=0;
        for (int i = 1; i < 100; i++) {
            int n = i;
            int l = 0;
            while (n!=1) {
                n = cllatz(n);
                ++l;
        }
        if (l>maxl) {
            maxl = l;
            maxn = i;
        }

    }
    System.out.println(maxl + "  bei  "+maxn);
}
}