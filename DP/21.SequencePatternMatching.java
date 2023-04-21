//https://leetcode.com/problems/is-subsequence/description/
//https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
class Solution {
    public boolean isSubsequence(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int t[][] = new int[l1+1][l2+1];
        
        for(int i=0;i<l1+1;i++){
            for(int j=0;j<l2+1;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        return t[l1][l2]==l1;
    }
}