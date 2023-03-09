/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices

https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm
https://www.youtube.com/watch?v=0vVofAhAYjc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=41
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)(1e8);
        }
        dist[S]=0;
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> arr: edges){
                int u = arr.get(0);
                int v = arr.get(1);
                int wt = arr.get(2);
                
                if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
                    dist[v] = dist[u]+wt;
                }
            }
        }
        
        //checking for negative cycle
        for(ArrayList<Integer> arr: edges){
            int u = arr.get(0);
            int v = arr.get(1);
            int wt = arr.get(2);
            
            if(dist[u] != 1e8 && dist[u]+wt < dist[v]){
                return new int[]{-1};
            }
        }
        
        return dist;
    }
}
