//https://leetcode.com/problems/is-graph-bipartite
//https://www.youtube.com/watch?v=KG5YFfR0j8A&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=18
class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        for(int i=0;i<v;i++){
            colors[i] = -1;
        }

        for(int i=0;i<v;i++){
            if(colors[i]==-1 && check(i,graph,colors,0)==false)
                return false;
        }

        return true;
    }

    public boolean check(int start, int[][] graph, int[] colors, int color){
        int[] arr = graph[start];
        colors[start] = color;
        for(int i=0;i<arr.length;i++){
            int y = arr[i];
            if(colors[start]==colors[y])
                return false;
            else if(colors[y]==-1){
                int newColor = 1-colors[start];
                boolean isBipartite = check(y,graph, colors, newColor);
                if(!isBipartite) return false;
            }
        }
        return true;
    }
}