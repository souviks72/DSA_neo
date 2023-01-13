//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
//https://www.youtube.com/watch?v=0FtVY6I4pB8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=24

//Using the concept of VerticalOrder Traversal, in tree map add the last node at any column/vertical level(x)

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(new TreeNode(root,0));
        
        while(q.size()!=0){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode node = q.remove();
                int x = node.x;
                int data = node.root.data;
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