// for every array in matrix use binary search to find
/**
 * Time complexity : O(log(m*n)) in best case
 *                  O(N * LogN) in worst case
 * 
 * Space complexity : O(1) since we are not using external space
 */

public class SearchIn2D {
    // binary search funtion
    public static boolean isThere(int[] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int[] arr : matrix) {
            if(isThere(arr, target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                           {4, 5, 6},
                            {7, 8, 9}};
        int target = 5;

        
        System.out.println(searchMatrix(matrix, target));
    }
}
