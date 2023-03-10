//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
//https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=45
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here.
	    int sum=0;
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.wt - y.wt);
	    boolean[] visited = new boolean[V];
	    pq.add(new Pair(0,0));
	    
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    
	    for(int i=0;i<edges.length;i++){
	        int v = edges[i][0];
	        int u = edges[i][1];
	        int wt = edges[i][2];
	        
	        adj.get(u).add(new Pair(v,wt));
	        adj.get(v).add(new Pair(u,wt));
	    }
	    
	    while(!pq.isEmpty()){
	        Pair p = pq.remove();
	        if(visited[p.node]) continue;
	        visited[p.node] = true;
	        sum += p.wt;
	        
	        for(Pair q: adj.get(p.node)){
	            if(!visited[q.node]){
	                pq.add(q);
	            }
	        }
	    }
	    
	    return sum;
	}   
}

class Pair{
    int node, wt;
    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}