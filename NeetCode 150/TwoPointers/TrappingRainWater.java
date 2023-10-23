public class TrappingRainWater {

    public static int trap(int[] height) {
        
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int max = height[0];
        int waterCollected = 0;

        // find maximum from left side
        for(int i=0; i<left.length; i++) {
            left[i] = Math.max(max, height[i]);
            max = left[i];
        }

        // initalizing with last element in array
        max = height[height.length-1];
        // find maximum from right side
        for(int i=right.length-1; i>=0; i--) {
            right[i] = Math.max(max, height[i]);
            max = right[i];
        }

        for(int i=0; i<height.length; i++) {
            int curr = Math.min(left[i], right[i]) - height[i];
            if(curr >= 0) {
                waterCollected += curr;
            }
        }
        return waterCollected;
    }
    /*
     * Time complexity : O(N) + O(N) + O(N) = O(N)
     *      We are running three while loops
     * Space complexiyt : O(N) + O(N) = O(N)
     *      We are using two external array
     */


    // Using two pointers
    
    
    
    public static void main(String[] args) {
        
    }
}
