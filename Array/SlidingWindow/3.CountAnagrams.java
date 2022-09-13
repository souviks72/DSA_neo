//https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/
//https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5
class Solution {

    int search(String pat, String txt) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int count = 0, ans = 0,n1=pat.length(),n2=txt.length();
        for(int i=0;i<n1;i++){
            char ch = pat.charAt(i);
            if (hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }else{
                hm.put(ch,1);
                count++;
            }
        }
        
        int i=0,j=0;
        while(j<n2){
            char ch = txt.charAt(j);
            
            if(hm.containsKey(ch)){
                int v = hm.get(ch);
                hm.put(ch,v-1);
                
                if (v-1 == 0) count--;
            }
            
            if (j-i+1<n1){
                j++;
            }else{
                if(count == 0) ans++;
                
                char ch2 = txt.charAt(i);
                if(hm.containsKey(ch2)){
                    int v = hm.get(ch2);
                    hm.put(ch2, v+1);
                    if (v==0) count++;
                }
                i++;
                j++;
            }
        }
        
        return ans;
    }
}