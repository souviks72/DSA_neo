//https://www.geeksforgeeks.org/search-almost-sorted-array/
//https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int arr[] = { 3, 2, 10, 4, 40 };
        int n = arr.length;
        int x = 4;
        int res = binAlmostSearch(arr,x,n-1);
        System.out.println(res);
	}
	
	static int binAlmostSearch(int[] arr, int x, int n){
	    int start =0, end = n;
	    while(start<=end){
	        int mid = start +(end-start)/2;
	        
	        if(arr[mid]==x) return mid;
	        else if(mid-1>=start && arr[mid-1]==x) return mid-1;
	        else if(mid+1<=end && arr[mid+1]==x) return mid+1;
	        else if(x<arr[mid]){
	            end=mid-1;
	        }else{
	            start=mid+1;
	        }
	    }
	    return -1;
	}
}