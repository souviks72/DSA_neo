//https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22
class Solution{
    int longestCommonSubstr(String s1, String s2, int l1, int l2){
        int t[][] = new int[l1+1][l2+1];
        int max = 0;
        
        for(int i=0;i<l1+1;i++){
            for(int j=0;j<l2+1;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        
        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                    max = Math.max(max, t[i][j]);
                }else{
                    t[i][j] = 0;
                }
            }
        }
        
        return max;
    }
}