//https://takeuforward.org/data-structure/longest-increasing-subsequence-dp-41/
//https://leetcode.com/problems/longest-increasing-subsequence
class Solution {
    public int max = 1;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return lis(nums, dp, 0,-1);
    }

    public int lis(int[] nums, int[][] dp, int i, int prev){
        if(i==nums.length){
            return 0;
        }

        if(dp[i][prev+1]!=-1) return dp[i][prev+1];

        int notTake = 0 + lis(nums,dp, i+1, prev);

        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take = 1 + lis(nums,dp,i+1,i);
        }
        
        return dp[i][prev+1] = Math.max(take, notTake);
    }
}