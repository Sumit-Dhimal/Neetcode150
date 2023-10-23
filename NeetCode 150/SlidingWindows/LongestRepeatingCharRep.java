// longest repeating character replacement

import java.util.HashMap;

public class LongestRepeatingCharRep {
    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0; // left side of a window
        int maxLength = 0; // result

        for(int right=0; right<s.length(); right++) {
            // if map already contains increment value else put it
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0)+1);
            } else {
                map.put(s.charAt(right), 1);
            }
            
            int winLen = right-left+1; // window length
            int mostFreq = 0; //most frequent in hashmap

            //finding most frequent value in Hashmap
            for(Integer val : map.values()) {
                mostFreq = Math.max(mostFreq, val);
            }

            if(winLen - mostFreq <= k) { // most important condition
                maxLength = winLen;
            } else { // if exceeds condition increment left side of window
                     // & decrease the character value in Hashmap
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0)-1);
                left++; 
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }
}
