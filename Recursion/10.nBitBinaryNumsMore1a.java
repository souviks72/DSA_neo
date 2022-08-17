//https://practice.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1

class Solution {
    ArrayList<String> NBitBinary(int N) {
        ArrayList<String> ls = new ArrayList<>();
        String s = "1";
        generate(ls,s,N,1,0);
        return ls;
    }
    
    public void generate(ArrayList<String> ls, String s, int n,int ones, int zeros){
       if (ones+zeros == n){
           ls.add(s);
           return;
       }
        
        if (ones > zeros){
            String t1 = s+"0";
            String t2 = s+"1";
            generate(ls,t2,n,ones+1,zeros);
            generate(ls,t1,n,ones,zeros+1);
            
        }else if (ones == zeros){
            String t2 = s+"1";
            generate(ls,t2,n,ones+1,zeros);
        }
    }
}