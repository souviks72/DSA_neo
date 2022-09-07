//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313
//https://www.youtube.com/watch?v=KtpqeN0Goro&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=3
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        long sum = 0;
        for(int i=0;i<k;i++){
            sum += arr.get(i);
        }
        
        long max = sum;
       
        for(int i=k;i<n;i++){
            sum = sum + arr.get(i) - arr.get(i-k);
            max = Math.max(max,sum);
            
        }
        
        return max;
    }
}