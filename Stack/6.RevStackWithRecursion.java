import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    
	public static void main (String[] args) {
	    Stack<Integer> st = new Stack<Integer>();
	    st.push(1);
	    st.push(2);
	    st.push(3);
	    st.push(4);
	    st.push(5);
	    revStack(st);
	    
	    while(!st.empty()){
	        System.out.println(st.pop());
	    }
	}
	
	public static void revStack(Stack<Integer> st){
	    if (st.size()==1)//because a single element stack is both reverse and forward
	        return;
	        
	   int x = st.pop();
	   revStack(st);
	   insertIntoRevStack(st, x);
	}
	
	public static void insertIntoRevStack(Stack<Integer> st, int temp){
	    if (st.empty() ){
	        st.push(temp);
	        return;
	    }
	    
	    int v = st.pop();
	    insertIntoRevStack(st,temp);
	    st.push(v);
	}
	
}