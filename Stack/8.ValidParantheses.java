//https://leetcode.com/problems/valid-parentheses/
//https://www.youtube.com/watch?v=wkDfsKijrZ8&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=5
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2==1)
            return false;
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' ||ch=='{'||ch=='[')
                st.push(ch);
            else{
                if(st.empty() || st.peek()!=hm.get(ch))
                    return false;
                else
                    st.pop();
            }
        }
        
        return st.empty();
    }
}