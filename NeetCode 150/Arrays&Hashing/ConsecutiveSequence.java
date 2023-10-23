import java.util.HashSet;

public class ConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0 ) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int maxCon = 1;

        for(int num : nums) set.add(num);

        for(int e : set) {
            //find the starting point
            if(!set.contains(e-1)) {
                int count = 1;
                // if the starting point has next consecutive element
                while(set.contains(e+1)) {
                    e++;
                    count++;
                }
                maxCon = Math.max(maxCon, count);
            }
            // check if the maxConsecutive is greater the half size of array
            // because greater than half means obviously there will be no other longer than it
            if(maxCon > nums.length/2) break;
        }   
        return maxCon;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};


        System.out.println(longestConsecutive(nums));
    }
}