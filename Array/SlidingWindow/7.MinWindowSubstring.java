//https://leetcode.com/problems/minimum-window-substring
//https://www.youtube.com/watch?v=iwv1llyN6mo&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=13
class Solution {
    public String minWindow(String s, String t) {
        int i=0,j=0,count=0,n=s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int k=0;k<t.length();k++){
            char ch = t.charAt(k);
            
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }else{
                hm.put(ch,1);
                count++;
            }
        }
        int min = Integer.MAX_VALUE;
        int p1=0,p2=0;
        
        while(j<n){
            char ch = s.charAt(j);
            
            if(hm.containsKey(ch)){
                int v = hm.get(ch);
                hm.put(ch,v-1);
                
                if(v-1 == 0){
                    count--;
                }
            }
            
            if(count > 0){
                j++;
            }else if(count==0){
                while(count == 0){
                    char ch2 = s.charAt(i);
                    if(hm.containsKey(ch2)){
                        int v = hm.get(ch2);
                        hm.put(ch2,v+1);
                        if (v+1==1){
                            count++;
                            if(j-i+1<min){
                                min = j-i+1;
                                p1=i;
                                p2=j;
                            }
                        }
                    }
                    i++;
                }
                
                j++;
            }
        }
        
        if (min == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(p1,p2+1);
        
    }
}