/**
 * FindOccurance
 */
public class FindOccurance {
    //for first occurances
    public static int findFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        int first = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                first = mid;
                // for first occurance check left side only since it's a sorted array
                high = mid-1;
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return first;
    }

    // for last occurances
    public static int findLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        int last = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                last = mid;
                // for last occurance check right side only since it's a sorted array
                low = mid+1; 
            } else if(nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }   
        return last;
    }

    public static int[] searchRange(int[] nums, int target) {
     
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] {first, last};
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] ans = searchRange(nums, target);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}