//https://leetcode.com/problems/palindrome-partitioning-ii
//https://www.youtube.com/watch?v=9h10fqkI7Nk&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=37
class Solution {
    public int minCut(String s) {
        int i=0,j=s.length()-1;
        
        int t[][] = new int[j+2][j+2];
        for(int x=0;x<j+2;x++){
            for(int y=0;y<j+2;y++){
                t[x][y] = -1;
            }
        }
        return solve(s,i,j,t);
    }

    public int solve(String s, int i, int j, int t[][]){
        if(i>=j) return 0;
        if(t[i][j]!=-1) return t[i][j];
        if(isPal(s,i,j)) return t[i][j] = 0;

        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int t1,t2;

            if(isPal(s,i,k)){
                if(t[i][k]!=-1) t1 = t[i][k];
                else t1 = solve(s,i,k,t);

                if(t[k+1][j]!=-1) t2 = t[k+1][j];
                else t2 = solve(s,k+1,j,t);
                
                //int x = 1 + solve(s,i,k,t) + solve(s,k+1,j,t);
                int x = 1 + t1 + t2;

                min = Math.min(min,x);
            }
            
        }

        return t[i][j] = min;
    }

    public boolean isPal(String s, int i, int j){
        if(i>=j) return true;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}