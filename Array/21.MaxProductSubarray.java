//https://leetcode.com/problems/maximum-product-subarray
//https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/
//traverse both ways to avoid the single/odd negative int
class Solution {
    public int maxProduct(int[] nums) {
        int p = 1;
        int n = nums.length, max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            p = p*nums[i];
            max = Math.max(p,max);
            if(p==0) p=1;
        }
        p=1;
        for(int i=n-1;i>=0;i--){
            p = p*nums[i];
            max = Math.max(p,max);
            if(p==0) p=1;
        }

        return max;
    }
}