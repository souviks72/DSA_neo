//https://takeuforward.org/data-structure/evaluate-boolean-expression-to-true-partition-dp-dp-52/
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int evaluateExp(String s) {
        // Write your code here.
        int i=0,j=s.length()-1;
        
        long t[][][] = new long[j+1][j+1][2];

        for(int x=0;x<j+1;x++){
            for(int y=0;y<j+1;y++){
                for(int z=0;z<2;z++){
                    t[x][y][z] = -1;
                }
            }
        }

        return (int)solve(s,i,j,1,t);
    }

    public static long solve(String s, int i, int j, int isTrue, long[][][] t){
        if(i>j) return 0;

        if(t[i][j][isTrue]!=-1) return t[i][j][isTrue];

        if(i==j){
            if(isTrue==1 && s.charAt(i)=='T') return 1;
            if(isTrue==0 && s.charAt(i)=='F') return 1;
            return 0;
        }

        long mod = (long)1e9+7;
        long ways=0;
        for(int k=i+1;k<=j-1;k=k+2){
            long lf=0,rf=0,lt=0,rt=0;
            
            if(t[i][k-1][0]!=-1) lf = t[i][k-1][0];
            else lf = solve(s,i,k-1,0,t);
            
            if(t[i][k-1][1]!=-1) lt = t[i][k-1][1];
            else lt = solve(s,i,k-1,1,t);
            
            if(t[k+1][j][0]!=-1) rf = t[k+1][j][0];
            else rf = solve(s,k+1,j,0,t);
            
            if(t[k+1][j][1]!=-1) rt = t[k+1][j][1];
            else rt = solve(s,k+1,j,1,t);
            
            // calculating answer based on operands
            char op = s.charAt(k);
            if(isTrue==1){
                if(op=='&'){
                    ways = (ways + (lt*rt)%mod)%mod;
                }else if(op=='|'){
                    ways = (ways + (lt*rt)%mod + (lt*rf)%mod + (lf*rt)%mod)%mod;
                }else if(op=='^'){
                    ways = (ways + (lt*rf)%mod + (lf*rt)%mod)%mod;
                }
            }else{
                if(op=='&'){
                    ways = (ways + (lf*rf)%mod + (lt*rf)%mod + (lf*rt)%mod)%mod;
                }else if(op=='|'){
                    ways = (ways + (lf*rf)%mod)%mod;
                }else if(op=='^'){
                    ways = (ways + (lf*rf)%mod + (lt*rt)%mod)%mod;
                }
            }
        }

        return t[i][j][isTrue]=ways;
    }
}