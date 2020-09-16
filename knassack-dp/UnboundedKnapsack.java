public class UnboundedKnapsack {
    public static int unboundedKnapsack(int[] weight, int[] val, int n, int w) {
        int[][] t = new int[n + 1][w + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i - 1] <= j)
                    t[i][j] = Math.max(val[i - 1] + t[i][j - weight[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[n][w];

    }

    public static void main(String[] args) {
        int[] weight = { 2, 4, 5, 1, 6, 7, 9 };
        int[] val = { 5, 4, 12, 6, 2, 8, 9 };
        int w = 10;

        System.out.println(unboundedKnapsack(weight, val, weight.length, w));
    }
}