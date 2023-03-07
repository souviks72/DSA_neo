//https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-weighted-undirected-graph
//https://www.youtube.com/watch?v=rp1SMw7HSO8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=35
class Solution {
    public static List<Integer> shortestPath(int V, int E, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<E;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.wt - y.wt);
        int[] parent = new int[V+1];
        int[] dist = new int[V+1];
        for(int i=0;i<=V;i++){
            dist[i] = (int)(1e9);
            parent[i] = i;
        }
        
        pq.add(new Pair(1,0));
        dist[1] = 0;
        while(!pq.isEmpty()){
            Pair p1 = pq.remove();
            int node = p1.v;
            int wt = p1.wt;
            
            for(Pair p: adj.get(node)){
                if(dist[node] + p.wt <dist[p.v]){
                    dist[p.v] = dist[node] + p.wt;
                    pq.add(new Pair(p.v, dist[p.v]));
                    parent[p.v] = node;
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if(dist[V]==(int)(1e9)){
            path.add(-1);
            return path;
        }
        
        int node = V;
        while(parent[node]!=node){
            path.add(node);
            node = parent[node];
        }
        
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}

class Pair{
    int v,wt;
    Pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}