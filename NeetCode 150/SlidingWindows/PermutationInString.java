import java.util.Arrays;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int[] freq = new int[26];
        int m = s2.length();
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int[] freq2 = new int[26];
        for (int i = 0; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= n) { 
                freq2[s2.charAt(i - n) - 'a']--;
            }
            if (Arrays.equals(freq, freq2))
                return true;
        }
        return false;
    }
    /*
     * Time complexity = O(N)
     *      We are running for loop from 0 to N.
     */

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "xyzabcmno";

        System.out.println(checkInclusion(s1, s2));
    }
}