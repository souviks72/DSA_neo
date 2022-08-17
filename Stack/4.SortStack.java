import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    
	public static void main (String[] args) {
	    List<Integer> arr = new ArrayList<Integer>();
	    arr.add(5);
	    arr.add(2);
	    arr.add(4);
	    arr.add(10);
	    arr.add(7);
	    arr.add(6);
	    arr.add(8);
	    
	    Stack<Integer> st = new Stack<Integer>();
	    st.push(5);
	    st.push(10);
	    st.push(9);
	    st.push(2);
	    st.push(20);
	    sortStack(st);
	    
	    while(!st.empty()){
	        System.out.println(st.pop());
	    }
	}
	
	public static void sortStack(Stack<Integer> st){
	    if (st.size() == 1){
	        return;
        }
        
        int temp = st.pop();
        sortStack(st);
        insertIntoSortedStack(st,temp);
	}
	
	public static void insertIntoSortedStack(Stack<Integer> st, int temp){
	    if (st.empty() || st.peek()<temp){
	        st.push(temp);
	        return;
	    }
	    
	    int v = st.pop();
	    insertIntoSortedStack(st,temp);
	    st.push(v);
	}
	
	public static void sortArray(List<Integer> arr){
	    if (arr.size() == 1){
	        return;
	    }
	    
	    int temp = arr.get(arr.size()-1);
	    arr.remove(arr.size()-1);
	    sortArray(arr);
	    insertIntoSortedArr(arr,temp);
	}
	
	public static void insertIntoSortedArr(List<Integer> arr, int temp){
	    if (arr.size() == 0 || arr.get(arr.size()-1) <= temp){
	        arr.add(temp);
	        return;
	    }
	    
	    int val = arr.get(arr.size()-1);
	    arr.remove(arr.size()-1);
	    insertIntoSortedArr(arr,temp);
	    arr.add(val);
	}
}