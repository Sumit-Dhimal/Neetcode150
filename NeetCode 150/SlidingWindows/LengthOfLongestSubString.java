import java.util.HashSet;

public class LengthOfLongestSubString {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for(int right = 0; right<s.length(); right++) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                // our index is starting from 0
                maxLength = Math.max(maxLength, right - left+1);
            } else {
                //find duplicate char index by shifting the left side of the window
                while(set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
                //After sucessfully removing the element add it again
                set.add(s.charAt(right));
            }
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        String  s = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
