//https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
//https://www.youtube.com/watch?v=_gJ3to4RyeQ&t=2s
class Solution
{
    public String FirstNonRepeating(String s)
    {
        // code here
        Queue<Character> q = new LinkedList<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        String t = "";
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
            q.add(ch);
            while(q.size()!=0){
                if(hm.get(q.peek())>1){
                    q.remove();
                }else{
                    t+=q.peek();
                    break;
                }
            }
            
            if(q.size()==0)
                t+="#";
        }
        
        return t;
    }
}