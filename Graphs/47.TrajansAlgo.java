//https://leetcode.com/problems/critical-connections-in-a-network/
//https://takeuforward.org/graph/bridges-in-graph-using-tarjans-algorithm-of-time-in-and-low-time-g-55/

class Solution {
    int timer=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<connections.size();i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] vis = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,tin,low,vis, adj, bridges);
        return bridges;
    }

    public void dfs(int node, int parent, int[] tin, int[] low, boolean[] vis, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> bridges){
        vis[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;

        for(int it: adj.get(node)){
            if(it==parent) continue;
            if(!vis[it]){
                dfs(it, node, tin, low, vis, adj, bridges);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] > tin[node]) {
                    bridges.add(Arrays.asList(it, node));
                }
            }else{
                low[node] = Math.min(low[it], low[node]);
            }
        }
    }
}