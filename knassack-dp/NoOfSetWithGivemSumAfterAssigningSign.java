public class NoOfSetWithGivemSumAfterAssigningSign {
    public static int noOfSetWithGivemSumAfterAssigningSign(int[] arr, int sum) {
        int arraySum = 0;
        for (int i = 0; i < arr.length; i++)
            arraySum += arr[i];

        int newSum = (arraySum - sum) / 2;

        return numberOfPartitionsWithGivenSum(arr, newSum);
    }

    public static int numberOfPartitionsWithGivenSum(int[] arr, int sum) {
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
        int sum = 1;

        System.out.println(noOfSetWithGivemSumAfterAssigningSign(arr, sum));
    }
}