//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=fJbIuhs24zQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4
class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int[][] t = new int[1000][1000];
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++)
                t[i][j] = -1;
        }
        
        return fn(W, wt, val, n);
    } 
    
    static int fn(int W, int wt[], int val[], int n){
        if(n==0 || W==0) return 0;
        if(t[n][W]!=-1) return t[n][W];
        
        if(wt[n-1]<=W){
            return t[n][W] = Math.max(val[n-1]+fn(W-wt[n-1], wt, val, n-1), fn(W, wt, val, n-1));
        }else{
            return t[n][W] = fn(W, wt, val, n-1);
        }
    }
}