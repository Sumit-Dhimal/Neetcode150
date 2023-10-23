import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            // find the difference
            int diff = target - num;
            
            // if the map contains diff it means it contains exact value to be added
            if(map.containsKey(diff)) {
                return new int[] {map.get(diff), i}; 
            }

            map.put(num, i);
        }
        // if there is no such value return empty array.
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int target = 7;    

        int ans[] = twoSum(nums, target);

        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
