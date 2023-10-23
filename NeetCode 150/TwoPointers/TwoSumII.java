public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length-1;
        int a_num, b_num;

        while(a_pointer < b_pointer) {
            a_num = numbers[a_pointer];
            b_num = numbers[b_pointer];

            // if equals to target break the loop
            if(a_num + b_num == target) break;

            // since the array is in increasing order 
            // a_num is the smallest and b_num is largest
            // Note if you add a value with the largest  
            // and your value is still smaller than target then, increase the value of smallest
            if(a_num + b_num < target) {
                a_pointer++;
                continue;
            }
            // if taget is smaller than sum
            b_pointer--; 
        }
        return new int[] {a_pointer+1, b_pointer+1};
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int ans[] = twoSum(numbers, target);
        
        for(int e : ans) {
            System.out.print(e + ", ");
        }
    }
}
