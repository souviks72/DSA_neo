//https://www.geeksforgeeks.org/stack-set-4-evaluation-postfix-expression/
class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch))
                st.push(ch-'0');
            else{
                int x=st.pop();
                int y=st.pop();
                switch(ch){
                    case '+':
                        st.push(y+x);
                        break;
                    case '-':
                        st.push(y-x);
                        break;
                    case '*':
                        st.push(y*x);
                        break;
                    case '/':
                        st.push(y/x);
                        break;
                }
            }
        }
        return st.pop();
    }
}