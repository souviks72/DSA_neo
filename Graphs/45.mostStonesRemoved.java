//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column
//https://www.youtube.com/watch?v=OwMNX8SPavM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=53
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow=0;
        int maxCol=0;
        for(int i=0;i<n;i++){
            maxRow = Math.max(stones[i][0], maxRow);
            maxCol = Math.max(stones[i][1], maxCol);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow,nodeCol);
            hm.put(nodeRow,1);
            hm.put(nodeCol,1);
        }

        int cnt=0;
        for(Map.Entry<Integer,Integer> it: hm.entrySet()){
            if(ds.findUPar(it.getKey()) == it.getKey()){
                cnt++;
            }
        }

        return n-cnt;
    }
}


class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n;i++){
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

        if(pu < pv){
            parent.set(pu,pv);
            size.set(pv, size.get(pu)+size.get(pv));
        }else{
            parent.set(pv,pu);
            size.set(pu, size.get(pu)+size.get(pv));
        }
    }
}