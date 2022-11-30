import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int arr[] = { 3, 2, 10, 4, 40 };
        int n = arr.length;
        int[] ans = nsr(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
	}
	
	static int[] nsr(int[] arr,int n){
	    int[] ans = new int[n];
	    Stack<Integer> st = new Stack<>();
	    
	    for(int i=n-1;i>=0;i--){
	        int x = arr[i];
	        if(st.empty()){
	            ans[i] = -1;
	        }else if(!st.empty()){
	            while(!st.empty() && st.peek()>=x){
	                st.pop();
	            }
	            if(st.empty()){
	                ans[i] = -1;
	            }else{
	                ans[i] = st.peek();
	            }
	        }
	        st.push(x);
	    }
	    return ans;
	}
}