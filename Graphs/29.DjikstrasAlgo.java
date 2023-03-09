//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implementing-dijkstra-set-1-adjacency-matrix
//https://www.youtube.com/watch?v=V6H1qAeB-l4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=32

//WILL FAIL FOR NEGATIVE EDGES
//WILL TIME OUT FOR NEGATIVE CYCLES
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.d-y.d);
        
        int dist[] = new int[V];
        for(int i=0;i<V;i++) dist[i] = (int)(1e9);
        
        dist[S]=0;
        pq.add(new Pair(S,0));
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int u = p.v;
            int dis = p.d;
            
            for(int i=0;i<adj.get(u).size();i++){
                int v = adj.get(u).get(i).get(0);
                int d = adj.get(u).get(i).get(1);
                
                if(dis+d < dist[v]){
                    dist[v] = dis+d;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        
        return dist;
    }
}

class Pair{
    int v,d;
    Pair(int v, int d){
        this.v = v;
        this.d = d;
    }
}