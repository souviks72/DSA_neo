import java.io.*;
import java.util.*;
class GFG{
    public static int findCeil(int[] nums, int x){
        int start=0,end=nums.length-1;
        int res=-1;
        if(x<=nums[0]){
            return 0;
        }
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]==x){
                return mid;
            }else if(x<nums[mid]){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 8, 10, 10, 12, 19 };
        int x = 19;
        int index = findCeil(arr,x);
        if (index == -1)
            System.out.println("Ceiling of " + x
                               + " doesn't exist in array");
        else
            System.out.println("ceiling of " + x + " is "
                               + arr[index]);
    }
}
