public class knapsack {

    public static int knapsack01(int[] w, int[] v, int n, int W) {

        int[] f = new int[W+1];

        for (int i = 0; i < n; i++) {
            for (int j = W; j>= w[i]; j--) {
                f[j] = Math.max(f[j],f[j -w[i]] + v[i]);
            }
        }
        return f[W];
    }

    public static void main(String[] args) {

        int[] weights = {
            3, 7, 2, 9, 4, 6, 8, 5, 11, 13,
            1, 10, 12, 14, 15, 20, 18, 16, 17, 19,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30
        };

        int[] values = {
            4, 10, 3, 12, 5, 7, 9, 6, 15, 18,
            1, 14, 16, 19, 21, 28, 25, 23, 24, 27,
            30, 32, 34, 36, 38, 40, 42, 44, 46, 50
        };

        int W = 60;


        int n = weights.length;

        int result = knapsack01(weights, values, n, W);

        System.out.println(result);
    }
}
