//https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int max = -1, count=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int i=0,j=0,n=s.length();
        
        while(j<n){
            char ch = s.charAt(j);
            
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
                if(hm.get(ch)==1){
                    count++;
                }
            }else{
                hm.put(ch,1);
                count++;
            }
            
            if (count == k){
                max = Math.max(max,j-i+1);
                j++;
            }else if(count < k){
                j++;
            }else if(count>k){
                while(count>k){
                    char ch2 = s.charAt(i);
                    hm.put(ch2,hm.get(ch2)-1);
                    if(hm.get(ch2) == 0)
                        count--;
                    i++;
                }
                j++;
            }
            
        }
        return max;
    }
}