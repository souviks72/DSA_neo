//https://leetcode.com/problems/is-graph-bipartite
//https://www.youtube.com/watch?v=-vu34sct1g8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17
class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        for(int i=0;i<v;i++){
            colors[i] = -1;
        }

        for(int i=0;i<v;i++){
            if(colors[i]==-1 && check(i,graph,colors)==false)
                return false;
        }

        return true;
    }

    public boolean check(int start, int[][] graph, int[] colors){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = 0;
        while(!q.isEmpty()){
            int x = q.remove();
            System.out.println(x);
            int[] arr = graph[x];
            for(int i=0;i<arr.length;i++){
                int y = arr[i];
                if(colors[y]==-1){
                    q.add(y);
                    colors[y] = 1-colors[x];
                    System.out.println(y+" "+colors[y]);
                }else if(colors[y]==colors[x]){
                    for(int ii=0;ii<colors.length;ii++){
                        System.out.print(colors[ii]+" ");
                    }
                    System.out.println();
                    return false;
                }
            }
        }
        return true;
    }
}