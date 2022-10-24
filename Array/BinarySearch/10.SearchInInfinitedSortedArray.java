//https://www.youtube.com/watch?v=FzvK5uuaki8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=14
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//WHILE TESTING, SEARCH FOR ELEMENTS IN THE STARTING OF ARRAY ONLY AS "END" INCREASES EXPONENTIALLY AND WE WILL END UP OUT OF BOUNDS
import java.io.*;
import java.util.*;

class GFG{
    static int search(int[] arr, int x){
        int start=0,end=1;
        while(arr[end]<x){
            start = end;
            end = end*2;
        }

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

    public static void main(String[] args)
    {
        int arr[] = { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,29};
        int x = 6;
        int index = search(arr,x);
        if (index == -1)
            System.out.println(x+ " doesn't exist in array");
        else
            System.out.println("Index of " + x + " is " + index);
    }
}