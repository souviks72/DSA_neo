/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		String s = "string";
		List<List<String>> ls = new ArrayList<>();
		List<String> arr = new ArrayList<>();
		dfs(ls,arr,s,0);
		System.out.println(ls);
		System.out.println(ls.get(0));
		for(int i=0;i<ls.size();i++){
		    List<String> ar = ls.get(i);
		    for(int j=0;j<arr.size();j++){
		        System.out.print(ar.get(0)+"   ");
		    }
		    System.out.println();
		}
	}
	
	public static void dfs(List<List<String>> ls, List<String> arr, String s, int i){
	    if (i == s.length()){
	        ls.add(new ArrayList<String>(arr));
	        return;
	    }
	    
	    for(int j=i;j<s.length();j++){
	        String t = s.substring(i,j+1);
	        arr.add(t);
	        dfs(ls,arr,s,j+1);
	        arr.remove(arr.size()-1);
	    }
	}
}