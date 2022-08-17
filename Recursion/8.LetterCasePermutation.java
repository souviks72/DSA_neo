//https://leetcode.com/problems/letter-case-permutation/
class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ls = new ArrayList<String>();
        permute(ls,s,"");
        return ls;
    }
    
    public void permute(List<String> ls,String s,String t){
        if (s.length()==0){
            ls.add(t);
            return;
        }
        
        char ch = Character.toLowerCase(s.charAt(0));
        String t1=t, t2=t;
        String s2 = s.substring(1);
        t1 += ch;
        if (Character.isDigit(ch)){
             permute(ls,s2,t1);
        }else{
            t2 += Character.toUpperCase(ch);
            permute(ls,s2,t1);
            permute(ls,s2,t2);
        }
    }
}