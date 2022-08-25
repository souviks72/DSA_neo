//https://www.youtube.com/watch?v=3jvWodd7ht0&list=PLot-Xpze53lf5C3HSjCnyFghlW0G1HHXo&index=5
//https://leetcode.com/problems/palindrome-partitioning/
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ls = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        dfs(ls,arr,s,0);
        return ls;
    }
    
    public void dfs(List<List<String>> ls, List<String> arr, String s, int i){
        if (i == s.length()){
            ls.add(new ArrayList<String>(arr));
            return;
        }
        
        for(int j=i;j<s.length();j++){
            String t = s.substring(i,j+1);
            if (isPal(t)){
                arr.add(t);
                dfs(ls,arr,s,j+1);
                arr.remove(arr.size()-1);
            }
        }
    }
    
    boolean isPal(String s){
        String t="";
        for(int i=s.length()-1;i>=0;i--){
            t += s.charAt(i);
        }
        
        if(s.equals(t))
            return true;
        return false;
    }
}