//https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph-having-unit-distance
//https://www.youtube.com/watch?v=C4gxoTaI71U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=28
class Solution {
    
    public int[] shortestPath(int[][] edges,int vt,int e ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<vt;i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[vt];
        
        for(int i=0;i<vt;i++)
            dist[i] = (int)(1e9);
        
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            
            for(int it: adj.get(node)){
                if(dist[node]+1 < dist[it]){
                    dist[it] = dist[node]+1;
                    q.add(it);
                }
            }
        }
        
        for(int i=0;i<vt;i++){
            if(dist[i]==(int)(1e9))
                dist[i] = -1;
        }
        
        return dist;
    }
}
