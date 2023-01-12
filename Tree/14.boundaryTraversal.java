// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }
//https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
//https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=21
class Solution
{
    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<Integer> ar2 = new ArrayList<>();
    
	ArrayList <Integer> boundary(Node root)
	{   
	    arr.add(root.data);
	    if(root.left!=null)
	        getLeftBoundary(root.left);
	        
        getLeaves(root.left);
        getLeaves(root.right);
        
        if(root.right!=null)
            getRightBoundary(root.right);
        for(int i=ar2.size()-1;i>=0;i--){
            arr.add(ar2.get(i));
        }
        return arr;
	}
	
	public void getLeaves(Node root){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
            arr.add(root.data);
        getLeaves(root.left);
        getLeaves(root.right);
    }
    
    public void getLeftBoundary(Node root){
        if (root == null)
            return;
        if(root.left==null && root.right==null)
            return;
        arr.add(root.data);
        if(root.left!=null) 
            getLeftBoundary(root.left);
        else 
            getLeftBoundary(root.right);
    }
    
    public void getRightBoundary(Node root){
        if (root == null)
            return;
        if(root.left==null && root.right==null)
            return;
        ar2.add(root.data);
        if(root.right!=null) 
            getRightBoundary(root.right);
        else 
            getRightBoundary(root.left);
    }
}
