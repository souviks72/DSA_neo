//https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1?page=2&category[]=Searching&sortBy=submissions
//https://www.youtube.com/watch?v=Ru_HhBFV3Xo&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=6
class Solution{
    public int count(int arr[], int n, int x){
        int start=0,end=n-1;
        int mid = start+(int)Math.floor((end-start)/2);
        int f = first(arr,start,mid,end,x);
        int l = last(arr,start,mid,end,x);
       
        if (f==-1){
            return 0;
        }
        
        return l-f+1;
    }
    
    public int first(int[] arr,int start,int mid,int end,int x){
        int res=-1;
        while(start<=end){
            if(arr[mid]==x){
                res=mid;
                end=mid-1;
            }else if(x<arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
            mid=start+(int)Math.floor((end-start)/2);
        }
        return res;
    }
    
    public int last(int[] arr,int start,int mid,int end,int x){
        int res=-1;
        while(start<=end){
            if(arr[mid]==x){
                res=mid;
                start=mid+1;
            }else if(x<arr[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
            mid=start+(int)Math.floor((end-start)/2);
        }
        return res;
    }
}