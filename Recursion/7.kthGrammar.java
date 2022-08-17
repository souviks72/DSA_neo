//https://leetcode.com/problems/k-th-symbol-in-grammar
//https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10
class Solution {
    public int kthGrammar(int n, int k) {
           return solve(n,k);
    }
    
    public int solve(int n,int k){
        if (n==1 && k==1)
            return 0;
        else if(n==2 && k==1)
            return 0;
        else if(n==2 && k==2)
            return 1;
        
        int mid = (int)Math.pow(2,n-1)/2;
        if (k <= mid){
            return solve(n-1,k);
        }else{
            return solve(n-1,k-mid) == 0? 1:0;
        }
    }
}