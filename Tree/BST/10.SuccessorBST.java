/* BST Node
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/
https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
https://www.youtube.com/watch?v=SXKAD2svfmI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=50
// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       s.succ = inorderSuccessor(root,key);
       p.pre = pred(root,key);
    }
    
    public static Node pred(Node root, int key){
        Node ans = null;
        while(root!=null){
            if(key<=root.data) root = root.left;
            else{
                ans = root;
                root = root.right;
            }
        }
        return ans;
    }
    
    public static Node inorderSuccessor(Node root,int key){
      Node ans = null;
      while(root!=null){
          if(key>=root.data) root = root.right;
          else{
              ans = root;
              root = root.left;
          }
      }
      return ans;
    }
}