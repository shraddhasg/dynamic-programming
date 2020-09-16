import java.util.*;

public class MaxPalindomicSubstrings {
    public static int maxPalindomicSubstrings(String a) {
        int n = a.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += findPalindrome(a, i, i, n);
            result += findPalindrome(a, i, i + 1, n);
        }
        return result;
    }

    public static int findPalindrome(String s, int left, int right, int n) {
        int count = 0;
        while (left >= 0 && right <= n - 1) {
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            } else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "acacbb";

        System.out.println(maxPalindomicSubstrings(s));
    }

}