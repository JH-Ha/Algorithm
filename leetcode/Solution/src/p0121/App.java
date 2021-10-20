package p0121;
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxPrices = new int[n];
        maxPrices[n - 1] = prices[n - 1];
        for(int i = n - 2; i>=0; i --){
            maxPrices[i] = Math.max(maxPrices[i + 1], prices[i]);
        }
        int answer = 0;
        for(int i = 0; i < n - 1 ; i ++){
            answer = Math.max(maxPrices[i + 1]- prices[i], answer);
        }
        return answer;
    }
}
public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }   
}
