//https://leetcode.com/problems/longest-common-subsequence
//https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=19
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int t[][] = new int[l1+1][l2+1];
        for(int i=0;i<l1+1;i++){
            for(int j=0;j<l2+1;j++){
                t[i][j] = -1;
            }
        }

        return lcs(s1,s2,l1,l2,t);
    }

    public int lcs(String s1, String s2, int l1, int l2, int t[][]){
        if(l1==0 || l2==0)
            return 0;

        if(t[l1][l2]!=-1) return t[l1][l2];

        if(s1.charAt(l1-1)==s2.charAt(l2-1)){
            return t[l1][l2] = 1 + lcs(s1,s2,l1-1,l2-1,t);
        }else{
            return t[l1][l2] = Math.max(lcs(s1,s2,l1-1,l2,t), lcs(s1,s2,l1,l2-1,t));
        }
    }
}