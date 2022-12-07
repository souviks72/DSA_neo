//https://practice.geeksforgeeks.org/problems/special-stack/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=asf9P2Rcopo&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=10
class GfG{
    Stack<Integer> st = new Stack<>();
	public void push(int a,Stack<Integer> s){   
	    s.push(a);
	    if(st.empty()){
	        st.push(a);
	    }else{
	        if(a<=st.peek()){
	            st.push(a);
	        }
	    }
	}
	public int pop(Stack<Integer> s){
        int a = s.pop();
        if(a == st.peek()){
            st.pop();
        }
        return a;
	}
	public int min(Stack<Integer> s){
        return st.peek();
	}
	public boolean isFull(Stack<Integer>s, int n){
        return s.size() == n;
	}
	public boolean isEmpty(Stack<Integer>s){
        return s.empty();
	}
}