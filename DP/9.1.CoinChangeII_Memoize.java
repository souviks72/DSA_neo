class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int t[][] = new int[n+1][amount+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<amount+1;j++)
                t[i][j] = -1;
        }
        return fn(amount, n, coins, t);
    }

    public int fn(int amount, int n, int[] coins, int[][] t){
        if(amount==0) return 1;
        if(n==0) return 0;
        
        if(t[n][amount]!=-1) return t[n][amount];

        if(coins[n-1] <= amount){                     //"n" because we can repeat coin
            return t[n][amount] = fn(amount-coins[n-1],n, coins, t) + fn(amount,n-1,coins, t);
        }else{
            return t[n][amount] = fn(amount,n-1,coins, t);
        }
    }
}