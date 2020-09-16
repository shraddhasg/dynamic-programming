public class KnapsackProblemWithRecursion {
    public static int knapsackProblemWithRecursion(int[] weight, int[] value, int w, int n) {
        if (n == 0 || w == 0)
            return 0;

        if (weight[n - 1] < w)
            return Math.max(value[n - 1] + knapsackProblemWithRecursion(weight, value, w - weight[n - 1], n - 1),
                    knapsackProblemWithRecursion(weight, value, w, n - 1));

        return knapsackProblemWithRecursion(weight, value, w, n - 1);
    }

    public static void main(String[] args) {
        int[] weight = { 3, 5, 2, 5, 1, 6 };
        int[] value = { 2, 4, 1, 5, 4, 1 };
        int w = 10;
        int n = weight.length;

        System.out.println(knapsackProblemWithRecursion(weight, value, w, n));
    }
}