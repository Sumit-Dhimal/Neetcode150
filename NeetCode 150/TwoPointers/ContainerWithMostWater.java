public class ContainerWithMostWater {
    // brute force method
    // public static int findArea(int[]height, int l, int r) {
    //     int area = 0;

    //     while(l < r) {
    //         int length = Math.min(height[l], height[r]);
    //         int  breadth = r-l;
    //         int curr = length*breadth;
    //         area = Math.max(curr, area);
    //         r--;
    //     }
    //     return area;
    // }

    // public static int maxArea(int[] height) {
    //     int finalArea = 0;
    //     int r = height.length-1;
    //     for(int l=0; l<height.length; l++) {
    //         int curr = findArea(height, l, r);
    //         finalArea = Math.max(finalArea, curr);
    //     }
    //     return finalArea;
    //}
    

    // optimal Approach
    public static int maxArea(int[] height) {
        //initialize left and right pointer
        int left = 0;
        int right = height.length-1;
        int res = 0;

        while(left < right) {

            int length = right-left; // distance from left to right i.e. length

            // breadth is minimum of left and right
            // b'cuz we need both sides equal to hold water 
            int area = length * Math.min(height[right], height[left]); 
            res = Math.max(res, area);
            
            // if there is higher breadth than it may store more water
            // so check if the current pointer is not holding less water
            if(height[left] < height[right]) {
                left++;
            } else { // height[right] < height[left]
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));
    }
}
