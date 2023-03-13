//https://takeuforward.org/data-structure/kruskals-algorithm-minimum-spanning-tree-g-47/
//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    List<Edge> ls = new ArrayList<>();
	    for(int i=0;i<E;i++){
	        Edge e = new Edge(edges[i][0],edges[i][1], edges[i][2]);
	        ls.add(e);
	    }
	    
	    Collections.sort(ls);
	    
	    DisjointSet ds = new DisjointSet(V);
	    int mst = 0;
	    
	    for(int i=0;i<ls.size();i++){
	        int u = ls.get(i).src;
	        int v = ls.get(i).dest;
	        int wt = ls.get(i).weight;
	        
	        if(ds.findUPar(u) != ds.findUPar(v)){
	            mst += wt;
	            ds.unionByRank(u,v);
	        }
	    }
	    
	    return mst;
	}
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }
    
    public int findUPar(int node){
        if(parent.get(node) == node){
            return node;
        }
        
        int par = findUPar(parent.get(node));
        parent.set(node,par);
        return par;
    }
    
    public void unionBySize(int u, int v){
        int pu = findUPar(u);
        int pv = findUPar(v);
        
        if(pu==pv) return;
        if(size.get(pu) < size.get(pv)){
            parent.set(pu,pv);
            size.add(pv, size.get(pu)+size.get(pv));
        }else{
            parent.set(pv,pu);
            size.add(pu, size.get(pu)+size.get(pv));
        }
    }
    
    public void unionByRank(int u, int v){
        int pu = findUPar(u);
        int pv = findUPar(v);
        if(pu==pv) return;
        if(rank.get(pu)<rank.get(pv)){
            parent.set(pu,pv);
        }else if(rank.get(pv) < rank.get(pu)){
            parent.set(pv, pu);
        }else{
            parent.set(pv,pu);
            rank.set(pv, rank.get(pv)+1);
        }
    }
}