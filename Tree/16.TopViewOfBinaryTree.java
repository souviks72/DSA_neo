//https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
//https://www.youtube.com/watch?v=Et9OCDNvJ78&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=23
/*
- Do level order traversal
- Store the first element of every column(x) in a tree map
- Print in ascending order of keys of tree map
 */
/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(root,0));
        while(q.size()!=0){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode node = q.remove();
                int x = node.x;
                int data = node.root.data;
                if(!tm.containsKey(x))
                    tm.put(x,data);
                
                if(node.root.left!=null) q.add(new TreeNode(node.root.left,x-1));
                if(node.root.right!=null) q.add(new TreeNode(node.root.right,x+1));
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        while(tm.size()!=0){
            int x = tm.firstKey();
            arr.add(tm.get(x));
            tm.remove(x);
        }
        
        return arr;
    }
}

class TreeNode{
    Node root;
    int x;
    TreeNode(Node val, int x1){
        root = val;
        x = x1;
    }
}