//https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
//https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=7
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, (a,b) -> (b.profit-a.profit));
        
        int maxDeadline=-1, jobCount=0, totalProfit=0;
        for(int i=0;i<n;i++){
            maxDeadline = Math.max(maxDeadline,arr[i].deadline);
        }
        
        int jobs[] = new int[maxDeadline+1];
        for(int i=0;i<jobs.length;i++){
            jobs[i] = -1;
        }
        
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(jobs[j]==-1){
                    totalProfit += arr[i].profit;
                    jobCount++;
                    jobs[j] = i;
                    break;
                }
            }
        }
        int ans[] = new int[2];
        ans[0] = jobCount;
        ans[1] = totalProfit;
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/