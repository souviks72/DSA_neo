/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//https://leetcode.com/problems/binary-tree-preorder-traversal/
//https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=10
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        preorderIterative(ls,root);
        return ls;
    }

    public void preorder(List<Integer> ls,TreeNode root){
        if(root == null)
            return;
        ls.add(root.val);
        preorder(ls,root.left);
        preorder(ls,root.right);
    }

    public List<Integer> preorderIterative(List<Integer> ls,TreeNode root){
        if(root == null)
            return ls;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.empty()){
            TreeNode x = st.pop();
            ls.add(x.val);
            if(x.right!=null) st.push(x.right);
            if(x.left!=null) st.push(x.left);
        }

        return ls;
    }
}