//https://leetcode.com/problems/making-a-large-island
//https://www.youtube.com/watch?v=lgiz0Oup6gM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=52
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,1,-1};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;

                for(int k=0;k<4;k++){
                    int nr = dr[k]+i;
                    int nc = dc[k]+j;

                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1){
                        int node = i*n+j;
                        int adjNode = nr*n+nc;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }
        
        int mx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                HashSet<Integer> hs = new HashSet<>();
                for(int k=0;k<4;k++){
                    int nr = dr[k] + i;
                    int nc = dc[k] + j;

                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 1){
                        int adjNode = nr*n + nc;
                        int adjNodePar = ds.findUPar(adjNode);
                        hs.add(adjNodePar);
                    }
                }
                int sizeTotal = 0;
                for(Integer s: hs){
                    sizeTotal += ds.size.get(s);
                }
                mx = Math.max(mx, sizeTotal+1);
            }
        }

        for(int i=0;i<n*n;i++){
            int size = ds.size.get(ds.findUPar(i));
            mx = Math.max(mx,size);
        }

        return mx;
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