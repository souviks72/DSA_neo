//https://leetcode.com/problems/longest-substring-without-repeating-characters
//https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0, count=0, i=0, j=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.length();
        while(j<n){
            char ch = s.charAt(j);
            
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
            }
            
            if(hm.size() == j-i+1){
                max = Math.max(max,j-i+1);
                j++;
            }else if(hm.size() < j-i+1){
                while(hm.size()<j-i+1){
                    char ch2 = s.charAt(i);
                    if(hm.get(ch2)==1)
                        hm.remove(ch2);
                    else if(hm.get(ch2)>1)
                        hm.put(ch2,hm.get(ch2)-1);
                    
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}