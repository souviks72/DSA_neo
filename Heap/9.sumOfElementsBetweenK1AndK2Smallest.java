//https://practice.geeksforgeeks.org/problems/sum-of-elements-between-k1th-and-k2th-smallest-elements3133/1
//https://www.youtube.com/watch?v=3ioQQQrnw4Q&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=10
class Solution { 
    public static long sumBetweenTwoKth(long arr[], long n, long k1, long k2)
    {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k2){
                pq.poll();
            }
        }
        
        pq.poll();
        long sum=0;
        for(int i=0;i<k2-k1-1;i++){
            sum += pq.poll();
        }
        
        return sum;
    }
    
}
