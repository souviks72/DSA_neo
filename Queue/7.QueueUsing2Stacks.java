//https://www.youtube.com/watch?v=3Et9MrMc02A&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=4
//https://leetcode.com/problems/implement-queue-using-stacks/
class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        while(!s2.empty())
            s1.push(s2.pop());
        s1.push(x);
        while(!s1.empty())
            s2.push(s1.pop());
    }
    
    public int pop() {
        return s2.pop();
    }
    
    public int peek() {
        return s2.peek();
    }
    
    public boolean empty() {
        return s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */