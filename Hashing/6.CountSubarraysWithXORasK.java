//https://www.youtube.com/watch?v=lO9R5CaGRPY&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=5
//https://www.geeksforgeeks.org/count-number-subarrays-given-xor/
import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		int arr[] = {4, 2, 2, 6, 4};
		int m = 6;
        int n = arr.length;
        int count = countXOR(arr,n,m);
        System.out.println(count);
	}
	
	static int countXOR(int arr[], int n, int k){
	    HashMap<Integer,Integer> hm = new HashMap<>();
	    hm.put(0,1);
	    int xor=0, count = 0;
	    for(int i=0;i<n;i++){
	        xor = myXOR(xor, arr[i]);
	        if(hm.containsKey(myXOR(xor,k))){
	            count += hm.get(myXOR(xor,k));
	        }
	        hm.put(xor,hm.getOrDefault(xor,0)+1);
	    }
	    return count;
	}
	
	static int myXOR(int x, int y){
        return (x & (~y)) | ((~x )& y);
    }
}