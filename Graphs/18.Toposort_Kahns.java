//https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
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
        int i=0;
        while(!q.isEmpty()){
            int x = q.remove();
            topo[i++] = x;
            ArrayList<Integer> arr = adj.get(x);
            for(int j=0;j<arr.size();j++){
                indegree[arr.get(j)]--;
                if(indegree[arr.get(j)]==0)
                    q.add(arr.get(j));
            }
        }
        
        return topo;
    }
}
