//ttps://leetcode.com/problems/find-peak-element
//https://www.youtube.com/watch?v=OINnBJTRrMU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=17
class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        int start=0,end=n-1;
        if(n==1){
            return 0;
        }
        if(n>1){
            if(arr[0]>arr[1]) return 0;
            else if(arr[n-1]>arr[n-2]) return n-1;
        }
        
        while(start<=end){
            int mid = start+(end-start)/2;
            System.out.println(mid);
            
            if(mid>0 && mid<n-1 && arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }else if(mid<n-1 && arr[mid]<arr[mid+1]){
                start=mid+1;
            }else{
                if (mid>0)
                    end=mid-1;
            }
            
        }
        
        return -1;
    }
}