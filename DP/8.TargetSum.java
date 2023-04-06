//https://leetcode.com/problems/target-sum
//https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if (sum < Math.abs(target)) return 0;
        if ((sum+target)%2 != 0) return 0;

        int x = (target+sum)/2;

        int t[][] = new int[n+1][x+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<x+1;j++){
                if(i==0) t[i][j] = 0;
                if(j==0) t[i][j] = 1;
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=0;j<x+1;j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j - nums[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][x];
    }
}