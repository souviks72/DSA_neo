//https://www.youtube.com/watch?v=_-0mx0SmYxA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=40
//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)Math.pow(10,9)+7;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.t - y.t);
        int[] dist = new int[n];
        int[] ways = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            ways[i] = 0;
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int t = roads[i][2];
            
            adj.get(u).add(new Pair(v,t));
            adj.get(v).add(new Pair(u,t));
        }
        
        
        pq.add(new Pair(0,0));
        ways[0] = 1;
        dist[0] = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int u = p.v;
            int t1 = p.t;
            
            for(Pair p2: adj.get(u)){
                int v = p2.v;
                int t2 = p2.t;
                
                if(t1+t2 < dist[v]){
                    dist[v] = t1+t2;
                    pq.add(new Pair(v, dist[v]));
                    ways[v] = ways[u];
                }else if(t1+t2 == dist[v]){
                    ways[v] = (ways[v] + ways[u])%mod;
                }
            }
        }
        
        return ways[n-1]%mod;
    } 
}

class Pair{
    int v, t;
    Pair(int v, int t){
        this.v = v;
        this.t = t;
    }
}