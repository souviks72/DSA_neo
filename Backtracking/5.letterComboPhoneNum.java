//https://leetcode.com/problems/letter-combinations-of-a-phone-number
//https://www.youtube.com/watch?v=0snEunUacZY&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=6
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<String>();
        }
        HashMap<String,String> hm = new HashMap<>();
        hm.put("2","abc");
        hm.put("3","def");
        hm.put("4","ghi");
        hm.put("5","jkl");
        hm.put("6","mno");
        hm.put("7","pqrs");
        hm.put("8","tuv");
        hm.put("9","wxyz");
        
        List<String> ls = new ArrayList<>();
        String s = "";
        dfs(ls,s,digits,hm,0);
        return ls;
    }
    
    public void dfs(List<String> ls, String s, String digits, HashMap<String,String> hm, int i){
        if (s.length() == digits.length()){
            ls.add(s);
            return;
        }
        
        String digit = digits.charAt(i)+"";
        String letters = hm.get(digit);
        
        for(int j=0;j<letters.length();j++){
            char ch = letters.charAt(j);
            String t = s+ch;
            dfs(ls,t,digits,hm,i+1);
            t = t.substring(0,t.length()-1);
        }
    }
}