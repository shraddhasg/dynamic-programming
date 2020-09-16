import java.util.Arrays;

public class RodCuttingProblem {

    public static int rodCuttingProblem(int[] price, int lengthOfRod) {
        int[] weight = new int[price.length];
        for (int i = 0; i < weight.length; i++)
            weight[i] = i + 1;

        int n = price.length;
        int[][] t = new int[n + 1][lengthOfRod + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < lengthOfRod + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < lengthOfRod + 1; j++) {
                if (weight[i - 1] <= j)
                    t[i][j] = Math.max(price[i - 1] + t[i][j - weight[i - 1]], t[i - 1][j]);
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[n][lengthOfRod];

    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 8, 9, 10, 11, 4, 2 };
        int lengthOfRod = 8;

        System.out.println(rodCuttingProblem(price, lengthOfRod));

    }
}