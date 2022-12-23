//https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
//https://www.youtube.com/watch?v=_k_c9nqzKN0&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=9
class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        
        long sum = 0;
        while(pq.size()!=1){
            long x = pq.poll();
            long y = pq.poll();
            sum += x+y;
            pq.add(x+y);
        }
        
        return sum;
    }
}