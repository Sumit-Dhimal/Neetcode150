/**
 * BuyAndSellStock
 */
public class BuyAndSellStock {
    // use two pointers
    public static int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;

        while(right < prices.length) {
            //condition 1
            if(prices[left] < prices[right]) {
                max = Math.max(max, prices[right]-prices[left]);
                right++;
            } else { // when left == right || left > right
                left = right;
                right++;
            }
        }
        return max;
    }
    // Note : We cannot buy today and sell yesterday

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }
}