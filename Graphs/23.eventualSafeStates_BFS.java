//https://leetcode.com/problems/find-eventual-safe-states/
//https://www.youtube.com/watch?v=uRbJ1OF9aYM&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=21
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<v;i++){
            revAdj.add(new ArrayList<Integer>());
        }
        
        //constructing reverse adjacency matrix
        int[] indegree = new int[v];
         Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            int[] ar = graph[i];
            for(int j=0;j<ar.length;j++){
                revAdj.get(ar[j]).add(i);
                indegree[i]++;
            }
        }
        
        //start toposort, only those that can be toposrted are safe states
        for(int i=0;i<v;i++){
            if(indegree[i]==0)
                q.add(i);
        }

        List<Integer> safeStates = new ArrayList<>();
        while(!q.isEmpty()){
            int x = q.remove();
            safeStates.add(x);

            ArrayList<Integer> arr = revAdj.get(x);
            for(int j=0;j<arr.size();j++){
                indegree[arr.get(j)]--;

                if(indegree[arr.get(j)]==0)
                    q.add(arr.get(j));
            }

        }
        Collections.sort(safeStates);
        return safeStates;
    }       
}