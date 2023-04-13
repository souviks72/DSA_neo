//https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14
//https://practice.geeksforgeeks.org/problems/rod-cutting0840/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
class Solution{
    public int cutRod(int price[], int l) {
        int n = price.length;
        int s = price[n-1];
        int[][] t = new int[l+1][l+1];
        for(int i=0;i<=l;i++){
            for(int j=0;j<=l;j++){
                t[i][j] = -1;
            }
        }
        
        return fn(price,l,l,t);
    }
    
    public int fn(int price[], int n, int l, int t[][]){
        if(n==0) return 0;
        if(t[n-1][l]!=-1) return t[n-1][l];
        
        if(n<=l){
            return t[n-1][l] = Math.max(price[n-1] + fn(price,n,l-n,t), fn(price,n-1,l,t));
        }else{
            return t[n-1][l] = fn(price,n-1,l,t);
        }
    }
}