import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * suppose we have x, y and z
 * intialize x with the items in nums
 * and perform 2sumII operation with given exception
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
      
         for(int i=0; i<nums.length; i++) {
             //check for duplicate
             if(i==0 || (i>0 && nums[i] != nums[i-1])) {
                 int target = 0 - nums[i];
                 int left_pointer = i+1;
                 int right_pointer = nums.length-1;
 
                 while(left_pointer < right_pointer) {
                     if(nums[left_pointer] + nums[right_pointer] == target) {
                         ArrayList<Integer> list = new ArrayList<>();
                         list.add(nums[i]);
                         list.add(nums[left_pointer]);
                         list.add(nums[right_pointer]);
                         ans.add(list);
 
                         //skip duplicate
                         while(left_pointer < right_pointer && nums[left_pointer] == nums[left_pointer+1]) {
                             left_pointer++;
                         }
                         //skip duplicate
                         while(left_pointer < right_pointer && nums[right_pointer] == nums[right_pointer-1]) {
                             right_pointer--;
                         }
                         left_pointer++;
                         right_pointer--;
                     }
                     else if(nums[left_pointer] + nums[right_pointer] > target) {
                         right_pointer--;
                     } else { // target < sum 
                         left_pointer++;
                     }
                 }
             }
         }
         return ans;  
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> list2 : list) {
            for(Integer e : list2) {
                System.out.print(e + " ");
            }
            System.out.println();
        }

    }
}