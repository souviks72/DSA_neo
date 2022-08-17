//https://www.interviewbit.com/problems/generate-all-parentheses-ii/
public class Solution {
    ArrayList<String> arr = new ArrayList();
    public ArrayList<String> generateParenthesis(int A) {
        gen(A,A,"");
        return arr;
    }
    
    public void gen(int open,int close,String s){
        if(open == 0 && close == 0){//BASE Condition
            arr.add(s);
            return;
        }


        if(open == close){
            s+="(";
            gen(open-1,close,s);
        }else if(open < close){
            if(open!=0){
                String s1 = s+"(";
                String s2= s+")";
                gen(open-1,close,s1);
                gen(open,close-1,s2);
            }else if(open==0){
                String s1 = s+")";
                gen(open,close-1,s1);
            }
        } 
    }
}