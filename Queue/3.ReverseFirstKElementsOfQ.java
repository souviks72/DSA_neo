//https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
//https://www.youtube.com/watch?v=_gJ3to4RyeQ&t=2s
class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        int i=0,n=q.size()-k;
        while(i<k){
            st.push(q.remove());
            i++;
        }
        
        while(!st.empty()){
            q.add(st.pop());
        }
        
        while(n>0){
            int x = q.remove();
            q.add(x);
            n--;
        }
        
        return q;
    }
}