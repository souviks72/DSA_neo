//https://www.youtube.com/watch?v=FYrl7iz9_ZU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=49
//https://practice.geeksforgeeks.org/problems/connecting-the-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=connecting-the-graph
class Solution {

    public int Solve(int n, int[][] edge) {
        DisjointSet ds = new DisjointSet(n);
        
        int extraEdges=0;
        for(int i=0;i<edge.length;i++){
            int u = edge[i][0];
            int v = edge[i][1];
            if(ds.findUPar(u) != ds.findUPar(v))
                ds.unionBySize(u, v);
            else
                extraEdges++;
        }
        
        int cnt=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) cnt++;
        }
        
        if(extraEdges+1>=cnt) return cnt-1;//to connect n component we need min n-1 edges
        return -1;
    }
}

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        
        int par = findUPar(parent.get(node));
        parent.set(node,par);
        return par;
    }
    
    public void unionBySize(int u, int v){
        int pu = findUPar(u);
        int pv = findUPar(v);
        if(pu == pv) return;
        
        if(size.get(pu) < size.get(pv)){
            parent.set(pu,pv);
            size.set(pv, size.get(pu)+size.get(pv));
        }else{
            parent.set(pv,pu);
            size.set(pu, size.get(pu)+size.get(pv));
        }
    }
}