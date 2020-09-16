class Triplet {
    public static int findTriplet(int[] arr1, int[] arr2) {
        String s1 = "", s2 = "";

        for (int i = 0; i < arr1.length; i++)
            s1 += arr1[i];

        for (int i = 0; i < arr2.length; i++)
            s2 += arr2[i];

        int m = s1.length(), n = s2.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);

            }
        }

        return t[m][n] - 3 + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 0, 4, 6 };
        int[] arr2 = { 1, 2, 3, 4, 6 };

        System.out.println(findTriplet(arr1, arr2));
    }
}