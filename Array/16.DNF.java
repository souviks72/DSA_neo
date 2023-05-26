//https://leetcode.com/problems/sort-colors
//https://www.youtube.com/watch?v=tp8JIuCXBaU&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=21
class Solution {
    public void sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }

    public void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}