//https://leetcode.com/problems/search-in-rotated-sorted-array
//https://www.youtube.com/watch?v=Id-DdcWb5AU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=8
/*
To search in rotated sorted array we do:
1. Find index of min element
2. Min element divides the array into to sorted arrays
3. Call normal bin search on both the sorted arrays
*/
class Solution {
    public int search(int[] nums, int target) {
        int minIndex = getMinElementIndex(nums);
        if (minIndex==0){
            return binSearch(nums,target,nums.length-1,0);
        }
        return Math.max(binSearch(nums,target,minIndex-1,0),binSearch(nums,target,nums.length-1,minIndex));
    }
    
    public int binSearch(int[] arr,int x,int end,int start){
        int n = arr.length;
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
    
    public int getMinElementIndex(int[] arr){
        int n = arr.length;
        int start=0,end=n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int prev = (mid-1+n)%n;
            int next = (mid+1)%n;
            
            if(arr[mid]<=arr[next] && arr[mid]<=arr[prev]){
                return mid;
            }else if(arr[mid]<=arr[end]){
                end=mid-1;
            }else if(arr[start]<=arr[mid]){
                start=mid+1;
            }
        }
        return -1;
    }
}