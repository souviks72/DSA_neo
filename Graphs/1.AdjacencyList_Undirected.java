// Java code to demonstrate Graph representation
// using ArrayList in Java
//https://www.geeksforgeeks.org/graph-representation-using-java-arraylist/
//https://www.youtube.com/watch?v=OsNklbh9gYI&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=3
import java.util.*;
  
class Test {
  
    static void addEdge(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
  
    static void printAdjacencyList(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacency list of " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
  
    public static void main(String[] args)
    {
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >(V);
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());
  
        // Adding edges one by one.
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        printAdjacencyList(adj);
    }
}