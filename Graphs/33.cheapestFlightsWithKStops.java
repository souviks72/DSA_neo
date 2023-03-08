//https://leetcode.com/problems/cheapest-flights-within-k-stops
//https://www.youtube.com/watch?v=9XybHVqTHcQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=38
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];
            adj.get(u).add(new Pair(v,cost));
        }

        Queue<Tuple> q = new LinkedList<>();
        int[] costs = new int[n];
        for(int i=0;i<n;i++){
            costs[i] = (int)(1e9);
        }
        costs[src] = 0;
        q.add(new Tuple(0,0,src));

        while(!q.isEmpty()){
            Tuple t = q.remove();
            int steps = t.steps;
            int cost = t.cost;

            for(Pair p: adj.get(t.src)){
                int newCost = p.cost+cost;
                int dest = p.v;

                if(steps<=k && newCost<costs[dest]){
                    q.add(new Tuple(steps+1, newCost, dest));
                    costs[dest] = newCost;
                }
            }
        }

        if(costs[dst]<(int)(1e9)){
            return costs[dst];
        }
        return -1;
    }
}

class Tuple{
    int src, cost, steps;
    Tuple(int steps, int cost, int src){
        this.steps = steps;
        this.cost = cost;
        this.src = src;
    }
}

class Pair{
    int v,cost;
    Pair(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}