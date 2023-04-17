//https://leetcode.com/problems/shortest-common-supersequence
//https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24
class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int t[][] = new int[l1+1][l2+1];

        for(int i=0;i<l1+1;i++)
            t[i][0] = 0;
        for(int j=0;j<l2+1;j++)
            t[0][j] = 0;

        for(int i=1;i<l1+1;i++){
            for(int j=1;j<l2+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }

        String lcs = "";
        int i=l1,j=l2;
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                lcs = s1.charAt(i-1) + lcs;
                i--;
                j--;
            }else{
                if(t[i-1][j]>t[i][j-1])
                    i--;
                else
                    j--;
            }
        }

        String ts = "";
        i=0;
        j=0;
        int c=0, L = t[l1][l2];
        while(i<l1 && j<l2 && c<L){
            if(s1.charAt(i)==s2.charAt(j)){
                ts += s1.charAt(i);
                i++;
                j++;
                c++;
            }else{
                while(i<l1 && s1.charAt(i) != lcs.charAt(c)){
                    ts += s1.charAt(i++);
                }
                while(j<l2 && s2.charAt(j) != lcs.charAt(c)){
                    ts += s2.charAt(j++);
                }
            }
        }

        while(i<l1)
            ts += s1.charAt(i++);
        while(j<l2)
            ts += s2.charAt(j++);

        return ts;
    }
}