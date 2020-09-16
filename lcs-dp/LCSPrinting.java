public class LCSPrinting {

    public static String lcsPrinting(String a, String b, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        t = longestCommonSubsequence(a, b, m, n, t);

        int i = m, j = n;
        String s = "";
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                s += a.charAt(i - 1);
                i--;
                j--;
            } else {
                if (t[i][j - 1] > t[i - 1][j])
                    j--;
                else
                    i--;
            }
        }
        System.out.println(s);
        StringBuffer sb = new StringBuffer(s);
        // String result = "";
        // for (i = a.length() - 1; i >= 0; i--)
        // result += s.charAt(i);

        return sb.reverse().toString();

    }

    public static int[][] longestCommonSubsequence(String a, String b, int m, int n, int[][] t) {
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    t[i][j] = 1 + t[i - 1][j - 1];
                else
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
            }
        }
        return t;
    }

    public static void main(String[] args) {
        String a = "abcdgh";
        String b = "abedfhr";

        System.out.println(lcsPrinting(a, b, a.length(), b.length()));
    }
}