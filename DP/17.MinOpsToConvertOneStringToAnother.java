//https://leetcode.com/problems/delete-operation-for-two-strings
//https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
class Solution {
    public int minDistance(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int t[][] = new int[l1+1][l2+1];
        for(int i=0;i<l1+1;i++)
            t[i][0] = 0;
        for(int j=0;j<l2+1;j++)
            t[0][j] = 0;

        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        int lcs = t[l1][l2];
        return (l2-lcs) + (l1-lcs);
    }
}