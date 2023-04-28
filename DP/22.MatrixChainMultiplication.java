//https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34
class Solution{
    static int t[][];
    static int matrixMultiplication(int n, int arr[])
    {
        t = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                t[i][j] = -1;
            }
        }
        
        int i=1,j=n-1;
        return solve(arr,i,j);
    }
    
    public static int solve(int[] arr, int i, int j){
        if(i>=j){
            return 0;
        }
        
        if(t[i][j]!=-1) return t[i][j];
        
        int mn = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp = solve(arr,i,k) + solve(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];
            mn = Math.min(temp,mn);
        }
        return t[i][j] = mn;
    }
}