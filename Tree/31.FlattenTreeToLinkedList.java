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
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list
//https://www.youtube.com/watch?v=sWf7k1x9XR4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=39
 */
class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        //flattenIterative(root);
        flattenRecursive(root);
    }

    public void flattenMorris(TreeNode root){
        if(root==null)
            return;

        TreeNode cur = root;
        while(cur != null){
            if(cur.left!=null){
                TreeNode prev = cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;                
            }
            cur = cur.right;
        }
    }

    public void flattenIterative(TreeNode root){
        if(root==null)
            return;
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        st.push(cur);
        while(!st.empty()){
            TreeNode node = st.pop();
            if(node.right!=null)
                st.push(node.right);
            if(node.left!=null)
                st.push(node.left);
            if(!st.empty())
                node.right =st.peek();
            node.left=null;
        }
    }

    public void flattenRecursive(TreeNode root){
        if(root==null)
            return;

        flattenRecursive(root.right);
        flattenRecursive(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}