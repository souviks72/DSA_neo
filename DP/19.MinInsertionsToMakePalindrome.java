//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome
//https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=27
class Solution {
    public int minInsertions(String s1) {
        String s2 = "";
        int l = s1.length();
        for(int i=l-1;i>=0;i--){
            s2+=s1.charAt(i);
        }

        int t[][] = new int[l+1][l+1];
        for(int i=0;i<l+1;i++)
            t[i][0] = 0;
        for(int j=0;j<l+1;j++)
            t[0][j] = 0;

        for(int i=1;i<l+1;i++){
            for(int j=1;j<l+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        return l - t[l][l];
    }
}