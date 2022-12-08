//https://leetcode.com/problems/longest-substring-without-repeating-characters
//https://www.youtube.com/watch?v=qtVh-XEpsJo&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=7    (TakuUForward)
//https://www.youtube.com/watch?v=L6cffskouPQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=11  (Aditya Verma)
//-------------ALSO A SLIDING WINDOW PROBLEM------------------------
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0, count=0,i=0, j=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        while(i<=j && j<s.length()){
            char ch = s.charAt(j);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            if(hm.size() == j-i+1){
                max = Math.max(max,j-i+1);
            }else if(hm.size()< j-i+1){
                while(hm.size()< j-i+1){
                    char cx = s.charAt(i);
                    int freq = hm.get(cx);
                    if(freq == 1)
                        hm.remove(cx);
                    else{
                        hm.put(cx,freq-1);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}