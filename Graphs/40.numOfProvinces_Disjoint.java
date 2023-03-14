//https://practice.geeksforgeeks.org/problems/number-of-provinces/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-provinces
//https://www.youtube.com/watch?v=ZGr5nX-Gi6Y&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=48
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1)
                    ds.unionBySize(i,j);
            }
        }
        
        int cnt=0;
        for(int i=0;i<V;i++){
            if(ds.parent.get(i)==i) cnt++;
        }
        
        return cnt;
    }
};

class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
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
        if(pu==pv) return;
        if(size.get(pu) < size.get(pv)){
            parent.set(pu,pv);
            size.set(pv, size.get(pv)+size.get(pu));
        }else{
            parent.set(pv,pu);
            size.set(pu, size.get(pv)+size.get(pu));
        }
    }
}