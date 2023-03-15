//https://practice.geeksforgeeks.org/problems/number-of-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-islands
//https://www.youtube.com/watch?v=Rn6B-Q4SNyA&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=51
class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet ds = new DisjointSet(rows*cols);
        boolean[][] vis = new boolean[rows][cols];
        List<Integer> ans = new ArrayList<>();
        int cnt=0;
        int len = operators.length;
        
        for(int i=0;i<len;i++){
            int r = operators[i][0];
            int c = operators[i][1];
            
            if(vis[r][c]){
                ans.add(cnt);
                continue;
            }
            
            vis[r][c] = true;
            cnt++;
            
            int[] delrow = {-1,1,0,0};
            int[] delcol = {0,0,1,-1};
            
            for(int j=0;j<4;j++){
                int nr = r+delrow[j];
                int nc = c+delcol[j];
                
                if(nr>=0 && nr<rows && nc>=0 && nc<cols){
                    if(vis[nr][nc]){
                        int node1 = r*cols+c;
                        int node2 = nr*cols+nc;
                        
                        if(ds.findUPar(node1) != ds.findUPar(node2)){
                            cnt--;
                            ds.unionBySize(node1,node2);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        
        return ans;
    }
    
}

class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }
    
    public int findUPar(int node){
        if(node==parent.get(node)){
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
        
        if(pu < pv){
            parent.set(pu,pv);
            size.set(pv, size.get(pu)+size.get(pv));
        }else{
            parent.set(pv,pu);
            size.set(pv, size.get(pu)+size.get(pv));
        }
    }
}