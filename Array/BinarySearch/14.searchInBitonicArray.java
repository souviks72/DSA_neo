//https://www.geeksforgeeks.org/find-element-bitonic-array/
//https://www.youtube.com/watch?v=IjaP8qt1IYI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=19
import java.io.*;
import java.util.*;
class GFG{
    static int peakBitonic(int[] arr){
        int n = arr.length;
        int start=0,end=n-1;
        
        if(n==1) return arr[0];
        if(arr[0]>arr[n-1]) return arr[0];
        else if(arr[n-1]>arr[n-2]) return arr[n-1];
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
                return arr[mid];
            }else if(arr[mid]<arr[mid+1] && arr[mid]>arr[mid-1]){//increasing zone
                start=mid+1;
            }else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){//decreasing zone
                end=mid-1;
            }
        }
       
        return -1;
    }
    
    public static int binSearchAsc(int[] arr,int x){
        int n = arr.length;
        int start = 0, end=n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==x){
                return mid;
            }else if(x<arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    
    public static int binSearchDesc(int[] arr,int x){
        int n = arr.length;
        int start = 0, end=n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==x){
                return mid;
            }else if(x<arr[mid]){
                start=mid+1;;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int arr[] = { 6,7,8,9,5,4,3,2};
        int peak = peakBitonic(arr);
        int x=2;
        int index=Math.max(binSearchDesc(arr,x), binSearchAsc(arr,x));
        if (index == -1)
            System.out.println("NOT FOUND");
        else
            System.out.println("Found At "+ index);
    }
}