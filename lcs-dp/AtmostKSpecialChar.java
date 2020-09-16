import java.util.Arrays;
import java.util.HashSet;

public class AtmostKSpecialChar {

    public static int atmostKSpecialChar(String s, String magic, int k) {
        int index = 0;
        HashSet<Character> hSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            index = (int) s.charAt(i) - 97;

            if (magic.charAt(index) == '0')
                hSet.add(s.charAt(i));
        }
        System.out.println(hSet);

        int n = s.length();
        int m = s.length();

        int[][] t = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                count = 0;
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if (hSet.contains(s.charAt(i - 1))) {
                        count++;
                        System.out.println(s.charAt(i - 1) + "=" + s.charAt(j - 1) + "-->" + count);
                        if (count < k)
                            t[i][j] = 1 + t[i - 1][j - 1];
                        else
                            t[i][j] = t[i - 1][j - 1];
                    }

                    if (hSet.contains(s.charAt(i - 1)) == false) {
                        if (count < k)
                            t[i][j] = 1 + t[i - 1][j - 1];
                    }

                } else {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }

        return t[n][m];
    }

    public static void main(String[] args) {
        String s = "abcdccaaaab";
        String magic = "10101111110011111010111011";
        int k = 2;

        System.out.println(atmostKSpecialChar(s, magic, k));
    }
}