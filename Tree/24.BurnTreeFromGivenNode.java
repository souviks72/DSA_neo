/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
https://www.codingninjas.com/codestudio/problems/time-to-burn-tree_630563?source=youtube&amp;campaign=Striver_Tree_Videos&amp;utm_source=youtube&amp;utm_medium=affiliate&amp;utm_campaign=Striver_Tree_Videos&leftPanelTab=1
https://www.youtube.com/watch?v=2r5wLmQfD6g&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=32
*********************************************************/
import java.util.*;
public class Solution
{
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        if(root==null) return 0;
        HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        BinaryTreeNode<Integer> init = markParents(parentMap, root, start);
    
        HashSet<BinaryTreeNode<Integer>> visited = new HashSet<>();
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.add(init);
        visited.add(init);
        int time=0;
        while(q.size()!=0){
            int s = q.size();
            int level=0;
            for(int i=0;i<s;i++){
                BinaryTreeNode<Integer> node = q.remove();
                if(node.left!=null && !visited.contains(node.left)){
                    level=1;
                    q.add(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    level=1;
                    q.add(node.right);
                    visited.add(node.right);
                }
                
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    level=1;
                    q.add(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            time += level;
        }
        return time;
    }
    
    public static BinaryTreeNode<Integer> markParents(HashMap<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> parentMap, BinaryTreeNode<Integer> root, int start){
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        BinaryTreeNode<Integer> res = new BinaryTreeNode<>(-1);
        q.add(root);
            while(q.size()!=0){
            int s = q.size();
            for(int i=0;i<s;i++){
                BinaryTreeNode<Integer> node = q.remove();
                if(node.data == start) res = node;
                if(node.left!=null){
                    q.add(node.left);
                    parentMap.put(node.left,node);
                }
                if(node.right!=null){
                    q.add(node.right);
                    parentMap.put(node.right,node);
                }
            }
        }
        return res;
    }
}