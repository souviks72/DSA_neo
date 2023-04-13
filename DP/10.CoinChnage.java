//https://leetcode.com/problems/coin-change
//https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int t[][] = new int[n+1][amount+1];
        for(int i=0;i<n+1;i++){
            t[i][0] = 0;
        }
        for(int j=0;j<amount+1;j++){
            t[0][j] = Integer.MAX_VALUE - 1;
        }
        for(int j=1;j<amount+1;j++){
            if(j%coins[0]==0)
                t[1][j] = j/coins[0];
            else
                t[1][j] = Integer.MAX_VALUE - 1;
        }

        for(int i=2;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j)
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]], t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }

        if (t[n][amount] == Integer.MAX_VALUE-1) return -1;
        return t[n][amount];
    }
}