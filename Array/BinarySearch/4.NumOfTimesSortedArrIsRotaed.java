//https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1?page=2&category[]=Searching&sortBy=submissions
//https://www.youtube.com/watch?v=4WmTRFZilj8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=7
class Solution
{
    int findMin(int arr[], int n)
    {
        int start=0,end=n-1;
        while(start<=end)
        {
            int mid = start+(int)Math.floor((end-start)/2);
            int next = (mid+1)%n;
            int prev = (mid-1+n)%n;
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]){
                return arr[mid];
            }else if(arr[mid]<=arr[end]){//order of checking is important
                end = mid-1;
            }else if(arr[start]<=arr[mid]){
                start=mid+1;
            }
        }
        return -1;
    }
}
