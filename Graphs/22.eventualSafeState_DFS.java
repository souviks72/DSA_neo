//https://leetcode.com/problems/find-eventual-safe-states/
//https://www.youtube.com/watch?v=uRbJ1OF9aYM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=21
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;

        boolean[] visited = new boolean[v];
        boolean[] pathVisited = new boolean[v];
        boolean[] checkNodes = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i])
                dfsCheckCycle(graph, visited, pathVisited, checkNodes, i);
        }

        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(checkNodes[i])
                arr.add(i);
        }
        return arr;
    }

    public boolean dfsCheckCycle(int[][] graph, boolean[] visited, boolean[] pathVisited, boolean[] checkNodes, int start){
        visited[start] = true;
        pathVisited[start] = true;
        checkNodes[start] = false;

        int[] arr = graph[start];
        for(int i=0;i<arr.length;i++){
            int y = arr[i];
            if(!visited[y]){
                if(dfsCheckCycle(graph, visited, pathVisited, checkNodes, y)) return true;
            }else if(pathVisited[y]){
                return true;
            }
        }

        pathVisited[start] = false;
        checkNodes[start] = true;
        return false;
    }
}