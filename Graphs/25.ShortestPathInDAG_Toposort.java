//https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=direct-acyclic-graph
//https://www.youtube.com/watch?v=ZUFQfFaU-8U&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=27
class Solution {

	public int[] shortestPath(int V,int e, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<V;i++){
		    adj.add(new ArrayList<Pair>());
		}
		
		for(int i=0;i<e;i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new Pair(v,wt));
		}
		
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
		    if(!visited[i])
		        dfsTopo(adj,visited,st,i);
		}
		
		int dist[] = new int[V];
		for(int i=0;i<V;i++)
		    dist[i] = (int)(1e9);
		
		dist[0]=0;  //if not given, source node is always 0
		while(!st.isEmpty()){
		    int x = st.pop();
		    
		    for(int i=0;i<adj.get(x).size();i++){
		        int v = adj.get(x).get(i).v;
		        int wt = adj.get(x).get(i).wt;
		        
		        if(dist[x]+wt < dist[v]){
		            dist[v] = dist[x]+wt;
		        }
		    }
		}
		
		for(int i=0;i<V;i++){
		    if(dist[i]==(int)(1e9))
		        dist[i]=-1;
		}
		
		return dist;
	}
	
	public void dfsTopo(ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> st, int start){
	    visited[start] = true;
	    ArrayList<Pair> arr = adj.get(start);
	    for(int i=0;i<arr.size();i++){
	        if(!visited[arr.get(i).v])
	            dfsTopo(adj,visited,st,arr.get(i).v);
	    }
	    st.push(start);
	}
}

class Pair{
    int v,wt;
    Pair(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}