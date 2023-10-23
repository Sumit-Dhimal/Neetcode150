import java.util.ArrayList;
import java.util.HashMap;

public class KFrequentElement {
    //using bucket sort
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // array of arraylist
        @SuppressWarnings ("unchecked")
        ArrayList<Integer> bucket[] = new ArrayList[nums.length+1];

        for(int num : nums) {
            //this is concurrent hashmap
            //map.merge(num, 1, Integer::sum);
            map.merge(num, 1, (prev, one) -> prev + one); // its lamda expressions
        }

        // fill values according to the values of hashMap
        // suppose if '1' has a frequency of 3 then, place it int 3rd index
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();   
            }
            bucket[freq].add(key);
        }

        int idx = 0;
        int[] res = new int[k];
        for(int i=nums.length; i>=0; i--) {
            if(bucket[i] != null) {
                for(int val : bucket[i]) {
                    res[idx++] = val;
                    if(idx == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        
        int[] ans = topKFrequent(nums, k);

        for(int num : ans) {
            System.out.print(num + " ");
        }
    }
}
