//https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?page=1&category[]=Searching&sortBy=submissions
//https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21
class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[] arr,int n,int k)
    {
        if(n<k){
            return -1;
        }
        int sum=0,max=0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            max = Math.max(arr[i],max);
        }
        
        if(n==1){
            return sum;
        }
        
        int start = max, end = sum, res=-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isValid(arr,k,n,mid)){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
    }
    
    public static boolean isValid(int[] arr, int k, int n, int max){
        int students = 1;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            
            if(sum > max){
                students++;
                if(students > k){
                    return false;
                }
                sum = arr[i];
            }
        }
        
        return true;
    }
};