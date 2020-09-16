public class GivenSubsetSumDiff {
    public static int givenSubsetSumDiff(int[] arr, int diff) {
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++)
            sum += arr[i];

        int newSum = (sum + diff) / 2;
        // System.out.println(newSum);

        return partitionWithGivenSum(arr, newSum);
    }

    public static int partitionWithGivenSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 3 };
        int diff = 1;

        System.out.println(givenSubsetSumDiff(arr, diff));
    }
}