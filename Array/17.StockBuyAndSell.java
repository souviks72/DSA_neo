//https://takeuforward.org/data-structure/stock-buy-and-sell/
class Solution {
    int mx = 0;
    public int maxProfit(int[] arr) {
        int minPrice = Integer.MAX_VALUE, maxPro=0;
        
        for(int i=0;i<arr.length;i++){
            minPrice = Math.min(minPrice, arr[i]);
            maxPro = Math.max(maxPro, arr[i] - minPrice);
        }

        return maxPro;
    }
}