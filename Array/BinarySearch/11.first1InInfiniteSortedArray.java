//https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/
//https://www.youtube.com/watch?v=8x6dmO6XW8k&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=14
import java.io.*;
import java.util.*;

class GFG{
    static int firstOccurence(int[] arr){
        int start=0,end=1;
        while(arr[end]<1){
            start=end;
            end=end*2;
        }

        int res=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==1){
                res=mid;
                end=mid-1;
            }else if(1<arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        int arr[] = { 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int x = 1;
        int index = firstOccurence(arr);
        if (index == -1)
            System.out.println(x+ " doesn't exist in array");
        else
            System.out.println("Index of " + x + " is " + index);
    }
}