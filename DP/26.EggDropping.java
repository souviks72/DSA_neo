//https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=S49zeUjeUL0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=42
class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    int t[][] = new int[n+1][k+1];
	    for(int i=0;i<n+1;i++){
	        for(int j=0;j<k+1;j++){
	            t[i][j] = -1;
	        }
	    }
	    return solve(n,k,t);
	}
	
	public static int solve(int e,int f, int[][] t){
	    if(f==0 || f==1) return f;
	    if(e==1) return f;
	    
	    if(t[e][f]!=-1) return t[e][f];
	    int min = Integer.MAX_VALUE;
	    
	    for(int i=1;i<f;i++){
	        int n = 1 + Math.max(solve(e-1,i-1,t), solve(e,f-i,t));
	        min = Math.min(n,min);
	    }
	    return t[e][f]=min;
	}
}