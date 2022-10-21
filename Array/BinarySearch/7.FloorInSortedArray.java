//https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?page=1&category[]=Searching&sortBy=submissions
//https://www.youtube.com/watch?v=5cx0xerA8XY&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=10
class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        if(x==0){
            if (arr[0]==0)
                return 0;
            return -1;
        }
        
        int res=-1;
        int start = 0,end=n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == x){
                return mid;
            }else if(arr[mid]<x){
                res = mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return res;
    }
    
}
