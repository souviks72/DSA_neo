//https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x2041/1?page=3&category[]=Searching&sortBy=submissions
//https://www.youtube.com/watch?v=zr_AoTxzn0Y&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=5
class Solution{
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        int start=0,end=n-1;
        int mid = start+(int)Math.floor((end-start)/2);
        int f = first(arr,start,mid,end,x);
        int l = last(arr,start,mid,end,x);
        ArrayList<Integer> ls = new ArrayList<>();
        if (f==-1){
            ls.add(-1);
            return ls;
        }
        ls.add(f);
        ls.add(l);
        return ls;
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
