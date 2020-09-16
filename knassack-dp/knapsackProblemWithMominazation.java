public class knapsackProblemWithMominazation {
    public static int knapsackProblemWithMominazation(int[] weight, int[] value, int w, int n) {
        int[][] t = new int[n + 1][w + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (weight[i - 1] <= w)
                    t[i][j] = Math.max(value[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j]);
                t[i][j] = t[i - 1][j];
            }
        }
        return t[n][w];

    }

    public static void main(String[] args) {
        int[] weight = { 1, 4, 2, 4, 5, 6 };
        int[] value = { 5, 3, 2, 1, 8, 6 };
        int n = weight.length;
        int w = 4;

        System.out.println(knapsackProblemWithMominazation(weight, value, w, n));
    }
}