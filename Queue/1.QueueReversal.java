//https://practice.geeksforgeeks.org/problems/queue-reversal/1
//https://www.youtube.com/watch?v=_gJ3to4RyeQ&t=2s
class GfG{
    //Function to reverse the queue.
    public Queue<Integer> rev(Queue<Integer> q){
        
        Stack<Integer> st = new Stack<>();
        while(q.size()!=0){
            int x = q.remove();
            st.push(x);
        }
        
        while(!st.empty()){
            q.add(st.pop());
        }
        
        return q;
    }
}
hrqcvsvszpsjammdrw