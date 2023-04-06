//https://leetcode.com/problems/coin-change-ii/
//https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=15
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int t[][] = new int[n+1][amount+1];
        for(int i=0;i<amount+1;i++){
            t[0][i] = 0;
        }
        for(int i=0;i<n+1;i++){
            t[i][0] = 1;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1] <= j){
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[n][amount];
    }
}