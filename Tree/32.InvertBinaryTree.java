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
https://leetcode.com/problems/invert-binary-tree/
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        fn(root);
        return root;
    }

    public void fn(TreeNode root){
        if(root==null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        fn(root.left);
        fn(root.right);
    }
}