//https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
//https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29
class Solution
{
    public int LongestRepeatingSubsequence(String s)
    {
        int l = s.length();
        int t[][] = new int[l+1][l+1];
        
        for(int i=0;i<l+1;i++){
            for(int j=0;j<l+1;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i=1;i<l+1;i++){
            for(int j=1;j<l+1;j++){
                if(s.charAt(i-1)==s.charAt(j-1) && j!=i){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[l][l];
    }
}