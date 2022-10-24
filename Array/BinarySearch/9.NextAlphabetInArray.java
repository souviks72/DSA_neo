import java.util.*;
import java.io.*;
class GFG{
    static int nextChar(char[] arr, char ch){
        int res=-1,n=arr.length-1;
        int start=0,end=n;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==ch){

                if(mid<n)
                    return mid+1;
                return -1;
            }else if(ch<arr[mid]){
                res=mid;
                end=mid-1;
            }else if(ch>arr[mid]){
                start=mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        char arr[] = { 'a','b','d','f','g','j','k' };
        char x = 'k';
        int index = nextChar(arr,x);
        if (index == -1)
            System.out.println("Ceiling of " + x
                               + " doesn't exist in array");
        else
            System.out.println("ceiling of " + x + " is "
                               + arr[index]);
    }
}