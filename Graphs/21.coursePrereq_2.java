//https://practice.geeksforgeeks.org/problems/course-schedule/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=course-schedule
//https://www.youtube.com/watch?v=WAOfKpxYHR8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=24
class Solution
{
    static int[] findOrder(int v, int m, ArrayList<ArrayList<Integer>> prereq) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        //int m = prereq.size();
        for(int i=0;i<m;i++){
            adj.get(prereq.get(i).get(1)).add(prereq.get(i).get(0));
        }
        
        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            ArrayList<Integer> arr = adj.get(i);
            for(int j=0;j<arr.size();j++){
                indegree[arr.get(j)]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        
        int[] topo = new int[v];
        int p=0;
        while(!q.isEmpty()){
            int x = q.remove();
            topo[p++]=x;
            
            ArrayList<Integer> arr = adj.get(x);
            for(int i=0;i<arr.size();i++){
                indegree[arr.get(i)]--;
                if(indegree[arr.get(i)]==0)
                    q.add(arr.get(i));
            }
        }
        
        
        if(p==v) return topo;
        int[] ar= {};
        return ar;
    }
}