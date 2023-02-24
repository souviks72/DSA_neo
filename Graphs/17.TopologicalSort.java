//https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort
//https://www.youtube.com/watch?v=5lZ0iJMrUMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=21
class Solution
{
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfsTopo(adj, visited, st, i);
            }
        }
        
        int[] arr = new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
            arr[i++] = st.pop();
        }
            
        return arr;
    }
    
    public static void dfsTopo(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st, int start){
        visited[start] = true;
        ArrayList<Integer> arr = adj.get(start);
        for(int i=0;i<arr.size();i++){
            int y = arr.get(i);
            if(!visited[y])
                dfsTopo(adj,visited, st, y);
        }
        st.push(start);
    }
}
