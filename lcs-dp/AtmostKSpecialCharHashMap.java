import java.util.HashSet;

public class AtmostKSpecialCharHashMap {
    public static int atmostKSpecialCharHashMap(String s, String magic, int k) {
        HashSet<Character> hSet = new HashSet<>();
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            index = (int) s.charAt(i) - 97;
            if (magic.charAt(index) == '0')
                hSet.add(s.charAt(i));
        }

        int count = 0;
        int maxLen = Integer.MIN_VALUE, len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (hSet.contains(s.charAt(i))) {
                count++;
                if (count < k)
                    len++;
                else {
                    maxLen = Math.max(maxLen, len);
                    len = 0;
                    count = 0;
                }
            } else {
                len++;
            }
        }
        return Math.max(maxLen, len);
    }

    public static void main(String[] args) {
        String s = "abcdccaaaab";
        String magic = "10101111110011111010111011";
        int k = 3;

        System.out.println(atmostKSpecialCharHashMap(s, magic, k));
    }
}