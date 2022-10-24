//https://www.includehelp.com/icp/maximum-value-in-a-bitonic-array.aspx
//https://www.youtube.com/watch?v=BrrZL1RDMwc&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=18
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

    public static void main(String[] args)
    {
        int arr[] = { 6,7,8,9,5,4,3,2};
        int index = peakBitonic(arr);
        if (index == -1)
            System.out.println("NO PEAK");
        else
            System.out.println("Peak is "+ index);
    }
}