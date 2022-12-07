//https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
//https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9
class Solution{
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        int[] left = maxLeft(arr,n);
        int[] right = maxRight(arr,n);
        
        long sum=0;
        int[] water = new int[n];
        for(int i=0;i<n;i++){
            water[i] = Math.min(left[i],right[i]) - arr[i];
            sum += water[i];
        }
        
        return sum;
    } 
    
    static int[] maxLeft(int[] arr, int n){
        int[] ans = new int[n];
        ans[0] = arr[0];
        for(int i=1;i<n;i++){
            ans[i] = Math.max(ans[i-1],arr[i]);
        }
        
        return ans;
    }
    
    static int[] maxRight(int[] arr, int n){
        int[] ans = new int[n];
        ans[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            ans[i] = Math.max(ans[i+1],arr[i]);
        }
        
        return ans;
    }
}