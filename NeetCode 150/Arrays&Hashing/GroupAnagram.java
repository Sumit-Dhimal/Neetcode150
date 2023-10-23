import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
     public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();
        // iterate for every element in strs
        for(String i : strs) {
            //change value turn wise into char array
            char[] chars = i.toCharArray();
            // sort the char array
            Arrays.sort(chars);
            // change the sorted array into string
            String sortedStrs = String.valueOf(chars);

            // check if the map contains the sorted string
            // if it doesn't then
            if(!map.containsKey(sortedStrs)) {
                map.put(sortedStrs, new ArrayList<>());
            }

            // if it contains add the original unchanged string from strs[i]
            map.get(sortedStrs).add(i);
        }
        // return only the values of map
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs =  {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> ans = groupAnagrams(strs);

        for (List<String> list : ans) {
            System.out.println(list);
        }
    }
}
